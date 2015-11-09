package com.exam.csv.controller;

import lombok.Data;


@Data
public class jsonData {
	
	/**
	 * 店舗ID
	 */
	private Integer no;
	
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
