package class2;

public class Pow_x_n {
	public double myPow(double x, int n) {
		if (n >= 0)
			return positive(x, n);
		else
			return negative(x, n);
	}

	private double negative(double x, int n) {
		if (n == -1)
			return 1 / x;

		double smallOutput = negative(x, n / 2);
		if (n % 2 == 0)
			return smallOutput * smallOutput;
		else
			return (1 / x) * smallOutput * smallOutput;
	}

	private double positive(double x, int n) {
		if (n == 0)
			return 1;

		double smallOutput = positive(x, n / 2);
		if (n % 2 == 0)
			return smallOutput * smallOutput;
		else
			return x * smallOutput * smallOutput;
	}
}
