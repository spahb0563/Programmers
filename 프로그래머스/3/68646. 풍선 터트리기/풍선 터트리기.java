import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int[] left = new int[a.length + 1];
        int[] right = new int[a.length + 1];
        
        left[0] = Integer.MAX_VALUE;
        right[right.length - 1] = Integer.MAX_VALUE;
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < a.length; i ++) {
            min = Math.min(a[i], min);
            
            left[i+1] = min;
        }
    
        min = Integer.MAX_VALUE;
        for(int i = a.length - 1 ; i >= 0 ; i --) {
            min = Math.min(a[i], min);
    
            right[i] = min;
        }
        
        for(int i = 0 ; i < a.length; i ++) {
            int leftMinNumber = left[i];
            
            int rightMinNumber = right[i+1];
            
            if(a[i] > leftMinNumber && a[i] > rightMinNumber) continue;
            
            answer++;
        }
        
        return answer;
    }
}