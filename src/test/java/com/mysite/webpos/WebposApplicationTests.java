package com.mysite.webpos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;

@SpringBootTest
class WebposApplicationTests {

	@Autowired
    private SalesRepository salesRepository;
	
	@Test
	/*void contextLoads() {
		Sales q1 = new Sales();
        q1.setSalesNumber(1);
        q1.setSalesDetailNumber(1);
        q1.setProduct("테스트상품");
        q1.setEa(1);
        q1.setCreateDate(LocalDateTime.now());
        this.salesRepository.save(q1); 
	}*/
	void contextLoads() {
		salesRepository.findBysalesNumberAndSalesDate(1,"20220522");
	}
	
	

}
