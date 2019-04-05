import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();

		System.out.println((new Main()).getUgleNumber(number));	
	}


	public int getUgleNumber(int num) {
		if(num <= 0) 
			throw new IllegalArgumentException();

		int[] uglys = new int[num];
		uglys[0] = 1;

		int[] indexOfUgly = {0,0,0};
		int[] baseOfUgly = {2,3,5};

		for(int i = 1; i < num; i++) {
			int min = 0;
			for(int j = 1; j < 3; j++) {
				if((uglys[indexOfUgly[j]] * baseOfUgly[j]) < (uglys[indexOfUgly[min]] * baseOfUgly[min]))
					min = j;
			}

			uglys[i] = baseOfUgly[min] * uglys[indexOfUgly[min]];
			if(uglys[i] <= uglys[i - 1]) {
				i--;
			}
			indexOfUgly[min]++;
		}

		System.out.println(Arrays.toString(uglys));

		return uglys[num - 1];
	}
}