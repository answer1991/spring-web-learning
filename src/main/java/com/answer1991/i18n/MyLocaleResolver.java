package com.answer1991.i18n;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.WebUtils;

public class MyLocaleResolver extends CookieGenerator implements LocaleResolver  {
	private static final String DEFAULT_PARAM_NAME = "locale";
	
	/**
	 * The default cookie name used if none is explicitly set.
	 */
	public static final String DEFAULT_COOKIE_NAME = CookieLocaleResolver.class.getName() + ".LOCALE";

	public MyLocaleResolver() {
		super.setCookieName(DEFAULT_COOKIE_NAME);
	}

	private String paramName = DEFAULT_PARAM_NAME;

	@Override
	public Locale resolveLocale(HttpServletRequest request) {

		// get Locale from request parameter
		String paramLocale = request.getParameter(this.paramName);
		if (null != paramLocale) {
			Locale locale = StringUtils.parseLocaleString(paramLocale);
			if (logger.isDebugEnabled()) {
				logger.debug("Parsed request param value [" + paramName
						+ "] into locale '" + locale + "'");
			}
			if (locale != null) {
				return locale;
			}
		}

		// get Locale from cookie
		Cookie cookie = WebUtils.getCookie(request, getCookieName());
		if (cookie != null) {
			Locale locale = StringUtils.parseLocaleString(cookie.getValue());
			if (logger.isDebugEnabled()) {
				logger.debug("Parsed cookie value [" + cookie.getValue()
						+ "] into locale '" + locale + "'");
			}
			if (locale != null) {
				return locale;
			}
		}

		// get Locale form Accept-Language
		return request.getLocale();
	}

	@Override
	public void setLocale(HttpServletRequest request,
			HttpServletResponse response, Locale locale) {
		if (locale != null) {
			// add cookie.
			addCookie(response, locale.toString());
		} else {
			removeCookie(response);
		}
	}

}
