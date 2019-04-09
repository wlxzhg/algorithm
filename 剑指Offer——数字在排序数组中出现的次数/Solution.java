public class Solution {
    public int GetNumberOfK(int [] array , int k) {
       if(array == null || array.length == 0)
           return 0;
        
        int i = 0,j = array.length - 1;
        int start = -1,end = -1;
        while(i <= j) {
            int mid = (i + j) / 2;
            if(array[mid] == k) {
                if(mid == 0 || array[mid - 1] != k) {
                    start = mid;
                    break;
                } else {
                    j = mid - 1;
                }
            } else if(array[mid] > k)
                j = mid - 1;
            else i = mid + 1;
        }
        if(start == -1) return 0;
        
        i = start;
        j = array.length - 1;
        while(i <= j) {
            int mid = (i + j) / 2;
            if(array[mid] == k) {
                if(mid == array.length - 1 || array[mid + 1] != k) {
                    end = mid;
                    break;
                } else 
                    i = mid + 1;
            } else if(array[mid] > k) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return (end - start + 1);
    }
}