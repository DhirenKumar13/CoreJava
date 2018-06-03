package org.doInJava8.lambda;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReductionExamples {

	public static void main(String[] args) {
		Stream<Integer> stream1 = Stream.empty();
		Stream<Integer> stream2 = Stream.of(1);
		Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
		
		//BinaryOperator<Integer> sum = (i1,i2) -> i1 + i2;
		BinaryOperator<Integer> sum = Integer::sum;
		Integer id = 0;
		
		Integer reduceOfStream1 = stream1.reduce(id, sum);
		Integer reduceOfStream2 = stream2.reduce(id, sum);
		Integer reduceOfStream3 = stream3.reduce(id, sum);
		
		System.out.println("Reduction of empty stream Stream1 is "+reduceOfStream1);
		System.out.println("Reduction of empty stream Stream2 is "+reduceOfStream2);
		System.out.println("Reduction of empty stream Stream3 is "+reduceOfStream3);

	}

}
