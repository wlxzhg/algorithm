class Solution {
	public static void main(String[] args) {
		Solution so = new Solution();

		System.out.println(so.longestPalindrome("babad"));
		System.out.println(so.longestPalindrome("cbbd"));

	}

    public String longestPalindrome(String s) {
        if(s == null || s.equals(""))
        	return "";
       

        int len = s.length();

        boolean [][] dp = new boolean[len][len];

        int start = 0,end = 0;

        for(int i = 0; i < len; i++) {
        	dp[i][i] = true;
        	if(i != len - 1 && s.charAt(i) == s.charAt(i + 1)) {
        		dp[i][i + 1] = true;
        		start = i;
        		end = i + 1;
        	}
        } 


        for(int l = 3; l <= len; l++) {
        	for(int i = 0; i <= len - l; i++) {
        		if(dp[i + 1][i + l - 2] && s.charAt(i) == s.charAt(i + l - 1)) {
        			dp[i][i + l - 1] = true;
        			if(l > (end - start + 1)) {
        				start = i;
        				end = i + l - 1;
        			}
        		}
        	}
        }

        return s.substring(start,end + 1);
    }
}