package org.doInJava.thread.google.globalVariableProblems;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatePrinterV2 implements Runnable {
	
	private String name;

	public DatePrinterV2(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		if("Formatter 1".equals(name)) {
			System.out.println("Formatter is changed by "+name);
			DateFormatterExampleV2.dateFormatterVar.get().applyPattern("yyyy:mm:dd");
		}
		while(true) {
			
			try {
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException ie) {}
			
			Date now = new Date();
			
			System.out.println(name +": "+DateFormatterExampleV2.dateFormatterVar.get().format(now));
		}
	}

}
