package com.mysite.webpos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
    @ResponseBody
    public String root() {
        return "�ȳ��ϼ��� webpos�� ���Ű��� ȯ���մϴ�.";
        //TODO ����ȭ�� redirect 
    }

}
