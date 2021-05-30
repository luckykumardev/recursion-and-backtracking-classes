package class2;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int num[] = { 1, 2, 3 };
		permute(num);
	}

	public static void permute(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		backtrack(nums, new ArrayList(), visited);
		return;
	}

	static void backtrack(int[] nums, List<Integer> curr, boolean[] visited) {
		if (curr.size() == nums.length) {
			for (int i = 0; i < curr.size(); i++)
				System.out.print(curr.get(i));
			System.out.println();
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i] == true)
				continue;
			curr.add(nums[i]);
			visited[i] = true;
			backtrack(nums, curr, visited);
			curr.remove(curr.size() - 1);
			visited[i] = false;
		}
	}

}
