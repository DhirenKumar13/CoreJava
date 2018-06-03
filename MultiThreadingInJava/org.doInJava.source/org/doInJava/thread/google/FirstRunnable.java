package org.doInJava.thread.google;

import java.lang.Thread.State;

public class FirstRunnable {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			State state = Thread.currentThread().getState();
			System.out.println("Hello From :"+Thread.currentThread().getName());
			System.out.println(state);
		};
		Thread thread = new Thread(runnable);
		thread.setName("Google-IO");
		thread.start();
		
		Thread thread1 = new Thread(runnable);
		thread1.setName("Google-IO");
		thread1.run();
		
		/**
		 * Hello From :main
		 * Hello From :Google-IO
		 */
	}

}
