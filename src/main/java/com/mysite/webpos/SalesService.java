package com.mysite.webpos;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class SalesService {
	
	private final SalesRepository salesRepository;
	
	//판매번호 불러오기
	public Integer maxDateNumber(String SalesDate) {
		return salesRepository.findBySalesDate(SalesDate);
	}
	
	//판매세부번호 불러오기
	public Integer maxNumber(Integer Number, String SalesDate) {
		return salesRepository.findBysalesNumberAndSalesDate(Number, SalesDate);
	}	
  
    public void create(String product, Integer ea, String SalesDate, Integer salesnumber) {
    	Sales sales = new Sales();
    	sales.setSalesNumber(salesnumber);
    	sales.setProduct(product);
    	sales.setEa(ea);
    	sales.setSalesDate(SalesDate);
    	sales.setCreateDate(LocalDateTime.now());
    	sales.setSalesDetailNumber(maxNumber(salesnumber,SalesDate));
    	//TODO 입력자(user)추가
        this.salesRepository.save(sales);
    }

}
