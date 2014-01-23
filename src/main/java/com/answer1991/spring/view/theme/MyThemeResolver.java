package com.answer1991.spring.view.theme;

import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.WebUtils;

public class MyThemeResolver extends CookieGenerator implements ThemeResolver {
	private static final String DEFAULT_THEME_FOLDER_NAME = "default";
	private static final String DEFAULT_THEME_FILE_NAME = "theme";
	private static final String DEFAULT_THEME_COOKIE_NAME = "theme";
	private static final String DEFAULT_THEME_REQUEST_NAME = "theme";
	
	private String defaultThemeFolderName = DEFAULT_THEME_FOLDER_NAME;
	
	/**
	 * The name of the properties file that store theme info.
	 */
	private String themeFileName = DEFAULT_THEME_FILE_NAME;
	
	private String requestParamThemeName = DEFAULT_THEME_REQUEST_NAME;
	
	/**
	 * The key is the themeType in request or cookie.
	 * The value is the folder name that store theme properties files.
	 * If the value returns null, will get the next step check.
	 * If the instance without set the themeTypeMap, always return the default theme.
	 */
	private Map<String, String> themeTypeMap = new HashMap<String, String>();
	
	public MyThemeResolver() {
		setCookieName(DEFAULT_THEME_COOKIE_NAME);
	}
	
	/**
	 * Return the theme properties file location without the internationalization suffix.
	 * The check order is:
	 * 	1. Request parameter.
	 *  2. Cookie.
	 *  3. Return the default theme.
	 */
	@Override
	public String resolveThemeName(HttpServletRequest request) {
		// First check request parameter
		String themeType = request.getParameter(requestParamThemeName);
		if(null != themeType) {
			String themeFolderName = themeTypeMap.get(themeType);
			
			if(null != themeFolderName) {
				return getThemeLocation(themeFolderName);
			}
		}
		
		// Second check the cookie
		Cookie cookie = WebUtils.getCookie(request, getCookieName());
		if(null != cookie) {
			String themeFolderName = themeTypeMap.get(cookie.getValue());
			if(null != themeFolderName) {
				return getThemeLocation(themeFolderName);
			}
		}
		
		// At last, return the default theme.
		return getThemeLocation(defaultThemeFolderName);
	}
	
	public String getThemeLocation(String folderName) {
		return "/" + folderName + "/" + themeFileName;
	}

	/**
	 * store themeType in Cookie
	 */
	@Override
	public void setThemeName(HttpServletRequest request,
			HttpServletResponse response, String themeType) {
		if(null != themeType) {
			addCookie(response, themeType);
		}
	}
	
	public String getDefaultThemeFolderName() {
		return defaultThemeFolderName;
	}

	public void setDefaultThemeFolderName(String defaultThemeFolderName) {
		this.defaultThemeFolderName = defaultThemeFolderName;
	}

	public Map<String, String> getThemeTypeMap() {
		return themeTypeMap;
	}

	public void setThemeTypeMap(Map<String, String> themeTypeMap) {
		this.themeTypeMap = themeTypeMap;
	}

	public String getThemeFileName() {
		return themeFileName;
	}

	public void setThemeFileName(String themeFileName) {
		this.themeFileName = themeFileName;
	}

	public String getRequestParamThemeName() {
		return requestParamThemeName;
	}

	public void setRequestParamThemeName(String requestParamThemeName) {
		this.requestParamThemeName = requestParamThemeName;
	}
}
