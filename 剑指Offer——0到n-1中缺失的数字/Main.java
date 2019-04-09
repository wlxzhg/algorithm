public class Main {
	public static void main(String[] args) {
		int[] numbers = {0};

		System.out.println((new Main()).getMissingNumber(numbers));
	}

	public int getMissingNumber(int[] numbers) {
		if(numbers == null || numbers.length == 0)
			return -1;

		int len = numbers.length;
		int i = 0,j = len - 1;

		while(i <= j) {
			int mid = (i + j) / 2;
			if(numbers[mid] == mid) {
				i = mid + 1;
			} else if(mid == 0 || numbers[mid -1] == mid - 1){
				return mid;
			} else {
				j = mid - 1;
			}
		}
		return len;
	}
}