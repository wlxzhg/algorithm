import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();

		System.out.println(m.PrintMinNumber(new int[] {3,32,321,1,2}));
	}

	public String PrintMinNumber(int [] numbers) {
		String[] strs = new String[numbers.length];

		for(int i = 0; i < numbers.length; i++) {
			strs[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(strs,new Comparator<String>() {
			@Override
			public int compare(String s1,String s2) {
				return (s1 + s2).compareTo(s2 + s1);
			}
		});

		StringBuilder sb = new StringBuilder();
		for(String s : strs) 
			sb.append(s);

		return sb.toString();
    }
}