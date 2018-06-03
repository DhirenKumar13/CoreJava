package org.doInJava.source.intrinsic.locks;

public class StarterForMultiThreadSingleLock {

	public static void main(String[] args) throws InterruptedException {
		IntrinsicLockByMultiThreadExplicitLock lock = new IntrinsicLockByMultiThreadExplicitLock();
		lock.main();
	}

}
