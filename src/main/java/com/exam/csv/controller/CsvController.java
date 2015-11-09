package com.exam.csv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.csv.domain.CategoriesExp;
import com.exam.csv.domain.Shops;
import com.exam.csv.dto.MainDto;
import com.exam.csv.form.MainForm;
import com.exam.csv.logic.MainLogic;
@Controller
@RequestMapping("/user/csv")
public class CsvController {
	
	@Autowired
	protected MainDto mainDto;
	
	@Autowired
	protected MainForm mainForm;
	
	@Autowired
	protected MainLogic mainLogic;
	
	//CSVから得た店舗情報格納用
	List<Shops> strTable = new ArrayList<>();
	//CSVから得た店舗情報格納用
	List<CategoriesExp> cateStrTable = new ArrayList<>();
		
	/**
	 * MainForm初期化
	 * @return
	 */
	@ModelAttribute
	public MainForm initForm() {
		MainForm mainForm = new MainForm();
		return mainForm;
	}
	
	/**
	 * @brief csv初期表示
	 * @throws Exception 
	 */
	@RequestMapping("/csvIndex")
	String index() {
		return "/user/csv/csvMenu";
	}
	
	/**
	 * @brief ダウンロード
	 * @throws Exception 
	 */
	@RequestMapping("/download")
	private void download(HttpServletResponse res) throws Exception {
		getStoreData(res);
	}
	
	/**
	 * @brief アップロード
	 * @param request
	 * @param response
	 * @param model
	 * @param main
	 * @return user/top/csv
	 * @throws Exception
	 */
	@RequestMapping("/upload")
	String upload(HttpServletRequest request, HttpServletResponse response,Model model,MainForm main) throws Exception  {
		setCsvFile(request,response,model,main.getCsvFile());
		model.addAttribute("csvList", strTable);
		return "user/top/csv";
	}
	
	/**
	 * CSV情報insert
	 * @return redirectでトップ画面表示
	 */
	@RequestMapping("/insert")
	String insert(){
		insertData();
		return "redirect:/user/top";
	}
	
	/**
	 * ストア情報取得のためのメソッド
	 * @param res
	 * @return
	 * @throws Exception
	 */
	private Boolean getStoreData(HttpServletResponse res) throws Exception{
		//入力のコピー
		MainDto formINF = setupMainDto();
		//データの取得
		mainLogic.getStoreData(res,formINF);
		return true;
	}
	
	/**
	 * CSVファイルを外部から取得し、情報をListに格納する
	 * @param request
	 * @param response
	 * @param model
	 * @param csvFile
	 * @return
	 * @throws ServletException
	 * @throws Exception
	 */
	private Boolean setCsvFile(HttpServletRequest request, HttpServletResponse response,Model model,String csvFile) throws ServletException,Exception{
		//読み込むファイルの名前
	    String inputFileName = "c:/workspace/csv/src/main/resources/csv/"+csvFile;
	    //情報を取得
	    strTable = mainLogic.setCsvFile(request, response,inputFileName);
		return true;
	}
	
	/**
	 * insert用メソッド
	 * @return
	 */
	private Boolean insertData(){
		mainLogic.insertData(strTable);
		return true;
	}
	
	/**
	 * DTOにFormの情報を格納
	 * @return
	 */
	private MainDto setupMainDto() {
		MainDto formInf = new MainDto();
		formInf.setId(mainForm.getId());
		return formInf;
	}

}
