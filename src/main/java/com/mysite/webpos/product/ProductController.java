package com.mysite.webpos.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/product")
@RequiredArgsConstructor
@Controller
public class ProductController {

	@RequestMapping("/search")
	public String saleslist() {			
		return "product_search";
	}
	
}
