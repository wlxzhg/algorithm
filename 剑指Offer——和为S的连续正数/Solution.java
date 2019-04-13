import java.util.ArrayList;
public class Solution {
	public static void main(String[] args) throws Exception {
		Solution so = new Solution();

		ArrayList<ArrayList<Integer>> ans = so.FindContinuousSequence(100);

		for(ArrayList<Integer> a : ans)
			System.out.println(a);
	}

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) throws Exception{
       ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        int small = 1,big = 2;
        int end = sum / 2,curSum = big + small;
        
        while(small <= end && small < big) { 
        	// System.out.println(small + "\t" + big);
        	// Thread.sleep(300);           
            if(curSum == sum) {
                ArrayList<Integer> a = new ArrayList<Integer>();
                for(int i = small; i <= big; i++)
                    a.add(i);
                ans.add(a);
                curSum -= small;
                small++;
            } else if(curSum < sum) {
                big++;
                curSum += big;
            } else {
                curSum -= small;
                small++;
            }
        }
        
        return ans;
    }
}