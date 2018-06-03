package org.doInJava.source.MainClasses;

public class ThreadDemoUsingAnonymousClass {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Hello : " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
			}
		});
		thread1.start();
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Hello : " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
			}
		});
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println("Finished Executing ...");
	}

}
