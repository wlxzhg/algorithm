import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] numbers = {3,4,2,1,0,10};
		QuickSort q = new QuickSort();
		q.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
	public void sort(int[] numbers) {
		if(numbers == null || numbers.length == 0)
			return;

		sort(numbers,0,numbers.length - 1);
	}

	public void sort(int[] numbers,int start,int end) {
		if(start < end) {
			int index = partition(numbers,start,end);
			sort(numbers,start,index - 1);
			sort(numbers,index + 1,end);
		}
	}

	public int partition(int[] numbers,int start,int end) {
		int small = start - 1;
		int tmp = numbers[start];
		swap(numbers,start,end);

		for(int i = start; i < end; i++) {
			if(numbers[i] < tmp) {
				small++;
				if(small != i)
					swap(numbers,small,i);
			}
		}
		small++;
		swap(numbers,small,end);
		return small;
	}

	public void swap(int[]numbers,int i,int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}