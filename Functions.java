
import java.util.function.Function;

public class Functions {

	public static void main(String[] args) {

		Function<String, Integer> length = x -> x.length();

		System.out.println(length.apply("Anant Goswami"));
	}

}
