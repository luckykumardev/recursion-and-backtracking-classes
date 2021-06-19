package class7;

public class UnboundedKnapsack {

	
	static int knapSackRecursion(int W, int wt[], int val[], int i, int currSum) {
		if (i == wt.length || W == 0) {
			return currSum;
		}

		if (wt[i] <= W) {
			int op1 = knapSackRecursion(W - wt[i], wt, val, i, currSum + val[i]);
			int op2 = knapSackRecursion(W, wt, val, i + 1, currSum);

			return Math.max(op1, op2);
		} else {
			int op2 = knapSackRecursion(W, wt, val, i + 1, currSum);
			return op2;
		}
	}
	


	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;

		System.out.println(knapSackRecursion(W, wt, val, 0, 0));

	}


}
