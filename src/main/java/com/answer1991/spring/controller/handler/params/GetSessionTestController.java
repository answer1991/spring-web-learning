package com.answer1991.spring.controller.handler.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.answer1991.spring.model.Pet;

@Controller
@RequestMapping("/getSession")
@SessionAttributes("pet")
public class GetSessionTestController {

	@RequestMapping("/")
	@ResponseBody
	public String test(@ModelAttribute("pet") Pet pet) {
		return pet.getName();
	}
}
