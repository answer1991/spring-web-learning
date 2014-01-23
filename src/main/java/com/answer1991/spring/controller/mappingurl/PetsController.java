package com.answer1991.spring.controller.mappingurl;

import java.io.IOException;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pets")
public class PetsController {
	
	@RequestMapping("/")
	@ResponseBody
	public String sayHello(Model model) {
		return "welcome to pets page";
	}
	
	@RequestMapping(value = "/echoPetId/{petId}", method = RequestMethod.GET)
	public void echoPetId(@PathVariable int petId, Writer writer) throws IOException {
		writer.write("petId is" + petId);
	}
	
	@RequestMapping("/echoParam")
	public void echoRequestParam(@RequestParam String name, Writer writer) throws IOException {
		writer.write("name = " + name);
	}
}
