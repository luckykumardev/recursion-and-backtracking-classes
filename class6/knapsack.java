package class6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class knapsack {

	
	static List<Integer> finalList = new ArrayList<>();
	static List<Integer> knapsackItems = new ArrayList<>();
	static int finalSum = Integer.MIN_VALUE;
	static int knapSackRecursion(int W, int wt[], int val[], int i, int currSum) {
		if (i == wt.length || W == 0) {
	        if(currSum >= finalSum){
	        	finalSum = currSum;
	        	finalList = new ArrayList<>(knapsackItems);
	        }		
			
			return currSum;
		}
		
	
		if (wt[i] <= W) {
			knapsackItems.add(i);
			int op1 = knapSackRecursion(W - wt[i], wt, val, i+1, currSum + val[i]);
			knapsackItems.remove(knapsackItems.size() -1);
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
		finalList.forEach( item ->{
			System.out.print(item + " ");
		});
//		int[][] memo = new int[val.length + 1][W + 1];
//		HashMap<String, Integer> memo = new HashMap();
//		System.out.println(knapSackMemoization(W, wt, val, 0, memo));

	}

	private static int knapSackMemoization(int W, int[] wt, int[] val, int i, HashMap<String, Integer> memo) {

		if (i == wt.length || W == 0)
			return 0;

		String key = W + "codebix" + i;

		if (memo.containsKey(key))
			return memo.get(key);
		int op1 = val[i] + knapSackMemoization(W - wt[i], wt, val, i + 1, memo);
		int op2 = knapSackMemoization(W, wt, val, i + 1, memo);

		if (wt[i] <= W) {
			memo.put(key, Math.max(op1, op2));
			return Math.max(op1, op2);
		} else {
			memo.put(key, op2);
			return op2;
		}
	}

}
