package org.doInJava.thread.google.globalVariableProblems;

import java.text.SimpleDateFormat;

public class DateFormatterExampleV2 {
	
	public static class DateFormatterThreadLocal extends ThreadLocal<SimpleDateFormat>{
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("EEE MMM dd , hh:mm:ss");
		}
	}
	
	public static DateFormatterThreadLocal dateFormatterVar = new DateFormatterThreadLocal();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new DatePrinterV2("Formatter 1") , "Formatter 1 ");
		Thread t2 = new Thread(new DatePrinterV2("Formatter 2") , "Formatter 2 ");
		t1.start();
		t2.start();
	}

}
