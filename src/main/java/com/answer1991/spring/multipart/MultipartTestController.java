package com.answer1991.spring.multipart;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class MultipartTestController {
	@RequestMapping("/upload.do")
	@ResponseBody
	public String test(@RequestParam("file") MultipartFile part) throws IOException {
		if(part.isEmpty()) {
			return "your upload file is empty";
		}
		else {
			return new String(part.getBytes());
		}
	}
}
