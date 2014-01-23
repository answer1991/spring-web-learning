package com.answer1991.i18n;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.context.support.ResourceBundleThemeSource;

public class TestLocaleMapping {
	private AbstractApplicationContext cxt;
	
	@Before
	public void init() {
		this.cxt = new ClassPathXmlApplicationContext("spring-config.xml");
	}
	
	@Test
	public void test() {
		LocaleMapping map = this.cxt.getBean(LocaleMapping.class);
		
		Locale cn = this.cxt.getBean("zh_CN_Locale", Locale.class);
		
		System.out.println(map.get(cn));
	}
	
	@Test
	public void test2() {
		Locale cn = this.cxt.getBean("zh_CN_Locale", Locale.class);
		ResourceBundleThemeSource source = this.cxt.getBean(ResourceBundleThemeSource.class);
		System.out.println(source.getTheme("style").getMessageSource().getMessage("styleSheet", null, cn));
	}
}
