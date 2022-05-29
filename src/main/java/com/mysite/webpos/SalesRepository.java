package com.mysite.webpos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
	
	@Query("select nvl(MAX(salesDetailNumber),0)+1 from Sales "
		  +" where salesNumber = ?1 "
		  +"   and salesDate = ?2")
	Integer findBysalesNumberAndSalesDate(Integer salesNumber, String salesDate);
	
	@Query("select nvl(MAX(salesNumber),0)+1 from Sales "
			  +" where salesDate = ?1")
	Integer findBySalesDate(String salesDate);
}
