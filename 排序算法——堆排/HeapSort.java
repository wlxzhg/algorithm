import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		HeapSort h = new HeapSort();
		int[] numbers = {5,3,8,2,4,6,-1};
		h.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}

	public void sort(int[] numbers) {
		if(numbers == null || numbers.length == 0)
			return;

		for(int i = numbers.length / 2; i >= 0; i--) {
			preDown(numbers,i,numbers.length);
		}

		for(int i = numbers.length - 1; i > 0; i--) {
			swap(numbers,0,i);
			preDown(numbers,0,i);
		}
	}

	public void preDown(int[] numbers,int i,int n) {
		int tmp,child;
		for(tmp = numbers[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if(child != n - 1 && numbers[child + 1] > numbers[child])
				child++;
			if(numbers[child] > tmp)
				numbers[i] = numbers[child];
			else
				break;
		}

		numbers[i] = tmp;
	}

	public int leftChild(int i) {
		return i * 2 + 1;
	}

	public void swap(int[] numbers,int i,int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}