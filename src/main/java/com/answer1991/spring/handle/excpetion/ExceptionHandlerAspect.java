package com.answer1991.spring.handle.excpetion;

import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.answer1991.i18n.LocaleMapping;

@ControllerAdvice
public class ExceptionHandlerAspect {
	@Autowired
	private LocaleMapping map;
	
	@ExceptionHandler(IOException.class)
	public String handleIOExcpetion(IOException ex, Locale locale) {
		return map.get(locale) + "/error";
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleException(Exception ex) {
		return ex.getMessage();
	}

	public LocaleMapping getMap() {
		return map;
	}

	public void setMap(LocaleMapping map) {
		this.map = map;
	}
}
