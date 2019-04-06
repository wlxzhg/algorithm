public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.MoreThanHalfNum_Solution(new int[]{1,2,3,2,4,2,5,2,3}));
	}

	public int MoreThanHalfNum_Solution(int [] array) {
		if(array == null || array.length == 0)
			return 0;
		int answer = array[0];
		int count = 1;

		for(int i = 1; i < array.length; i++) {
			if(array[i] == answer)
				count++;
			else
				count--;
			if(count == 0) {
				answer = array[i];
				count = 1;
			}
		}    

		count = 0;
		for(int i : array) {
			if(i == answer)
				count++;
		}
		if(count <= array.length / 2)
			answer = 0;

		return answer;
    }
}