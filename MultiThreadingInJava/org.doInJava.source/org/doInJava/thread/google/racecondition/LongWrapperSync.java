package org.doInJava.thread.google.racecondition;

public class LongWrapperSync {
	
	private Long value;
	
	private Object lock = new Object();
	
	public LongWrapperSync(long l) {
		value = l;
	}
	
	public Long getValue() {
		return value;
	}
	
	public void increment() {
		synchronized (lock) {
			value += 1 ;
		}
	}
}
