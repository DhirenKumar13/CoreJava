package org.doInJava.thread.google.threadException;

import java.util.concurrent.TimeUnit;

public class GreatPerson implements Runnable {
	
	private String name;

	public GreatPerson() {}

	public GreatPerson(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Hello World from "+name);
		while(!t.isInterrupted()) {
			System.out.println("I am still Alive ...");
			try {
				TimeUnit.MICROSECONDS.sleep(500);
			}catch(InterruptedException ie) {
				t.interrupt();
			}
		}
		System.out.println("Good Bye to the cruel world !!!! ");
		throw new RuntimeException("Good Bye All ...");
	}

}
