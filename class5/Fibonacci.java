package class5;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	private static Map<Integer, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		int ans  =  fib(3);
		System.out.println(ans);
	}
	
	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (memo.containsKey(n)) {
			System.out.printf("grabbing memo[%d]\n", n);
			return memo.get(n);
		}

		int result = fib(n - 1) + fib(n - 2);

		memo.put(n, result);
		return result;
	}
}
