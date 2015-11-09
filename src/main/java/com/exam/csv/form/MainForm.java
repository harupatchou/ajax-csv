package com.exam.csv.form;

import java.util.List;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.exam.csv.dto.MainDto;

import lombok.Data;

@Data
@Component
public class MainForm {
	
	List<MainDto> shopList;
	List<MainDto> categoryList;
	
	/**
	 * Users
	 */
	@Id
	private Long id;
	private String name;
	private String nickname;
	private String password;
	private String csvFile;

}
