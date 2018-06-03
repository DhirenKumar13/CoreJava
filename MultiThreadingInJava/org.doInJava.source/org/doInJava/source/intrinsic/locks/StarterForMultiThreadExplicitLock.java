package org.doInJava.source.intrinsic.locks;

public class StarterForMultiThreadExplicitLock {

	public static void main(String[] args) throws InterruptedException {
		IntrinsicLockByMultiThreadAndSingleLock lock = new IntrinsicLockByMultiThreadAndSingleLock();
		lock.main();
	}

}
