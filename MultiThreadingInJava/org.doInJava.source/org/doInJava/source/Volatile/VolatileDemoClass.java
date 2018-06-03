package org.doInJava.source.Volatile;

import java.util.Scanner;

class IntelProcessor extends Thread{

	public volatile Boolean isRunning = Boolean.TRUE;
	
	public void run() {
		while(isRunning)
		{
			System.out.println("Hello : ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
	
	void changeRunningStatus() {
		isRunning = Boolean.FALSE;
	}
}

public class VolatileDemoClass {

	public static void main(String[] args) {
		IntelProcessor process1 = new IntelProcessor();
		process1.start();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press return key to return / exit this process ...");
		scanner.nextLine();
		
		scanner.close();
		process1.changeRunningStatus();
	}

}
