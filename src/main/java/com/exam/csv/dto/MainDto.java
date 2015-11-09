package com.exam.csv.dto;

import java.util.List;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.exam.csv.domain.CategoriesDefene;
import com.exam.csv.domain.Shops;
import lombok.Data;

@Data
@Component
public class MainDto {
	
	List<Shops> shopList;
	List<CategoriesDefene> categoryList;
	
	@Id
	private Long id;
	private String name;
	private String nickname;
	private String password;
	private String categoryName;

}
