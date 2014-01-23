package com.answer1991.spring.controller.handler.params;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * doesn't work
 * @author Joe
 *
 */
@Controller
@RequestMapping("/form")
public class FormTestController {
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public String test(@RequestBody MultiValueMap<String, String> parmas) {
		Set<String> keys = parmas.keySet();
		StringBuilder sb = new StringBuilder();
		for(Iterator<String> it = keys.iterator(); it.hasNext();) {
			String key = it.next();
			List<String> value = parmas.get(key);
			sb.append(key + " = " + value + ".."); 
		}
		return sb.toString();
	}
}
