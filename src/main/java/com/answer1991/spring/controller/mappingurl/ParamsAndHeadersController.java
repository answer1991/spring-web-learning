package com.answer1991.spring.controller.mappingurl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/paramsAndHeaders")
public class ParamsAndHeadersController {
	@RequestMapping(value = "/params", params = "key=value", method = RequestMethod.GET)
	@ResponseBody
	public String testParam(@RequestParam String key) {
		return "this Controller only accept URL having params key=value";
	}
	
	@RequestMapping(value = "/headers", headers = "key=value")
	@ResponseBody
	public String testHeaders(@RequestHeader String key) {
		return "this Controller only accept request header having params key=value." + " key = " + key;
	}
}
