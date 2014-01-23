package com.answer1991.spring.controller.mappingurl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.answer1991.pojo.Student;

@Controller
@RequestMapping("/json")
public class MultiMediaTestController {
	//  仅响应Accpet中匹配application/json的请求
	@RequestMapping(value = "/return", produces = "application/json")
	@ResponseBody
	public Student testReturn(@RequestParam String id, @RequestParam String name) {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		
		return student;
	}
	
	@RequestMapping(value = "/request", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Student testRequest(@RequestBody Student student) {
		return student;
	}
}
