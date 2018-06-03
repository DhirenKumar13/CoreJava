package org.doInJava.interview;

public abstract class MainInsideAbstract {
	
	public void m1() {}
	
	public abstract void m2() ;
	
	public static void main(String[] args) {
	}

}

interface i1 {
	
	public abstract void m2();
	// from java 1.8
	public static void main(String[] args) {
	}
}
