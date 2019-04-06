import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();

		ArrayList<Integer> ans = m.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},3);

		System.out.println(ans);
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> ans = new ArrayList<Integer>();

		if(input == null || input.length == 0 || k <= 0 || k > input.length) {
			return ans;
		}

		int index = 0;
		int start = 0,end = input.length - 1;
		while(start < end) {
			index = partition(input,start,end);
			if(index == k - 1) {
				break;
			} else if(index >= k) {
				end = index - 1;
			} else {
				start = index + 1;
			}
		}

		for(int i = 0; i < k; i++)
			ans.add(input[i]);
		return ans;
	}

	public int partition(int[] input,int start,int end) {
		int small = start - 1;
		int tmp = input[start];
		swap(input,start,end);

		for(int i = start; i < end; i++) {
			if(input[i] < tmp) {
				small++;
				if(small != i)
					swap(input,small,i);
			}
		}
		small++;
		swap(input,small,end);
		return small;
	}

    public void swap(int[] input,int i,int j) {
    	int tmp = input[i];
    	input[i] = input[j];
    	input[j] = tmp;
    }
}