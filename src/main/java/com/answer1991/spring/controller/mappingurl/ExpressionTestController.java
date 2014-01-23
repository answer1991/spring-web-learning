package com.answer1991.spring.controller.mappingurl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/expr")
public class ExpressionTestController {
	
	@RequestMapping("/test/{appName:[a-z]+}-{version:\\d\\.\\d}")
	@ResponseBody
	public String test(@PathVariable String appName, @PathVariable String version) {
		return "appName : " + appName + " , version : " + version;
	}
	
	@RequestMapping("/test/{appName:[a-z]+}-{version:\\d\\.\\d}.do")
	@ResponseBody
	public String testWithDo(@PathVariable String appName, @PathVariable String version) {
		return "with Do, appName : " + appName + " , version : " + version;
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String test() {
		return "hello";
	}
}
