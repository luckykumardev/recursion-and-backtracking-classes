package class6;

/*
   first count and then Print all subsets with given sum
   
   Input : arr[] = {2, 3, 5, 6, 8, 10}
   sum = 10
   Output : 5 2 3
            2 8
            10
*/
public class perfectSum {
    static int c  = 0;
	private static void countSum(int sum, int[] arr, int i) {
        if(sum == 0){ 
        	c++;
        }if(i == arr.length){
             return;			
		}   
		 countSum(sum - arr[i], arr, i+1);
		 countSum(sum, arr, i+1);
		
		return;
	}
	
	
	
	public static void main(String[] args) {
        int sum =10;
        int arr[] = {2, 3, 5, 6, 8, 10};
		countSum(sum, arr, 0);
		System.out.println(c);
		c = 0;
	}
}
