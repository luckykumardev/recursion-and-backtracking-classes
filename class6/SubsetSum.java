package class6;

public class SubsetSum {
	static boolean isSubsetSum(int set[], int i, int sum) {
		if (sum == 0)
			return true;
		if (i == set.length)
			return false;
        boolean op1  = isSubsetSum(set, i+1, sum - set[i]);
	    boolean op2  = isSubsetSum(set, i+1, sum);
		
		if (set[i] > sum)
			return op2;
		else
		return op2||op1;
	}
	
	public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		if (isSubsetSum(set, 0, sum) == true)
			System.out.println("Found a subset" + " with given sum");
		
		else
			System.out.println("No subset with" + " given sum");
	}

}
