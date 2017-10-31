

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Utils {
	static Integer total = 0;

	public static Integer cumulativeSum(Integer x) {
		total += x;
		return total;
	}
}

public class Java8Collection {

	public static void main(String[] args) {

		final List<String> stringList = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "seven", "eight",
				"nine", "ten", "Eleven");

		System.out.println(String.join(", ", stringList));

		String code = "BXFSDFPG5345462D";

		code.chars().filter(x -> Character.isDigit(x)).forEach(x -> System.out.print((char) x));

		stringList.forEach(name -> {

			System.out.println(name);
		});

		System.out.println("----------------------------------------------");
		
		// Method reference
		// stringList.forEach(System.out::println);

		final List<String> capsString = new ArrayList<>();

		stringList.forEach(s -> {
			capsString.add(s.toUpperCase());
		});

		// capsString.forEach(System.out::println);

		List<String> lowerCaseString = new ArrayList<>();

		// lowerCaseString = capsString.stream().map(s ->
		// s.toLowerCase()).collect(Collectors.toList());

		// lowerCaseString.forEach(System.out :: println);

		// capsString.stream().map(s -> s.length()).forEach(count ->
		// System.out.println(count));

		capsString.stream().map(String::length).map(x -> Utils.cumulativeSum(x));

		// forEach(System.out :: println);;

		// capsString.stream().map(s ->
		// s.toLowerCase()).forEach(System.out::println);

		// Predicate<String> startF = name ->
		// name.toLowerCase().startsWith("t");

		final Function<String, Predicate<String>> startWithLetter = letter -> name -> name.toLowerCase()
				.startsWith(letter);

		capsString.stream().filter(name -> name.toLowerCase().startsWith("a")).collect(Collectors.toList());

		System.out.println("o >>> "
				+ capsString.stream().filter(startWithLetter.apply("o")).collect(Collectors.toList()).toString());
		System.out.println("N >>> "
				+ capsString.stream().filter(startWithLetter.apply("n")).collect(Collectors.toList()).toString());
		System.out.println("F >>> "
				+ capsString.stream().filter(checkForStartLetterWith("f")).collect(Collectors.toList()).toString());
		System.out.println("T >>> "
				+ capsString.stream().filter(checkForStartLetterWith("t")).collect(Collectors.toList()).toString());

		pickName(capsString, "o");

		System.out.println("Total number of words " + capsString.stream().mapToInt(x -> x.length()).count());
		System.out.println("Total number of chars " + capsString.stream().mapToInt(x -> x.length()).sum());
		System.out.println("Maximum of chars " + capsString.stream().mapToInt(x -> x.length()).max().orElse(0));

		Optional<String> lName = capsString.stream()
				.reduce((str1, str2) -> str1.length() >= str2.length() ? str1 : str2);

		System.out.println("Longest string found : " + lName.orElse("?"));

		System.out.println("Longest with default : "
				+ capsString.stream().reduce("T", (x, y) -> x.length() >= y.length() ? x : y));

	}

	public static final Predicate<String> checkForStartLetterWith(final String letter) {
		return n -> n.toLowerCase().startsWith(letter);
	}

	public static void possible(String name) {
		System.out.println("Wah it is possible : " + name);
	}

	public static void pickName(final List<String> nameList, String letter) {

		Optional<String> name = nameList.stream().filter(x -> x.toLowerCase().startsWith(letter)).findFirst();

		System.out.println(String.format("Searching : %s, result : %s", letter, name.orElse("No match found")));

		name.ifPresent(x -> possible(x));
	}

}
