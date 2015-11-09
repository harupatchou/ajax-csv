package com.exam.csv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.exam.csv.domain.CategoriesDefene;

@Repository
@Component
public interface CategoriesRepository extends JpaRepository<CategoriesDefene,Integer> {
	
	@Query("SELECT c FROM CategoriesDefene c order by c.id")
	List<CategoriesDefene> findName();

}
