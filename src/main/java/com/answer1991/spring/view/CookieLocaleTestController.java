package com.answer1991.spring.view;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import com.answer1991.i18n.MyLocaleResolver;

@Controller
@RequestMapping("/cookieLocale")
public class CookieLocaleTestController {
	@Autowired
	private MyLocaleResolver resolever;
	
	@RequestMapping("/addCookie")
	@ResponseBody
	public String addCookie(Locale locale, HttpServletResponse response) {
		System.out.println(locale);
		
		resolever.addCookie(response, "en_US");
		
		return locale.toString();
	}
	
	@RequestMapping("/showLocale")
	@ResponseBody
	public String showLocale(Locale locale) {
		return locale.toString();
	}
	
	@RequestMapping("/removeLocale")
	@ResponseBody
	public String removeLocale(HttpServletResponse response, HttpServletRequest request, Locale locale) {
		resolever.addCookie(response, null);
		return locale.toString();
	}

	public MyLocaleResolver getResolever() {
		return resolever;
	}

	public void setResolever(MyLocaleResolver resolever) {
		this.resolever = resolever;
	}
}
