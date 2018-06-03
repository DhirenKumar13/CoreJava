package org.doInJava.thread.google.globalVariableProblems;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatePrinter implements Runnable {
	
	private String name;

	public DatePrinter(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		if("Formatter 1".equals(name)) {
			System.out.println("Formatter is changed by "+name);
			DateFormatterExample.dateFormatter.applyPattern("yyyy:mm:dd");
		}
		while(true) {
			
			try {
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException ie) {}
			
			Date now = new Date();
			System.out.println(name +": "+DateFormatterExample.dateFormatter.format(now));
		}
	}

}
