package org.doInJava.thread.google.multikey;

public class MultikeyClass {
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public void m1() {
		synchronized (lock1) {
			System.out.println("[ " + Thread.currentThread().getName()
					+ " ] is in m1() ..");
			
			m2();
		}
	}
	
	public void m2() {
		synchronized (lock2) {
			System.out.println("[ " + Thread.currentThread().getName()
					+ " ] is in m2() ..");
			
			m3();
		}
	}
	
	public void m3() {
		synchronized (lock1) {
			System.out.println("[ " + Thread.currentThread().getName()
					+ " ] is in m2() ..");
			
		}
	}
}
