package com.answer1991.spring.model.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.answer1991.spring.model.Pet;

public class PetValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Pet.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Pet pet = (Pet) target;
		
		ValidationUtils.rejectIfEmpty(errors, "id", "id is empty");
		
		if(null == pet.getId()) {
			errors.rejectValue("id", "id is empty");
		}
		
		if(null == pet.getOwner()) {
			errors.rejectValue("owner", "owner is empty");
		}
	}

}
