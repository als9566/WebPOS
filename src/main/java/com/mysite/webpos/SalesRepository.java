package com.mysite.webpos;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
	
	@Query(value = "select nvl(MAX(s.sales_Detail_Number),0)+1 from Sales s "
		          +" where s.sales_Number = :salesNumber "
		          +"   and s.sales_Date = :salesDate", nativeQuery = true)
	Integer findMaxDetailNumber(@Param("salesNumber") Integer salesNumber,@Param("salesDate") String salesDate);
	
	@Query(value = "select nvl(MAX(s.sales_Number),0)+1 from Sales s "
			      +" where s.sales_Date = :salesDate", nativeQuery = true)
	Integer findMaxNumber(@Param("salesDate") String salesDate);

	List<Sales> findBySalesDateAndSalesNumber(String salesDate, Integer salesNumber);
}
