package com.answer1991.spring.handle.excpetion;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/exception")
public class TestHandleExcpetionController {
	@RequestMapping("/")
	@ResponseBody
	public String test(@RequestParam String ex) throws IOException, Exception {
		if(ex.equals("io")) {
			throw new IOException("hello");
		}
		else if(ex.equals("ex")) {
			throw new Exception("exception");
		}
		return "no error";
	}
	
	/**
	 * Controller里面的ExceptionHandler的权限高于ControllerAdvice
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(IOException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleIOExcpetion(IOException ex, HttpServletResponse response) {
		response.setStatus(500);
		return "hello";
	}
	
}
