package org.doInJava.source.intrinsic.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntrinsicLockByMultiThreadAndSingleLock {

	Random random = new Random();

	List<Integer> intList = new ArrayList<>();
	List<Double> doubleList = new ArrayList<>();

	public synchronized void processIntList() throws InterruptedException {
		intList.add(random.nextInt(100));
		Thread.sleep(1);
	}

	public synchronized void processDoubleList() throws InterruptedException {
		doubleList.add(random.nextDouble());
		Thread.sleep(1);
	}

	public void startProcessing() throws InterruptedException {
		for (int i = 0; i < 1000; i ++) {
			processIntList();
			processDoubleList();
		}
	}

	public void main() throws InterruptedException {
		System.out.println("Started ...");
		Long startTime = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					startProcessing();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					startProcessing();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		Long endTime = System.currentTimeMillis();
		System.out.println("intList size :" + intList.size() + "; doubleList size : " + doubleList.size());
		System.out.println("Duration took is :" + (endTime - startTime));
		/**
		 * Started ... intList size :2000; doubleList size : 2000 Duration took is :4766
		 * 
		 * Two threads it takes more time
		 */
	}
}
