package class7;

public class TagetSum {
	public static int findTargetSumWays(int[] nums, int target) {
		int count = rec(nums, target, 0, 0);
		return count;
	}

	private static int rec(int nums[], int target, int i, int sum) {

		if (i == nums.length) {
			if (sum == target){
				return 1;
			}
			else
				return 0;
		}

		int op1 = rec(nums, target, i + 1, sum + nums[i]);
	    int op2 = rec(nums, target, i + 1, sum - nums[i]);
		return op1 + op2;
	}
	
	public static void main(String[] args) {
		int nums[] = {1,1,1,1,1};
		int target = 3;
		int output = findTargetSumWays(nums, target);
		System.out.println(output);
	}
}
