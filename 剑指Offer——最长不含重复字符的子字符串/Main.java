import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.longestSubstringWithoutDuplication("arabcacfr"));
	}

	public int longestSubstringWithoutDuplication(String str) {
		if(str == null || str.length() == 0)
			return 0;

		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		int length = str.length();
		int[] dp = new int[length];

		dp[0] = 1;
		map.put(str.charAt(0),0);

		int ans = dp[0];

		for(int i = 1; i < length; i++) {
			Integer lastIndex = map.get(str.charAt(i));

			if(lastIndex == null) 
				dp[i] = dp[i - 1] + 1;
			else {
				int distance = i - lastIndex;
				if(distance <= dp[i - 1])
					dp[i] = distance;
				else 
					dp[i] = dp[i - 1] + 1;
			}

			map.put(str.charAt(i),i);
			if(dp[i] > ans)
				ans = dp[i];
		}
		return ans; 
	}
}