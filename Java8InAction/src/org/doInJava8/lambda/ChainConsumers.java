package org.doInJava8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumers {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("one","two","three","four");
		List<String> resultList = new ArrayList<>();
		
		Consumer<String> consumer1 = System.out::println;
		Consumer<String> consumer2 = resultList::add;
		
		list.forEach(consumer1.andThen(consumer2));
	}

}
