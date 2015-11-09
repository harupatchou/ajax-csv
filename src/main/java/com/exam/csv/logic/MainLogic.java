package com.exam.csv.logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.exam.csv.controller.jsonData;
import com.exam.csv.domain.CategoriesDefene;
import com.exam.csv.domain.Shops;
import com.exam.csv.dto.MainDto;
import com.exam.csv.form.ShopsForm;
import com.exam.csv.page.ShopInCategory;
@Component
public interface MainLogic {
	
	//ストア情報の取得
    List<ShopInCategory> getData();
    //ストア情報の取得
    Boolean getStoreData(HttpServletResponse res,MainDto dto) throws Exception;
    //CSVファイルのアップロード
    List<Shops> setCsvFile(HttpServletRequest request, HttpServletResponse response,String fileName);
    //window内情報取得
    List<CategoriesDefene> getCategoryData();
    //店舗情報のinsert
	Boolean insertShop(ShopsForm shopsForm);
	//カテゴリ情報のinsert
	Boolean insertCategory(ShopsForm shopsForm);
	//ajaxによる店舗情報のinsert
	Boolean insertShopAjax(jsonData bean);
	//ajaxによるカテゴリ情報のinsert
	Boolean insertCategoryAjax(jsonData bean);
	//csv情報のinsert
	Boolean insertData(List<Shops> strTable);
	
	//ajax検索
	List<ShopInCategory> ajaxSearch(jsonData bean); 

	
}
