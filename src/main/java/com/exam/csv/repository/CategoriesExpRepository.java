package com.exam.csv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.exam.csv.domain.CategoriesExp;

@Repository
@Component
public interface CategoriesExpRepository extends JpaRepository<CategoriesExp,Integer> {
	
	@Query("SELECT c FROM CategoriesExp c order by c.categoryId")
	List<CategoriesExp> findAll();

}
