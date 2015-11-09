package com.exam.csv.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exam.csv.domain.CategoriesDefene;
import com.exam.csv.dto.MainDto;
import com.exam.csv.form.ShopsForm;
import com.exam.csv.logic.MainLogic;
import com.exam.csv.page.ShopInCategory;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	protected MainDto mainDto;
	
	@Autowired
	protected ShopsForm shopsForm;
	
	@Autowired
	protected MainLogic mainLogic;
	
	public List<CategoriesDefene> categoryList;
	public List<ShopInCategory> shopList;
	
	@ModelAttribute
	public ShopsForm initForm() {
		ShopsForm shopsForm = new ShopsForm();
		return shopsForm;
	}
	
	/**
	 * @brief insert画面
	 * @param model
	 * @return insertIndex.jsp
	 */
	@RequestMapping(value="/ajax",consumes=MediaType.APPLICATION_JSON_VALUE)
	String jsonData(@RequestBody jsonData bean){
		mainLogic.insertShopAjax(bean);
		mainLogic.insertCategoryAjax(bean);
		return "redirect:/shop/insertAjaxIndex";
		
	}
	
	/**
	 * @brief 店舗登録初期画面
	 * @param model
	 * @return insertIndex.jsp
	 */
	@RequestMapping("/insertIndex")
	String insertIndex(){
		return "/shop/insert/insertIndex";
	}
	
	/**
	 * @brief ajaxによる店舗登録時画面更新
	 * @param model
	 * @return insertIndex.jsp
	 */
	@RequestMapping(value="/insertAjaxIndex")
	String insertAjaxIndex(Model model){
		List<ShopInCategory> shopList = mainLogic.getData();
		Date date = new Date();
		model.addAttribute("nowDate",date.toString());
		model.addAttribute("shopList", shopList);
		return "/shop/insert/ajax";
	}
	
	/**
	 * @brief カテゴリ選択画面
	 * @param model
	 * @return insertIndex.jsp
	 */
	@RequestMapping("/window")
	String category(Model model,String btnNo){
		getCateData();
		model.addAttribute("btnNo",btnNo);
		model.addAttribute("categoryList",categoryList);
		return "/shop/window/categorySelect";
	}
	
	/**
	 * @brief insert画面
	 * @param model
	 * @return insertIndex.jsp
	 */
	@RequestMapping("/insert")
	String insert(ShopsForm shopsForm){
		mainLogic.insertShop(shopsForm);
		mainLogic.insertCategory(shopsForm);
		return "/shop/insert/insertIndex";
	}
	
	/**
	 * @brief insert画面
	 * @param model
	 * @return insertIndex.jsp
	 */
	@RequestMapping("/insertAjax")
	String insertAjax(ShopsForm shopsForm){
		mainLogic.insertShop(shopsForm);
		mainLogic.insertCategory(shopsForm);
		return "/user/top/index";
	}
	
	/**
	 * @brief search実行処理
	 * @param model
	 * @return insertIndex.jsp
	 */
	@RequestMapping(value="/ajaxSearch",consumes=MediaType.APPLICATION_JSON_VALUE)
	String ajaxSearch(@RequestBody jsonData bean,RedirectAttributes attributes){
		shopList = mainLogic.ajaxSearch(bean);
		return "redirect:/shop/searchAjaxIndex";
	}
	
	/**
	 * @brief ajaxによる店舗登録時画面更新
	 * @param model
	 * @return insertIndex.jsp
	 */
	@RequestMapping(value="/searchAjaxIndex")
	String searchAjaxIndex(Model model){
		model.addAttribute("shopList",shopList);
		return "/shop/search/ajaxSearch";
	}
	
	/**
	 * @brief カテゴリ情報取得
	 */
	private void getCateData() {
		categoryList = new ArrayList<>();
		categoryList = mainLogic.getCategoryData();
	}
	
}
