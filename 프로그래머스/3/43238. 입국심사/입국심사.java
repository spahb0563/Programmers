import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long right = (long) Arrays.stream(times).max().getAsInt() * (long) n;
        
        long left = 1L;
        
        long center = 0;
    
        do {
            long sum = 0;
            center = (right + left) / 2;
            
            for(int i = 0 ; i < times.length ; i ++) {
                sum += center / (long) times[i];
            }
            
            if(sum < n) {
                left = center + 1;
            }else {
                right = center - 1;
                answer = center;
            }
            
        }while(left <= right);
        
        return answer;
    }
}