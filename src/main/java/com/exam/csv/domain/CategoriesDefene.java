package com.exam.csv.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "categories_defene")
@Data
public class CategoriesDefene {
	
	/**
	 * カテゴリーID
	 */
	@Id
	private Integer id;
	
	/**
	 * カテゴリー名
	 */
	private String name;
}
