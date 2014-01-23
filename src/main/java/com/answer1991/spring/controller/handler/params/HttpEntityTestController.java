package com.answer1991.spring.controller.handler.params;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/httpEntity")
public class HttpEntityTestController {
	@RequestMapping("/test")
	public ResponseEntity<String> test(HttpEntity<String> requestEntity) {
		String requestHeader = requestEntity.getHeaders().getFirst("hello");
		String requestBody = requestEntity.getBody();
		System.out.println("requestHeader hello = " + requestHeader);
		System.out.println("requestBody : " + requestBody);
		
		HttpHeaders responseHeanders = new HttpHeaders();
		responseHeanders.add("myResponseHeader", "myResponseHeaderValue");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("hello world", responseHeanders, HttpStatus.CREATED);
		return responseEntity;
	}
}
