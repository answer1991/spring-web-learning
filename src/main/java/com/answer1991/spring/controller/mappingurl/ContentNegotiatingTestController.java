package com.answer1991.spring.controller.mappingurl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.answer1991.pojo.Student;

@Controller
@RequestMapping("/content")
public class ContentNegotiatingTestController {
	@RequestMapping("/test")
	@ResponseBody
	public Student test() {
		Student s = new Student();
		s.setId("055574");
		s.setName("Joe");
		return s;
	}
}
