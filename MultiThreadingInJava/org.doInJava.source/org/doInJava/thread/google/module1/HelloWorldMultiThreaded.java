package org.doInJava.thread.google.module1;

import java.util.Arrays;

public class HelloWorldMultiThreaded {
	
	public static class Greeter extends Thread {
		
		private String country;
		public Greeter(String country) {
			super(country + "Thread");
			this.country = country;
		}
		
		
		public void run() {
			String tname = Thread.currentThread().getName();
			String name = this.getName();		
			System.out.println("Hello To "+country+ " From "+tname+ " : "+name);
		}
	}

	public static void main(String[] args) {
		String [] countries = {"India","USA","Switzerland","Uk"};
		Arrays.asList(countries).forEach(
		country -> new Greeter(country).start());
	}

}
