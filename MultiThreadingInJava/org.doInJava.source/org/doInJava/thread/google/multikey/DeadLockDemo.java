package org.doInJava.thread.google.multikey;

public class DeadLockDemo {

	public static void main(String[] args) throws InterruptedException {
		
		MultikeyClass key = new MultikeyClass();
		
		Runnable r1 = () -> key.m1();
		Runnable r2 = () -> key.m2();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

}
