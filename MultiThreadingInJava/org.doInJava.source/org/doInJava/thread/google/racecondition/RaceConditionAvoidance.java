package org.doInJava.thread.google.racecondition;

public class RaceConditionAvoidance {

	public static void main(String[] args) throws InterruptedException {
		LongWrapperSync wrapper = new LongWrapperSync(0l);
		
		Runnable run = () -> {
			for(int i = 0 ; i < 1000; i ++) {
				wrapper.increment();
			}
		};
		
		Thread[] thread = new Thread[1_000];
		
		for(int i = 0 ; i < thread.length ; i ++) {
			thread [i] = new Thread(run);
			thread [i].start();
		}
		for(int i = 0 ; i < thread.length ; i ++) {
			thread [i].join();
		}
		
		System.out.println("The value now is :"+wrapper.getValue());
	}

}
