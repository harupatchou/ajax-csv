package com.exam.csv.page;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**店舗を定義するクラス
*
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopInCategory {

	
	/**
	 * 店舗ID
	 */
	@Id
	private Integer id;
	
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
	 * カテゴリ名
	 */
	private String categoryName;
}
