package com.exam.csv.form;

import lombok.Data;

import org.springframework.stereotype.Component;

@Data
@Component
public class ShopsForm {
	
	/**
	 * 店舗ID
	 */
	private String no;
	
	/**
	 * 店舗名
	 */
	private String name;
	
	/**
	 * 住所
	 */
	private String address;
	
	/**
	 * 説明
	 */
	private String detail;
	
	/**
	 * カテゴリー
	 */
	private String categoryId;
			
	/**
	 * カテゴリー名
	 */
	private String categoryName;
	
	/**
	 * その他
	 */
	private String other;

}
