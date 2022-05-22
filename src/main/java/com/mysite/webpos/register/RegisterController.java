package com.mysite.webpos.register;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.webpos.SalesService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/register")
@RequiredArgsConstructor
@Controller
public class RegisterController {
	
	private final SalesService salesService;
	
	@RequestMapping("/sale")
	public String list(Model model) {
		return "sale_register";
	}
	
	@PostMapping("/sale")
    public String saleCreate(@RequestParam String product
    						, @RequestParam Integer quantity
    						, @RequestParam String salesdate
    						, @RequestParam Integer salesnumber) {
		this.salesService.create(product, quantity, salesdate, salesnumber);
		return "redirect:/register/sale";
    }

}
