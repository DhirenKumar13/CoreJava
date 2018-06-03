package org.doInJava8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExpressionDemos {
	
	public static void main(String [] a) throws InterruptedException {
		
		Runnable run = () -> System.out.println("Runnable Implemented ..");
		
		Thread t = new Thread(run);
		t.start();
		t.join();
		System.out.println("Demo 1 Completed ... ");
		
		Comparator<Integer> c = Integer::compare;
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(20);
		al.add(15);
		System.out.println("Without sorting ..");
		al.forEach(System.out::println);
		List<Integer> bl = al.stream().sorted(c).collect(Collectors.toList());
		System.out.println("After sorting ..");
		bl.forEach(System.out::println);
		
		System.out.println("Demo 2 Completed ... ");
	}
	
}
