package com.mysite.webpos;

import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SalesService {
	
	private final SalesRepository salesRepository;
	
	public List<Sales> getList() {
        return this.salesRepository.findAll();
    }
	
	public List<Sales> getDetailList(String SalesDate, Integer Number) {
        return this.salesRepository.findBySalesDateAndSalesNumber(SalesDate,Number);
    }
	
	//판매번호 불러오기
	public Integer maxDateNumber(String SalesDate) {
		return salesRepository.findMaxNumber(SalesDate);
	}
	
	//판매세부번호 불러오기
	public Integer maxNumber(Integer Number, String SalesDate) {
		return salesRepository.findMaxDetailNumber(Number, SalesDate);
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
