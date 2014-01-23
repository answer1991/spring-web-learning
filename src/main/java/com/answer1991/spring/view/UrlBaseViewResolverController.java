package com.answer1991.spring.view;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/urlBaseView")
public class UrlBaseViewResolverController {
	
	@RequestMapping("/test")
	public ModelAndView handle(@RequestParam(required = false) String p1) {
		System.out.println("p1");
		ModelAndView mav = new ModelAndView("hello");
		return mav;
	}
	
	@RequestMapping("/test2")
	public void handle2(HttpServletResponse response) throws IOException {
		response.sendRedirect("jsp/hello.jsp");
	}
	
}
