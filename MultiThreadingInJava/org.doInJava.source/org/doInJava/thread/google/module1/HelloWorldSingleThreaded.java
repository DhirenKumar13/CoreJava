package org.doInJava.thread.google.module1;

import java.util.Arrays;

public class HelloWorldSingleThreaded {

	public static void main(String[] args) {
		String [] countries = {"India","USA","Switzerland","Uk"};
		Arrays.asList(countries).forEach(
		country -> System.out.println("Hello World "+country));
	}

}
