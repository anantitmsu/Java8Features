

public class PracticeLogin {

	static Integer fact(int n) {

		if (n <= 0)
			return 1;
		else
			return fact(n - 1) * n;

	}

	static int reverse(Integer n) {
		int rem = 0;
		int sum = 0;

		while (n > 0) {
			rem = n % 10;
			sum = (sum * 10) + rem;
			n = n / 10;
		}

		return sum;
	}

	static void swap(int a, int b) {

		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a :" + a + " , b : " + b);
	}

	static void fibo(int n) {

		int a = 0;
		int b = 1;
		int s = 0;
		System.out.print(s);
		while (n > 0) {
			a = b;
			b = s;
			s = a + b;
			System.out.print("," + s);
			n--;
		}

	}

	public static void main(String[] args) {
		System.out.println(fact(5));
		System.out.println(reverse(123456789));

		swap(1111, 999);
		fibo(10);
	}
}

