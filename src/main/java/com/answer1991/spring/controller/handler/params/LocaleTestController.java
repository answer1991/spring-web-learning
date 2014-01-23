package com.answer1991.spring.controller.handler.params;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/locale")
public class LocaleTestController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(Locale locale) {
		return locale.toString();
	}
}
