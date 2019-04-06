import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();

		ArrayList<Integer> ans = m.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},1);

		System.out.println(ans);
		
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		if(input == null || input.length == 0 || k <= 0 || k > input.length)
			return new ArrayList<Integer>();

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1,Integer o2) {
				return o2 - o1;
			}
		});

		for(int i = 0; i < k; i++)
			queue.offer(input[i]);

		for(int i = k; i < input.length; i++) {
			if(queue.peek() > input[i]) {
				queue.poll();
				queue.offer(input[i]);
			}
		}

		return new ArrayList<Integer>(queue);
	}
}