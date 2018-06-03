package org.doInJava.source.intrinsic.locks;

public class StarterForIntrinsicLockByMultiThread {

	public static void main(String[] args) throws InterruptedException {
		IntrinsicLockProblemByMultiThread lock = new IntrinsicLockProblemByMultiThread();
		lock.main();
	}

}
