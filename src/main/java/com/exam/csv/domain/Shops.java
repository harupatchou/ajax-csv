package com.exam.csv.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**店舗を定義するクラス
*
*/
@Entity
@Table(name = "shops")
@Data
public class Shops {

	
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
}
