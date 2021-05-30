package class2;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsets {
	
	public static void main(String[] args) {
		int num[] = {1, 2, 3};
		subsets(num);
	}

	public static  void subsets(int num[]) {
		backtrack(new ArrayList<>(), num, 0);
		return;
	}

	private static void backtrack( List<Integer> tempList, int[] nums, int start) {
		 
		 if(start ==  nums.length){
			 for(int i =0;i <tempList.size(); i++)
			        System.out.print(tempList.get(i)+" ");  
		 }
		 
		System.out.println(); 
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack( tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	

}
