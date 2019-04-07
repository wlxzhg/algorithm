import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		Main m = new Main();

		int[][] values = {
			{1,10,3,8},
			{12,2,9,6},
			{5,7,4,11},
			{3,7,16,5}
		};

		System.out.println(m.getMaxValue(values));
	}

	public int getMaxValue(int[][] values) {
		int row = values.length,col = values[0].length;
		int[] dp = new int[col];

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				int up = 0,left = 0;
				if(j > 0)
					left = dp[j - 1];
				up = dp[j];

				dp[j] = values[i][j] + Math.max(up,left);
			}
		}

		return dp[col - 1];
	}
}