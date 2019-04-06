import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
	}

	public ArrayList<String> Permutation(String str) {
       ArrayList<String> answer = new ArrayList<String>();

       if(str == null || str.length() == 0)
       	return answer;

       char[] arr = str.toCharArray();

       dfs(arr,0,answer);
    }

    public void dfs(char[] arr,int index,ArrayList<String> answer) {
    	int last = arr.length - 1;

    	if(index == last) {
    		answer.add()
    	}
    	for(int i = index; i < last; i++) {

    	}
    }
}