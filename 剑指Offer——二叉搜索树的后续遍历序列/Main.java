public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.VerifySquenceOfBST(new int[]{5,7,6,9,11,10,8}));
		System.out.println(m.VerifySquenceOfBST(new int[]{5,4,3,2,1}));
		System.out.println(m.VerifySquenceOfBST(new int[]{7,4,}));
	
	}

	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence == null || sequence.length == 0)
			return false;

		return VerifySquenceOfBST(sequence,0,sequence.length - 1);
	}

	public boolean VerifySquenceOfBST(int[] sequence,int start,int end) {
		if(start == end)
			return true;
		if(start > end)
			return false;

		int i = start;
		int root = sequence[end];
		while(i < end && sequence[i] < root)
			i++;

		int j = i;
		while(j < end) {
			if(sequence[j++] < root) {
				return false;
			}
		}

		boolean left = false,right = false;

		if(i == start) left = true;
		else left = VerifySquenceOfBST(sequence,start,i - 1);

		if(i == end) right = true;
		else right = VerifySquenceOfBST(sequence,i,end - 1);

		return left && right;
	}
}