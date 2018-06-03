package org.doInJava.source.intrinsic.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntrinsicLockProblem {

	Random random = new Random();

	List<Integer> intList = new ArrayList<>();
	List<Double> doubleList = new ArrayList<>();

	public void processIntList() throws InterruptedException {
		intList.add(random.nextInt(100));
		Thread.sleep(1);
	}

	public void processDoubleList() throws InterruptedException {
		doubleList.add(random.nextDouble());
		Thread.sleep(1);
	}

	public void startProcessing() throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			processIntList();
			processDoubleList();
		}
	}

	public void main() throws InterruptedException {
		System.out.println("Started ...");
		Long startTime = System.currentTimeMillis();
		startProcessing();
		Long endTime = System.currentTimeMillis();
		System.out.println("intList size :" + intList.size() + "; doubleList size : " + doubleList.size());
		System.out.println("Duration took is :" + (endTime - startTime));
		/**
		 * Started ... intList size :1000; doubleList size : 1000 Duration took is :2436
		 */
	}
}
