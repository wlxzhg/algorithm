public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.equals(""))
            return -1;
        int[] pos = new int[256];
        
        for(int i = 0; i < str.length(); i++) {
            pos[str.charAt(i)]++;
        }
        
        int ans = -1;
        for(int i = 0; i < str.length(); i++) {
            if(pos[str.charAt(i)] == 1) {
                ans = i;
                break;                
            }
        }
        return ans;
    }
}