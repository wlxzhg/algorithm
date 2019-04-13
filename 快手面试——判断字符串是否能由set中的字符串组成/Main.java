import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        String s= "catanddog";
        HashSet<String> set = new HashSet<String>();
        set.add("ca");
        set.add("and");
        set.add("dog");
        
        System.out.println(m.func(s,set));
    }
    
    public boolean func(String str,HashSet<String> set) {
        if(str == null || str.length() == 0)
            return true;
        
        int len = str.length();
        
        boolean[][] dp = new boolean[len][len];
       
        for(int l = 1; l <= len; l++) {
            for(int i = 0; i <= len - l; i++) {
                String s = str.substring(i,i + l);

                if(set.contains(s)) {
                    dp[i][i + l - 1] = true;
                    System.out.println(s + "\t" + dp[i][i + l - 1]);
                    continue;
                } else {
                    for(int k = i; k < i + l - 1; k++) {
                        if(dp[i][k] && dp[k + 1][i + l - 1]) {
                            dp[i][i + l - 1] = true;
                            System.out.println(s + "\t" + dp[i][i + l - 1]);
                            break;
                        }
                    }
                }

                System.out.println(s + "\t" + dp[i][i + l - 1]);
            }            
        }
        
        return dp[0][len-1];
    }
}