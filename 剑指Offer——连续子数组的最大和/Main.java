public class Main {
	public static void main(String[] args) {
		Main m = new Main();

		System.out.println(m.FindGreatestSumOfSubArray(new int[]{-1,-2,-3,-10,-4,-7,-2,-5}));
	}


	public int FindGreatestSumOfSubArray(int[] array) {
    	int maxSum = Integer.MIN_VALUE;
    	int sum = 0;

    	for(int i = 0; i < array.length; i++) {
    		if(sum < 0)
    			sum = 0;
    		sum += array[i];
    		if(sum > maxSum)
    			maxSum = sum;
    	}  

    	return maxSum;  
    }
}