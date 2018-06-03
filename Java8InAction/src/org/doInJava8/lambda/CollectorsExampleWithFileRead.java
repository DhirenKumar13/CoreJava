package org.doInJava8.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExampleWithFileRead {

	public static void main(String[] args) {

		List<Person> personList = new ArrayList<>();

		try ( 
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(
							CollectorsExampleWithFileRead.class.getResourceAsStream("names.txt")
						)
				);

				Stream<String> stream = reader.lines();
			) {

				stream.map(line -> {
					String[] s = line.split(" ");
					Person person = new Person(s[0].trim(), Integer.parseInt(s[1]));
					personList.add(person);
					return person;
				}).forEach(System.out::println);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// Find the youngest person who is greteer than 20years of old ...

		Optional<Person> youngerPerson = 
				personList.stream().filter(person -> person.getAge() >= 20)
				.min(Comparator.comparing(Person::getAge));

		Optional<Person> olderPerson = 
				personList.stream().filter(person -> person.getAge() >= 20)
				.max(Comparator.comparing(Person::getAge));

		System.out.println("Younger Person after the age of 20 is :" + youngerPerson);

		System.out.println("Older Person after the age of 20 is :" + olderPerson);

		// Collecting informations by ages of persons

		Map<Integer, List<Person>> map = 
				personList.stream().filter(p -> p.getAge() > 20)
				.collect(
						Collectors.groupingBy(Person::getAge)
				);

		System.out.println("After Grouping by ages of persons ..");
		System.out.println(map);

		Map<Integer, Long> mapByCounting = 
				personList.stream().filter(p -> p.getAge() > 20)
				.collect(
						Collectors.groupingBy(Person::getAge,
								Collectors.counting())
				);

		System.out.println("After Grouping by ages of persons counts is ..");
		System.out.println(mapByCounting);
		
		// Collecting informations by ages of persons and collecting the names only
		
		Map<Integer, List<String>> mapByName =
				personList.stream().filter(p -> p.getAge() > 20)
				.collect(
						Collectors.groupingBy(Person::getAge, 
								Collectors.mapping(Person::getName,
										Collectors.toList())
						)
				);
		System.out.println("After Grouping by ages of persons name based on age is ..");
		System.out.println(mapByName);

	}

}
