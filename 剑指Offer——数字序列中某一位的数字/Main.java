public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.digitAtIndex(13));
		System.out.println(m.digitAtIndex(19));
	}

	public int digitAtIndex(int index) {
		if(index <= 9)
			return index;

		int digitNumber = 2;
		int base = 90;
		int count = digitNumber * base + 10;

		while(count < index) {
			digitNumber++;
			base *= 10;

			count += digitNumber * base;
		}

		int n = index - (count - digitNumber * base) + 1;

		int i = n / digitNumber;
		int j = n % digitNumber;

		if(j == 0) {
			i--;
			j = digitNumber;
		}

		return help(base,i,digitNumber - j);
	}

	public int help(int base,int i,int j) {
		base += (i - 1);

		while(j != 0) {
			j--;
			base /= 10;
		}
		return base % 10;
	}
}