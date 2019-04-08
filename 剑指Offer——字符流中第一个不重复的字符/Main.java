import java.util.Arrays;

public class Main {
    int index = 0;
    int[] count = new int[256];
    {
        Arrays.fill(count,-1);
    }
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(count[ch] == -1) {
            count[ch] = index;
        } else {
            count[ch] = -2;
        }
        index++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char ans = '#';
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 256; i++) {
            if(count[i] >= 0 && count[i] < min) {
                min = count[i];
                ans = (char)i;
            }
        }
        
        return ans;
    }
}