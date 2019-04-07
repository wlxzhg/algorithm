public class Main {
	public static void main(String[] args) {
		Main m = new Main();

		System.out.println(m.getTranslationCount("10000"));
	}

	public int getTranslationCount(String str) {
		int len = str.length();
		int[] dp = new int[len];

		dp[len - 1] = 1;
		for(int i = len -2; i >= 0; i--){
			int first = str.charAt(i) - '0';
			int second = str.charAt(i + 1) - '0';
			int num = first * 10 + second;

			if(num > 0 && num <= 25 && i + 2 < len) {
				dp[i] = dp[i + 1] + dp[i + 2];
			} else {
				dp[i] = dp[i + 1];
			}
		}

		return dp[0];
	}


}