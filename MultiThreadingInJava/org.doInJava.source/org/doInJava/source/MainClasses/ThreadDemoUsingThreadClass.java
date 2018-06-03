package org.doInJava.source.MainClasses;

class Runner extends Thread{
	public void run() {
		for(int i = 0 ; i < 10;i ++) {
			System.out.println("Hello : "+i);
			try {
				Thread.sleep(100);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}

public class ThreadDemoUsingThreadClass {

	public static void main(String[] args) {
		Runner runner1 = new Runner();
		Runner runner2 = new Runner();
		
		runner1.start();
		runner2.start();
		
		try {
			runner1.join();
			runner2.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("Finished execution ..");
	}

}
