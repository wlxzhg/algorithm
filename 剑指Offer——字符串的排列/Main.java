import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    Main m = new Main();

    // ArrayList<String> strs = m.Permutation("abc");
    Scanner sc = new Scanner(System.in);
    System.out.println(m.Permutation(sc.nextLine()));

    // System.out.println(strs);
  }

  public ArrayList<String> Permutation(String str) {
    ArrayList<String> ans = new ArrayList<String>();

    if(str == null || str.length() == 0)
      return ans;

    char[] arr = str.toCharArray();

    dfs(arr,0,ans);

    Collections.sort(ans);

    return ans;
  }

  //回溯法，别忘了交换回来
  public void dfs(char[] arr,int index,ArrayList<String> ans) {
    int last = arr.length - 1;
    if(index == last) {
      ans.add(String.valueOf(arr));
      return;
    }

    for(int i = index; i <= last; i++) {
      if(i != index && arr[i] == arr[index])
        continue;

      swap(arr,i,index);
      dfs(arr,index + 1,ans);
      swap(arr,i,index);
    }
  }

  public void swap(char[] arr,int i,int j) {
    char c = arr[i];
    arr[i] = arr[j];
    arr[j] = c;
  }
}