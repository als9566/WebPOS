package com.mysite.webpos;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class SalesService {
	
	private final SalesRepository salesRepository;
	
	//판매세부번호 불러오기
	public Integer maxNumber(Integer Number, String SalesDate) {
		return salesRepository.findBysalesNumberAndSalesDate(Number, SalesDate);
	}	

    /*TODO 번호 불러오기 및 번호 form전송 완료시 주석해제
	public void create(Users users, Integer Number, Integer DetailNumber, String product, Integer ea) {
    	Sales sales = new Sales();
    	sales.setSalesNumber(Number);
    	sales.setSalesDetailNumber(DetailNumber);
    	sales.setProduct(product);
    	sales.setEa(ea);
    	sales.setCreateDate(LocalDateTime.now());
    	sales.setUsers(users);
        this.salesRepository.save(sales);
    }
    */    
    public void create(String product, Integer ea, String SalesDate, Integer salesnumber) {
    	Sales sales = new Sales();
    	sales.setSalesNumber(salesnumber);
    	sales.setProduct(product);
    	sales.setEa(ea);
    	sales.setSalesDate(SalesDate);
    	sales.setCreateDate(LocalDateTime.now());
    	sales.setSalesDetailNumber(maxNumber(salesnumber,SalesDate));
        this.salesRepository.save(sales);
    }

}
