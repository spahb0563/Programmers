import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
         
        Arrays.sort(routes, (o1, o2)->{
            return o1[1] - o2[1];
        });
        
        int camera = routes[0][1];    
        
        for(int i = 1 ; i < routes.length ; i ++) {
            if(camera >= routes[i][0]) {
                continue;
            }else {
                camera = routes[i][1];
                answer++;
            } 
        }
        
        
        
        
        
        
        return answer;
    }
}