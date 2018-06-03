package org.doInJava.thread.google.threadException;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MainDriverClass {
	
	public static class MyThreadExceptionHandler implements UncaughtExceptionHandler{
	
		private ExecutionException exception ;
		
		public ExecutionException getException() {
			return exception;
		}

		@Override
		public void uncaughtException(Thread thread, Throwable cause) {
			System.out.println("Caught an exception ");
			cause.printStackTrace();
			exception = new ExecutionException(cause);
		}
		
	}
	
	public static void main(String[] args) {
		GreatPerson person = new GreatPerson();
		System.out.println("Starting a thread ...");
		Thread t = new Thread(person,"Steve");
		MyThreadExceptionHandler handler = new MyThreadExceptionHandler();
		t.setUncaughtExceptionHandler(handler);
		t.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {}
		
		t.interrupt();
		try {
			t.join();
		} catch (InterruptedException e) {}
		ExecutionException  e = handler.getException();
		e.printStackTrace();
		System.out.println("End of logic for customThreadExceptionHandler ....");
	}

}
