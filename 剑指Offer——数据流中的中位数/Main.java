import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int[] arr = {1,2,9,8,0,3,2};
		for(int i : arr) {
			m.Insert(i);
			System.out.println(m.GetMedian());
		}
	}

	private PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1,Integer o2) {
			return o2 - o1;
		}
	});

	private PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();

	private int count = 0;

	public void Insert(Integer num) {
    	if((count & 0x01) == 0) {
    		Integer topOfMax = maxQueue.peek();
    		if(topOfMax != null && topOfMax > num) {
    			maxQueue.offer(num);
    			num = maxQueue.poll();
    		}
    		minQueue.offer(num);
    	} else {
    		Integer topOfMin = minQueue.peek();
    		if(topOfMin != null && topOfMin < num) {
    			minQueue.offer(num);
    			num = minQueue.poll();
    		}
    		maxQueue.offer(num);
    	}
    	count++;
    }

    public Double GetMedian() {
    	if((count & 0x01) == 1) {
    		return minQueue.peek() + 0.0;
    	} else {
    		return (maxQueue.peek() + minQueue.peek()) / 2.0;
    	}
    }
}