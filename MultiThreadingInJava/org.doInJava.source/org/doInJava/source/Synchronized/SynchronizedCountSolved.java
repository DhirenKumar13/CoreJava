package org.doInJava.source.Synchronized;

public class SynchronizedCountSolved extends Thread{
	
public static Integer count = 0;
	
	public void doWork() {
		
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i< 10000; i++) {
					incrementCountByOne();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i< 10000; i++) {
					incrementCountByOne();
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
	
	public synchronized void incrementCountByOne() {
		count++ ;
	}

	public static void main(String[] args) {
		new SynchronizedCountSolved().doWork();
		System.out.println("Count is :"+count);
	}

}
