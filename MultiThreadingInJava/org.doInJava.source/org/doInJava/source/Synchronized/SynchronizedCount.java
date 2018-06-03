package org.doInJava.source.Synchronized;

class Counter extends Thread{
	
	public static Integer count = 0;
	
	public void run() {
		for(int i = 0; i< 10000; i++) {
			//count = count +1 ;
			incrementCount();
		}
	}
	
	public synchronized void incrementCount() {
		count = count + 1 ;
	}
	
}

public class SynchronizedCount {

	public static void main(String[] args) {
		Counter counter1 = new Counter();
		Counter counter2 = new Counter();
		counter1.start();
		counter2.start();
		System.out.println("Count in counter 1 and counter 2 is :"+Counter.count);
		Counter counter3 = new Counter();
		Counter counter4 = new Counter();
		counter3.start();
		counter4.start();
		try {
			counter3.join();
			counter4.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("Count in counter3 and counter 4 is :"+Counter.count);
		/**
		 * so far out output is
		 * Count in counter 1 and counter 2 is :0
		 * Count in counter3 and counter 4 is :19887(can change !!!) 
		 * After commenting count = count + 1 all will be synchronized ..
		 */
	}

}
