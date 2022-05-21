package com.mysite.webpos.register;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/register")
@Controller
public class RegisterController {
	
	@RequestMapping("/sale")
	public String list(Model model) {
		return "sale_register";
	}

}
