package class7;


/*
  Input: coins = [1,2,5], amount = 11 
  Output: 3
  Explanation: 11 = 5 + 5 + 1
*/
public class CoinChange {
	
	public static void main(String[] args) {
	   int coins[] = {1, 2, 5};
	   int ans  = coinChange(coins,11);
  	   System.out.println(ans);
	}
	
	public static int coinChange(int[] coins, int amount) {
        int ans = isSubsetSum(coins, 0, amount, 0);
		return ans != Integer.MAX_VALUE ? ans : -1;
	}

	static int isSubsetSum(int set[], int i, int sum, int coins) {
		if (sum == 0)
			return coins;
		if (i == set.length || sum < 0)
			return Integer.MAX_VALUE;

		if (set[i] > sum) {
			int op2 = isSubsetSum(set, i + 1, sum, coins);
			return op2;
		} else {
			int op1 = isSubsetSum(set, i, sum - set[i], coins + 1);
			int op2 = isSubsetSum(set, i + 1, sum, coins);
			return Math.min(op1, op2);
		}
	}
}
