package com.answer1991.spring.controller.mappingurl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/placeholder")
public class WithPlaceholdersController {

	@RequestMapping("/test/${controller.hello}")
	@ResponseBody
	public String test() {
		return "it works";
	}
}
