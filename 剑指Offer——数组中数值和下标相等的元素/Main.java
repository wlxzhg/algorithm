public class Main {
	public static void main(String[] args) {
		Main m = new Main();

		System.out.println(m.getNumberSameAsIndex(new int[] {-3,0,1,2,3,5}));
	}

	public int getNumberSameAsIndex(int[] numbers) {
		if(numbers == null || numbers.length == 0)
			return -1;

		int len = numbers.length;
		int i = 0,j = len - 1;
		while(i <= j) {
			int mid = (i + j) / 2;
			if(numbers[mid] == mid) {
				return mid;
			} else if(numbers[mid] > mid) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return -1;
	}
}