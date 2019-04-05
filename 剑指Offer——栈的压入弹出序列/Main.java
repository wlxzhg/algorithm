import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();

		int[] push = {1,2,3,4,5};
		int[] pop = {4,3,5,1,2};

		System.out.println(m.isPopOrder(push,pop));
	}

	public boolean isPopOrder(int[] pushA,int[] popA) {
		LinkedList<Integer> stack = new LinkedList<Integer>();

		int i = 0, j = 0;
		int len = pushA.length;
		if(len != popA.length)
			return false;

		while(i < len || j < len) {
			Integer peek = stack.peek();
			if(peek != null && peek.equals(popA[j])) {
				stack.pop();
				j++;
			} else if(i < len) {
				stack.push(pushA[i]);
				i++;
			} else 
				break;
		}

		return (i == len) && (j == len);
	}
}