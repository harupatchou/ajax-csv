package com.exam.csv.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.csv.dto.MainDto;
import com.exam.csv.form.MainForm;
import com.exam.csv.logic.MainLogic;
import com.exam.csv.page.ShopInCategory;

@Controller
@RequestMapping("/user")
public class MainController {
	
	@Autowired
	protected MainDto mainDto;
	
	@Autowired
	protected MainForm mainForm;
	
	@Autowired
	protected MainLogic mainLogic;
	 
	List<ShopInCategory> shopList = new ArrayList<>();
	
	@ModelAttribute
	public MainForm initForm() {
		MainForm mainForm = new MainForm();
		return mainForm;
	}
	
	/**
	 * @brief 初期表示
	 * @param model
	 * @return index.jsp
	 */
	@RequestMapping("/top")
	String index(Model model){
		getData();
		Date date = new Date();
		model.addAttribute("lastDate",date.toString());
		model.addAttribute("shopList", shopList);
		return "/user/top/index";
	}
	
	/**
	 * @brief 店舗登録初期画面
	 * @param model
	 * @return insertIndex.jsp
	 */
	@RequestMapping("/insertIndex")
	String insert(Model model){
		
		return "/shop/insertIndex";
	}
	
	/**
	 * @brief 検索初期画面
	 * @param model
	 * @return searchIndex.jsp
	 */
	@RequestMapping("/searchIndex")
	String searchIndex(Model model){
		Date date = new Date();
		model.addAttribute("lastDate",date.toString());
		return "/shop/search/search";
	}
	
	private boolean getData(){
		// データの取得
		shopList = mainLogic.getData();
		return true;
	}


}
