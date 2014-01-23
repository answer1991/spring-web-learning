package com.answer1991.spring.controller.handler.params;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.answer1991.spring.model.Pet;
import com.answer1991.spring.model.validation.PetValidator;

@Controller
@RequestMapping("/petTest")
public class TestModelController {
	/**
	 * 没次请求都会执行initBinder方法！！
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("111");
		binder.addValidators(new PetValidator());
	}
	
	@RequestMapping("/{petId}")
	@ResponseBody
	public String testBindResult(@Validated @ModelAttribute Pet pet, BindingResult result, Model model) {
		System.out.println("petId : " + pet.getId());
		System.out.println("petName : " + pet.getName());
		System.out.println("petOwner : " + pet.getOwner());
		if(result.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			sb.append("has Errors,");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors) {
				sb.append(error.getObjectName() + " : " + error.getCode() + ". ");
			}
			return sb.toString();
		}
		else {
			return "no errors";
		}
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "hello";
	}
	
	@ModelAttribute
	public Pet getPet() {
		Pet pet = new Pet();
		pet.setId(1);
		pet.setName("Dan Dan");
		pet.setOwner("Joe");
		return pet;
	}
}
