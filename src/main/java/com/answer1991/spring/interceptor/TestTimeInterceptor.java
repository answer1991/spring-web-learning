package com.answer1991.spring.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestTimeInterceptor extends HandlerInterceptorAdapter {
	private Integer startTime;
	private Integer endTime;
	
	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Calendar cal = Calendar.getInstance();
		Integer nowHour = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println(nowHour);
		if(nowHour >= startTime && nowHour <=endTime) {
			return true;
		}
		else {
			response.sendRedirect("http://google.com");
			return false;
		}
	}

}
