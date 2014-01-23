package com.answer1991.spring.view;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.answer1991.i18n.LocaleMapping;

@Controller
@RequestMapping("/localeView")
public class LocaleViewTestController {
	@Autowired
	private LocaleMapping localeMapping;
	
	@RequestMapping("/test.do")
	public String handle(Locale locale) {
		System.out.println(localeMapping.get(locale));
		return localeMapping.get(locale) + "/hello";
	}

	public LocaleMapping getLocaleMapping() {
		return localeMapping;
	}

	public void setLocaleMapping(LocaleMapping localeMapping) {
		this.localeMapping = localeMapping;
	}
}
