package class6;

public class EqualSumPartition {
	
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
	
	static boolean findPartition(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		return isSubsetSum(arr, 0, sum / 2);
	}

	public static void main(String[] args) {

		int arr[] = { 3, 1, 5, 9, 12 };
		int n = arr.length;
		if (findPartition(arr, n) == true)
			System.out.println("Can be divided into two subsets of equal sum");
		else
			System.out.println("Can not be divided into two subsets of equal sum");
	}
}
