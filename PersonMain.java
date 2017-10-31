

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class PersonMain {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(new Person("Hasnen", 27), new Person("Anant", 23),
				new Person("Hasnen", 25), new Person("Dhananjay", 35), new Person("Meet", 10),
				new Person("Akash", 1110));

		// List<Person> sortedList = personList.stream().sorted((x, y) ->
		// x.ageDifference(y)).collect(Collectors.toList());

		Comparator<Person> ascendingComparator = (x, y) -> x.ageDifference(y);

		System.out.println("---------------ASC-----------------");
		List<Person> sortedAscList = personList.stream().sorted(ascendingComparator).collect(Collectors.toList());
		sortedAscList.forEach(System.out::println);

		List<Person> sortedDescList = personList.stream().sorted(ascendingComparator.reversed())
				.collect(Collectors.toList());

		System.out.println("---------------DESC-----------------");
		sortedDescList.forEach(System.out::println);

		System.out.println("------------ NAME TO BE ASCENDING ORDER ---------------");
		List<Person> ascName = personList.stream().sorted((x, y) -> x.getName().compareTo(y.getName()))
				.collect(Collectors.toList());
		ascName.forEach(System.out::println);

		System.out.println("--------------MIN AGE------------------");

		personList.stream().min((x, y) -> x.ageDifference(y))
				.ifPresent(y -> System.out.println("Yongest Person : " + y.getName() + " | " + y.getAge()));

		System.out.println("--------------- MAX -------------------");

		personList.stream().max(Person::ageDifference).ifPresent(System.out::println);

		final Function<Person, String> byName = person -> person.getName();

		final Function<Person, Integer> byAge = person -> person.getAge();

		personList.stream().sorted(Comparator.comparing(byName)).forEach(System.out::println);

		System.out.println(personList.stream().sorted(Comparator.comparing(byName).thenComparing(byAge))
				.collect(Collectors.toList()));

	}
}
