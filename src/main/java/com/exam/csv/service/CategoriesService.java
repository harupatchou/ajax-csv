package com.exam.csv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.csv.domain.CategoriesDefene;
import com.exam.csv.repository.CategoriesRepository;

@Service
@Component
@Transactional
public class CategoriesService {
	
	@Autowired
	protected CategoriesRepository categoriesRepository;
	
	/**
	 * 店舗情報取得
	 * @return list
	 */
	public List<CategoriesDefene> findList() {
		List<CategoriesDefene> list =  categoriesRepository.findName();
			return list;
	}
	
}
