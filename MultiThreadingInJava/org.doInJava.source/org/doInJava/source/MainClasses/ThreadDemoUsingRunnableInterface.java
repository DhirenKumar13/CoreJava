package org.doInJava.source.MainClasses;

class Processor implements Runnable{
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

public class ThreadDemoUsingRunnableInterface {

	public static void main(String[] args) {
		Processor processor1 = new Processor();
		Processor processor2 = new Processor();
		
		Thread runner1 = new Thread(processor1);
		Thread runner2 = new Thread(processor2);
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
