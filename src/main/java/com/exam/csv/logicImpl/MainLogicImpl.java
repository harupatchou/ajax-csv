package com.exam.csv.logicImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exam.csv.controller.jsonData;
import com.exam.csv.domain.CategoriesDefene;
import com.exam.csv.domain.CategoriesExp;
import com.exam.csv.domain.Shops;
import com.exam.csv.dto.MainDto;
import com.exam.csv.form.ShopsForm;
import com.exam.csv.logic.MainLogic;
import com.exam.csv.page.ShopInCategory;
import com.exam.csv.repository.CategoriesExpRepository;
import com.exam.csv.service.CategoriesService;
import com.exam.csv.service.ShopsService;
import com.exam.csv.util.CsvUtil;

@Component
public class MainLogicImpl implements MainLogic{
	
	@Autowired
	protected ShopsService shopService;
	@Autowired
	protected CategoriesService categoriesService;
	@Autowired
	protected CategoriesExpRepository categoriesRepository;
	
	//ストアのCSV作成時のヘッダー情報
	public final String STORE_LIST = "\"店舗ID\",\"店舗名\",\"店舗住所\",\"店舗詳細\",\"カテゴリ\"";

	/**
	 * データの取得
	 */
	@Override
	public List<ShopInCategory> getData() {
	    	List<ShopInCategory> list = shopService.findList();
		return list;
	}
	
	/**
	 * カテゴリ情報の取得
	 */
	@Override
	public List<CategoriesDefene> getCategoryData() {
			List<CategoriesDefene> result = categoriesService.findList();
		return result;
	}

	/**
	 * 店舗情報を取得し、CSV形式でダウンロード
	 */
	@Override
	public Boolean getStoreData(HttpServletResponse res,MainDto dto) throws Exception {
		//CSVのファイル名
		String name = "test";
		//CSVダウンロード時の情報を入れる変数
		StringBuilder store = new StringBuilder();
		//店舗情報を取得
		List<ShopInCategory> list = shopService.findList();
		//店舗情報をCSVにするためにString型のListに格納する
		List<String> sto = new ArrayList<>();
		sto.add(STORE_LIST);
		for (ShopInCategory li : list){
			//列変更
			store = new StringBuilder();
			//取得した情報をappendでつなげていく
			store.append("\"").append(li.getId()).append("\",\"").append(li.getName()).append("\",\"").append(li.getAddress()).append("\",\"").append(li.getDetail()).append("\",\"").append(li.getCategoryName()).append("\"");
			//つなげた情報をListに格納
			sto.add(store.toString());
		}
		//ダウンロードするstaticメソッドに情報送信
		CsvUtil.download(res, sto, name);
		return true;
	}

	/**
	 * 選択されたCSVファイル内の情報を取得し、Listに格納していくメソッド
	 */
	@Override
	public List<Shops> setCsvFile(HttpServletRequest request, HttpServletResponse response,String fileName) {
		// ファイルオブジェクトの生成
	    File inputFile = new File(fileName);
	    List<String> strTable = new ArrayList<>();
   	    //CSVから得たString型の情報をList<Shops>に格納
	    List<Shops> shopList = new ArrayList<>();
	  //CSVから得たString型の情報をList<CategoriesExp>に格納
	    List<CategoriesExp> CateList = new ArrayList<>();
	    try {
	      // 入力ストリームの生成
	      FileInputStream fis = new FileInputStream(inputFile);
	      InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
	      BufferedReader br = new BufferedReader(isr);	     
	      try {
	          //ファイルの件数分ループして配列に格納
	          while (br.ready()) {
	              String line = br.readLine();
	              strTable.add(line);
	          }
	  	      for (String sss : strTable){
	  	    	 Shops a = new Shops();
	  	    	 CategoriesExp b = new CategoriesExp();
	  	    	 //splitで","区切りの情報をそれぞれ格納
	  	    	 String[] te = sss.split(",");
	  	    	 a.setId(Integer.parseInt(te[0]));
	  	    	 a.setName(te[1]);
	  	    	 a.setAddress(te[2]);
	  	    	 a.setDetail(te[3]);
	  	    	 b.setShopId(Integer.parseInt(te[0]));
	  	    	 b.setCategoryId(Integer.parseInt(te[4]));
	  	    	 shopList.add(a);
	  	    	 CateList.add(b);
	  	    }
	  	    for (CategoriesExp e : CateList){
	  	    	CategoriesExp b = new CategoriesExp();
	  	    	b.setCategoryId(e.getCategoryId());
	  	    	b.setShopId(e.getShopId());
	  	    	categoriesRepository.save(b);
	  	    }
	      }catch (FileNotFoundException e){
	          System.out.println("ファイルが見つかりません。");
	          e.printStackTrace();
	      }catch (IOException e){
	          System.out.println("入出力エラーです。");
	          e.printStackTrace();
	      }finally{
	          if(br != null){
	              try{
	                br.close();
	              }catch(IOException e) {
	                System.out.println("入出力エラーです。");
	                e.printStackTrace();
	              }
	          }
	      }
	      // 後始末
	      br.close();
	      // エラーがあった場合は、スタックトレースを出力
	    } catch(Exception e) {
	      e.printStackTrace();
	    }
		return shopList;
	}

	/**
	 * CSVファイルから得た情報をinsertするメソッド
	 */
	@Override
	public Boolean insertData(List<Shops> strTable) {
		for (Shops sss : strTable){
	    	Shops a = new Shops();
	    	a.setId(sss.getId());
	    	a.setName(sss.getName());
	    	a.setAddress(sss.getAddress());
	    	a.setDetail(sss.getDetail());
	    	shopService.insertData(a);
	    }
		return true;
	}

	@Override
	public Boolean insertShop(ShopsForm shopsForm) {
		List<Shops> shopList = new ArrayList<>();
		//プロジェクト番号でスプリット区切りの配列型に変換
		String[] shopNo = shopsForm.getNo().split(",");
		String[] name = shopsForm.getName().split(",");
		String[] address = shopsForm.getAddress().split(",");
		String[] detail = shopsForm.getDetail().split(",");
		for (String no : shopNo){
			Shops shop = new Shops();
			shop.setName(name[Integer.parseInt(no)-1]);
			shop.setAddress(address[Integer.parseInt(no)-1]);
			shop.setDetail(detail[Integer.parseInt(no)-1]);
			shopList.add(shop);
		}
		shopService.insertShop(shopList);
		return null;
	}

	@Override
	public Boolean insertCategory(ShopsForm shopsForm) {
		List<CategoriesExp> categpryList = new ArrayList<>();
		//プロジェクト番号でスプリット区切りの配列型に変換
		String[] shopNo = shopsForm.getNo().split(",");
		String[] categoryId = shopsForm.getCategoryId().split(",");
		for (String no : shopNo){
			CategoriesExp category = new CategoriesExp();
			category.setShopId(Integer.parseInt(no));
			category.setCategoryId(Integer.parseInt(categoryId[Integer.parseInt(no)-1]));
			categpryList.add(category);
		}
		shopService.insertCategory(categpryList);
		return null;
	}

	@Override
	public Boolean insertShopAjax(jsonData bean) {
		shopService.insertShopAjax(bean);
		return null;
	}
	
	@Override
	public Boolean insertCategoryAjax(jsonData bean) {
		shopService.insertCategoryAjax(bean);
		return null;
	}

	@Override
	public List<ShopInCategory> ajaxSearch(jsonData bean) {
		List<ShopInCategory> ajaxList = shopService.searchAjax(bean);
		return ajaxList;
	}

}
