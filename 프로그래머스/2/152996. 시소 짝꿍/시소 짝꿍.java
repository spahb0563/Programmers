import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Long> map = new HashMap<>();
        
        for(int i = 0 ; i < weights.length ; i ++) {
            int weight = weights[i];
    
            map.put(weight, map.getOrDefault(weight, 0L) + 1L);
        }
        
        for(int weight : map.keySet()) {
            long count = map.get(weight);
            
            answer += (count * (count - 1L)) / 2L;
        }
        
        for(int i = 0 ; i < weights.length ; i ++) {
            
            int weight = weights[i];
            
            if(map.containsKey(weight * 2)) {
                answer += map.get(weight * 2);
            }
            
            if((((double)weight * 3) / 2) % 1 == 0 && map.containsKey((weight * 3) / 2)) {
                answer += map.get((weight * 3) / 2);
            }
            
            if((((double)weight * 4) / 3) % 1 == 0 && map.containsKey((weight * 4) / 3)) {
                answer += map.get((weight * 4) / 3);
            }
        }
        
        
        return answer;
    }
}