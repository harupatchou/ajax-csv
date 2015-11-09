package com.exam.csv.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "categories_exp")
@Data
public class CategoriesExp {
	
	/**
	 * ショップID
	 */
	@Id
	private Integer shopId;
	
	/**
	 * カテゴリーID
	 */
	private Integer categoryId;
	
	/**
	 * その他
	 */
	private String other;
}
