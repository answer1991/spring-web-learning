package com.answer1991.spring.controller.handler.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller 是单例的 
 * @author Joe
 *
 */
@Controller
@RequestMapping("/singleton")
public class SingletonTestController {
	private Integer count = 1;
	
	@RequestMapping("/")
	@ResponseBody
	public String test() {
		count++;
		return count.toString();
	}
}
