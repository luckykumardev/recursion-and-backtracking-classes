package class1;

public class Factorial {

	static int factorial(int n) {
		if(n==0)
			return 1;
		
			return (n * factorial(n - 1));
	}

	public static void main(String args[]) {
		int fact = 1;
		int number = 4;
		fact = factorial(number);
		System.out.println("Factorial of " + number + " is: " + fact);
	}

}
