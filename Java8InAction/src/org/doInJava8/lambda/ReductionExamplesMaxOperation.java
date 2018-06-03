package org.doInJava8.lambda;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReductionExamplesMaxOperation {

	public static void main(String[] args) {
		Stream<Integer> stream1 = Stream.empty();
		Stream<Integer> stream2 = Stream.of(1);
		Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
		
		//BinaryOperator<Integer> max = ( i1 , i2 ) -> ( i1 > i2 ) ? i1 : i2;
		BinaryOperator<Integer> max = Integer::max;
		Integer id = 0;
		
		//Integer reduction = stream1.reduce(id,max);
		
		Optional<Integer> reduceOfStream1 = stream1.max(Comparator.naturalOrder());
		Optional<Integer> reduceOfStream2 = stream2.max(Comparator.naturalOrder());
		Optional<Integer> reduceOfStream3 = stream3.max(Comparator.naturalOrder());
		
		//System.out.println("Reduction of empty stream Stream1 is "+reduceOfStream1.get()); //NoSuchElementException
		
		System.out.println("Reduction of empty stream Stream2 is "+reduceOfStream2.get());
		System.out.println("Reduction of empty stream Stream3 is "+reduceOfStream3.get());
		
		//System.out.println("Reduction of empty stream Stream1 is "+reduction); // 0 ---> Which doesn't make sense here !!!

	}

}
