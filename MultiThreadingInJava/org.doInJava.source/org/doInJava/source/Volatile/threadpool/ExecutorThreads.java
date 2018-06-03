package org.doInJava.source.Volatile.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class FactoryThreads implements Runnable{
	public Integer _id;
	public FactoryThreads(Integer id) {
		this._id = id;
	}
	public void run() {
		System.out.println("Starting task .."+_id+ "- by "
				+ ""+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		}catch(Exception e) {}
		System.out.println("Completed task .."+_id+ "- by "
				+ ""+Thread.currentThread().getName());
	}
}

public class ExecutorThreads {
	public static void main(String[] args) throws Exception{
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i = 0 ; i < 5 ; i++) {
			executor.submit(new FactoryThreads(i));
		}
		executor.shutdown();
		
		System.out.println("All tasks were distributed successfully ..");
		
		executor.awaitTermination(20, TimeUnit.SECONDS);
		
		System.out.println("All tasks were completed successfully ..");
	}
}
