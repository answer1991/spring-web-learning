package com.answer1991.spring.interceptor;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

public class SetLocaleInterceptor extends HandlerInterceptorAdapter {
	private static final String DEFAULT_PARAM_NAME = "locale";
	
	@Autowired
	private CookieLocaleResolver cookieLocaleResolever;
	private String paramName = DEFAULT_PARAM_NAME;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		LocaleResolver defaultResolver = RequestContextUtils.getLocaleResolver(request);
		if (defaultResolver == null) {
			throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
		}
		
		//set Locale from request parameter
		String paramLocale = request.getParameter(this.paramName);
		if(null != paramLocale) {
			defaultResolver.setLocale(request, response, StringUtils.parseLocaleString(paramLocale));
			return true;
		}
		
		//set Locale from cookie
		Locale cookeLocale = cookieLocaleResolever.resolveLocale(request);
		defaultResolver.setLocale(request, response, cookeLocale);
		
		return true;
	}
}
