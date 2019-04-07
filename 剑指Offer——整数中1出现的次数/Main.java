import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		Scanner sc = new Scanner(System.in);

		int i = sc.nextInt();

		System.out.println(m.NumberOf1Between1AndN_Solution(i));
	}

    public int NumberOf1Between1AndN_Solution(int n) {
 		if(n <= 0)
 			return 0;

 		char[] arr = String.valueOf(n).toCharArray();

 		return numberOf1Between1AndN(arr,0);
 	}

 	public int numberOf1Between1AndN(char[] arr,int index) {
 		if(arr == null || arr.length == 0 || index >= arr.length || index < 0)
 			return 0;

 		int length = arr.length - index;

 		int firstDigit = arr[index] - '0';

 		if(length == 1) {
 			if(firstDigit == 0)
 				return 0;
 			else
 				return 1;
 		}

 		int firstPart = 0,secondPart = 0,thirdPart = 0;

 		if(firstDigit == 1) 
 			firstPart = charToInt(arr,index + 1) + 1;
 		else if(firstDigit > 1)
 			firstPart = (int)Math.pow(10,length - 1);

 		secondPart = firstDigit * (length - 1) * (int)Math.pow(10,length - 2);

 		thirdPart = numberOf1Between1AndN(arr,index + 1);

 		return firstPart + secondPart + thirdPart; 
 	}

 	public int charToInt(char[] arr,int index) {
 		int ans = 0;
 		for(int i = index; i < arr.length; i++) {
 			ans = (ans * 10) + (arr[i] - '0');
 		}

 		return ans;
 	}
}