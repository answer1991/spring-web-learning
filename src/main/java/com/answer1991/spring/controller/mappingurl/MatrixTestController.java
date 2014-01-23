package com.answer1991.spring.controller.mappingurl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/matrix")
public class MatrixTestController {

	// test with URL /matrix/2;q=2
	@RequestMapping(value = "/simple/{petId}", method = RequestMethod.GET)
	@ResponseBody
	public String testSimple(@PathVariable Integer petId, @MatrixVariable(pathVar = "petId") Integer q) {
		return "petId : " + petId + ", q = " + q;
	}
}
