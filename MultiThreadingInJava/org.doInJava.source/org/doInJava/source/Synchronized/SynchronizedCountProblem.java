package org.doInJava.source.Synchronized;

public class SynchronizedCountProblem extends Thread{
	
public static Integer count = 0;

public static volatile Integer counter = 20000;
	
	public void doWork() {
		
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i< 10000; i++) {
					count++;
					counter--;
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i< 10000; i++) {
					count++;
					counter--;
				}
			}
		});
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SynchronizedCountProblem().doWork();
		//Random number can be anything ...
		System.out.println("Count is :"+count);
		//Random number can be anything ...
		System.out.println("Counter is :"+counter);
	}

}
