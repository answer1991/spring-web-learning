package com.answer1991.spring.controller.handler.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.answer1991.spring.model.Pet;

@Controller
@RequestMapping("/session")
@SessionAttributes("pet")
public class SessionAttributeTestController {
	@ModelAttribute("pet")
	public Pet getPet() {
		Pet pet = new Pet();
		pet.setId(1);
		pet.setName("hello");
		pet.setOwner("Joe");
		return pet;
	}
	
	@RequestMapping("/")
	public String test(@ModelAttribute("pet") Pet pet) {
		return "/cn/hello";
	}
}
