package com.exam.csv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.csv.controller.jsonData;
import com.exam.csv.domain.CategoriesExp;
import com.exam.csv.domain.Shops;
import com.exam.csv.page.ShopInCategory;
import com.exam.csv.repository.CategoriesExpRepository;
import com.exam.csv.repository.ShopsORRepository;
import com.exam.csv.repository.ShopsRepository;

@Service
@Component
@Transactional
public class ShopsService {
	
	@Autowired
	protected ShopsRepository shopRepository;
	@Autowired
	protected ShopsORRepository shopsORRepository;
	@Autowired
	protected CategoriesExpRepository categoriesRepository;
	
	/**
	 * 店舗情報取得
	 * @return list
	 */
	public List<ShopInCategory> findList() {
		List<ShopInCategory> list =  shopsORRepository.findList();
		return list;
	}
	
	/**
	 * 店舗情報取得(ajax)
	 * @return list
	 */
	public List<ShopInCategory>  searchAjax(jsonData bean) {
		List<ShopInCategory> list =  shopsORRepository.findByName(bean);
		return list;
	}
	
	/**
	 * CSVデータから得た情報のinsert
	 * @param shop
	 */
	public void insertData(Shops shop){
		shopRepository.save(shop);
	}
	
	/**
	 * 通常のinsert
	 * @param shopList
	 */
	public void insertShop(List<Shops> shopList){
		List<Shops> allShop = shopRepository.findAll();
		Integer sum = 0;
		for (Shops num : allShop){
			sum = num.getId();
		}
 		int insertNo = 0;
 		for (int i=0;i<shopList.size(); i++){
 			sum+=1;
			shopList.get(insertNo).setId(sum);
			insertNo += 1;
		}
 		shopRepository.save(shopList);
	}

	public void insertCategory(List<CategoriesExp> categpryList) {
		List<CategoriesExp> allCategory = categoriesRepository.findAll();
		Integer sum = 0;
		for (int i=0;i<allCategory.size(); i++){
			sum += 1;
		}
 		int insertNo = 0;
 		for (int i=0;i<categpryList.size(); i++){
 			sum+=1;
 			categpryList.get(insertNo).setShopId(sum);
			insertNo += 1;
		}
 		categoriesRepository.save(categpryList);		
	}

	public void insertShopAjax(jsonData bean) {
		List<Shops> allShop = shopRepository.findAll();
		Integer sum = 0;
		for (Shops num : allShop){
			sum = num.getId();
		}
		bean.setNo(sum+1);
		Shops ajaxInsert = new Shops();
		ajaxInsert.setId(bean.getNo());
		ajaxInsert.setName(bean.getName());
		ajaxInsert.setAddress(bean.getAddress());
		ajaxInsert.setDetail(bean.getDetail());
 		shopRepository.save(ajaxInsert);
	}
	
	public void insertCategoryAjax(jsonData bean) {
		List<Shops> allShop = shopRepository.findAll();
		Integer sum = 0;
		for (Shops num : allShop){
			sum = num.getId();
		}
		bean.setNo(sum);
		CategoriesExp ajaxInsert = new CategoriesExp();
		ajaxInsert.setCategoryId(Integer.parseInt(bean.getCategoryId()));
		ajaxInsert.setShopId(sum);
		categoriesRepository.save(ajaxInsert);
	}
	
}
