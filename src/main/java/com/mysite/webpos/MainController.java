package com.mysite.webpos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
    @ResponseBody
    public String root() {
        return "안녕하세요 webpos에 오신것을 환영합니다.";
        //TODO 메인화면 redirect 
    }

}
