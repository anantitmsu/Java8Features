

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class Revise {

	static final Predicate<String> startWithChar(String start) {
		return name -> name.toLowerCase().startsWith(start);
	}

	static final Function<String, Predicate<String>> startWithFun = str -> input -> input.toLowerCase().startsWith(str);

	static final Function<String, Integer> stringLen = str -> str.length();

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(new Person("Hasnen", 27), new Person("Anant", 23),
				new Person("Hasnen", 27), new Person("Dhananjay", 35), new Person("Meet", 10),
				new Person("Akash", 1110));

		System.out.println("len = > " + stringLen.apply("ANANT"));

		List<String> people = Arrays.asList("Rakesh", "Ajay", "anant", "kedar", "emmanuel", "raj", "jignesh", "jimmy",
				"Jigyasu", "jyoti", "akash");

		List<String> peopleWithA = people.stream().filter(startWithFun.apply("a")).sorted()
				.collect(Collectors.toList());
		List<String> peopleWithJ = people.stream().filter(startWithFun.apply("j")).sorted()
				.collect(Collectors.toList());

		people.stream().forEachOrdered(x -> System.out.print(String.join("|", x)));

		System.out.println("---------------------- START WITH A ----------------------------");
		peopleWithA.forEach(System.out::println);

		System.out.println("---------------------- START WITH J ----------------------------");
		peopleWithJ.forEach(System.out::println);

		Function<Person, Integer> byAge = p -> p.getAge();
		Function<Person, String> byName = p -> p.getName();

		System.out.println("============ BY NAME ============");
		System.out.println(personList.stream().sorted(Comparator.comparing(byName)).collect(Collectors.toList()));

		System.out.println("============ BY AGE ============");
		System.out.println(personList.stream().sorted(Comparator.comparing(byAge)).collect(Collectors.toList()));

		System.out.println("============ GROUP BY AGE ============");

		Map<Integer, List<Person>> groupByAge = personList.stream().collect(Collectors.groupingBy(Person::getAge));

		groupByAge.forEach((x, y) -> System.out.println(x + " - " + y));

		Map<Integer, List<String>> nameofPeopleByAge = personList.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println("============== NAME OF PEPPLE BY AGE ======================");
		
		nameofPeopleByAge.forEach((x, y) -> System.out.println(x + " | " + y));

	}

}