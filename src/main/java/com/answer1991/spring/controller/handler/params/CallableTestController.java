package com.answer1991.spring.controller.handler.params;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
@RequestMapping("/callable")
public class CallableTestController {
	@RequestMapping("/test")
	@ResponseBody
	public Callable<String> test() {
		return new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(5000);
				
				return "hello world";
			}
		};
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public DeferredResult<String> tetWithDefer() {
		DeferredResult<String> deferredResult = new DeferredResult<String>();
		
		new Thread(new DeferredRunnable(deferredResult)).start();
		
		return deferredResult;
	}
	
	private static class DeferredRunnable implements Runnable {
		private DeferredResult<String> result;
		
		public DeferredRunnable(DeferredResult<String> result) {
			this.result = result;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result.setResult("hello");
		}
	}
}
