package org.doInJava.thread.google.racecondition;

public class LongWrapper {
	private Long value;
	public LongWrapper(long l) {
		value = l;
	}
	public Long getValue() {
		return value;
	}
	public void increment() {
		value += 1 ;
	}
}
