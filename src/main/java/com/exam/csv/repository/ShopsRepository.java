package com.exam.csv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.exam.csv.domain.Shops;

@Repository
@Component
public interface ShopsRepository extends JpaRepository<Shops,Integer> {
	
	@Query("SELECT s FROM Shops s order by s.id")
	List<Shops> findAll();

}
