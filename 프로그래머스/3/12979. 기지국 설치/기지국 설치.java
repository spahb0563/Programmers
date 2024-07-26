import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int[][] arr = new int[stations.length][2];
        
        for(int i = 0 ; i < stations.length; i ++) {
            
            int center = stations[i];
            
            int start = center - w;
            
            start = start < 1 ? 1 : start;
            
            int end = center + w;
            
            end = end > n ? n : end;
            
            arr[i][0] = start;
            arr[i][1] = end;
        }
        
        for(int i = 1 ; i < arr.length; i ++) {
            if(arr[i][0] > arr[i-1][1] + 1) {
                int range = arr[i][0] - arr[i-1][1] - 1;
                
                answer += range / (w*2+1);
                
                if(range % (w*2+1) != 0) {
                    answer++;
                }
            }            
        }
        
        if(arr[0][0] > 1) {
            int range = arr[0][0] - 1;
            
            answer += range / (w*2+1);
                
            if(range % (w*2+1) != 0) {
                answer++;
            }
        }
        
        if(arr[arr.length - 1][1] < n) {
            int range = n - arr[arr.length - 1][1];
            
            answer += range / (w*2+1);
                
            if(range % (w*2+1) != 0) {
                answer++;
            }
        }
        
        if(stations.length == 0) {
            int range = n;
            
            answer += range / (w*2+1);
                
            if(range % (w*2+1) != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}