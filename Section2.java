

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

public class Section2 {
		
	public static void main(String[] args) {
		
		Map<String, String> country = new HashMap<>();
		country.put("India", "Delhi");
		country.put("Shri Lanka", "Columbo");
		country.put("France", "Paris");
		country.put("Austrellia", "Sydney");
		country.put("USA", "New York");
		country.put("UK", "London");
		
		// country.forEach((k, y) -> System.out.println(k + "-" + y));
		
		Predicate<Entry<String, String>> india = x -> x.getKey().equals("India");
		Predicate<Entry<String, String>> aus = x -> x.getKey().equals("Austrellia");
		Predicate<Entry<String, String>> uk = x -> x.getKey().equals("UK");
		
		Entry<String, String> capital = country.entrySet().stream().filter(india).findFirst().get();
		System.out.println(capital.getKey() + " - " + capital.getValue());
		
		capital = country.entrySet().stream().filter(aus).findFirst().get();
		System.out.println(capital.getKey() + " - " + capital.getValue());
		
		capital = country.entrySet().stream().filter(uk).findFirst().get();
		System.out.println(capital.getKey() + " - " + capital.getValue());
		
		int a = 0b0000_1001;
		
		System.out.println(a);
	}
		
}
