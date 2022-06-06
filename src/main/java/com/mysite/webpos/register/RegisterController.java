package com.mysite.webpos.register;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.mysite.webpos.Sales;
import com.mysite.webpos.SalesService;

import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequestMapping("/register")
@RequiredArgsConstructor
@Controller
public class RegisterController {
	
	private final SalesService salesService;
	
	/*
	@RequestMapping("/sale")
	public String saleslist(Model model) {			
		SimpleDateFormat numberformat = new SimpleDateFormat("yyyyMMdd");	
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");	
		Date now = new Date();	
		Integer todayNumber = this.salesService.maxDateNumber(numberformat.format(now));
		String todayText = dateformat.format(now);
		String today = numberformat.format(now);
		model.addAttribute("todayNumber", todayNumber);
		model.addAttribute("todayText", todayText);
		model.addAttribute("today", today);
		return "sale_register";
	}
	*/	
	
	@PostMapping("/sale")
    public String saleCreate(@RequestParam String product
    						, @RequestParam Integer quantity
    						, @RequestParam String salesdate
    						, @RequestParam Integer salesnumber) {
		System.out.println(salesdate);
		salesdate = salesdate.substring(0,8);
		System.out.println(salesdate);
		this.salesService.create(product, quantity, salesdate, salesnumber);		
		return "redirect:/register/sale?salesdate="+salesdate+"&salesnumber="+salesnumber.toString();
    }  
	
	@GetMapping("/sale")
	public String saleView(@RequestParam(value = "salesdate" ,required = false) String salesdate,
						   @RequestParam(value = "salesnumber", required = false) String salesnumber,
						   Model model) {
		SimpleDateFormat numberformat = new SimpleDateFormat("yyyyMMdd");	
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");	
		
	
		if (salesdate==null && salesnumber==null) {		
			Date now = new Date();	
			Integer todayNumber = this.salesService.maxDateNumber(numberformat.format(now));
			String todayText = dateformat.format(now);
			String today = numberformat.format(now);
			model.addAttribute("todayNumber", todayNumber);
			model.addAttribute("todayText", todayText);
			model.addAttribute("today", today);
			
			return "sale_register";
		}
		else {
			List<Sales> SalesList = this.salesService.getDetailList(salesdate, Integer.parseInt(salesnumber));
			StringBuilder sb = new StringBuilder(10);
			sb.append(salesdate.substring(0, 4));
			sb.append("-");
			sb.append(salesdate.substring(4, 6));
			sb.append("-");
			sb.append(salesdate.substring(6, 8));
			model.addAttribute("todayText", sb);
			model.addAttribute("today", salesdate);
			model.addAttribute("todayNumber", salesnumber);
			model.addAttribute("SalesList", SalesList);
			
			return "sale_register";	
		}
	
	}


}
