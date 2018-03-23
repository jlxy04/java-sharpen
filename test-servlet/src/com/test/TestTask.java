package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;

/**
 * @author lijun
 * @version 2.0
 * @date 2016年9月7日
 */
public class TestTask implements Runnable {
	
	
	AsyncContext asyncContext;
	
	public TestTask(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(5000);
				PrintWriter printWriter = asyncContext.getResponse().getWriter();
				printWriter.write("xxxxxxxxxxx");
				printWriter.flush();
			}
			asyncContext.complete();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
