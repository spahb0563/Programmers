import java.util.*;

class Solution {
    
    public int solution(int[] A, int[] B) {
       
        Arrays.sort(A);
        
        Arrays.sort(B);
        
        int idxA = 0;
        
        int idxB = 0;
        
        int cnt = 0;
        
        while(idxA < A.length && idxB < B.length) {
            
            int a = A[idxA];
            
            int b = B[idxB];
            
            if(a < b) {
                cnt++;
                idxA++;
                idxB++;
            }else {
                idxB++;
            }
        }
        
        
        
        return cnt;
    }
}