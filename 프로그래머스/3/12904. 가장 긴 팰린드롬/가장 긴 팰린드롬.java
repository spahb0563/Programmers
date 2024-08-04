import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        int length = 1;
    
        for(int i = 0 ; i < s.length() ; i ++) {
            queue.add(i);
        }
        
        int max = 0;
        
        while(true) {
            int size = queue.size();
            
            for(int i = 0 ; i < size ; i ++) {
                int idx = queue.poll();
                
                if(idx - ((length + 1) / 2) >= 0 && idx + ((length + 1) / 2) < s.length()) {
                    if(s.charAt(idx - ((length + 1) / 2)) == s.charAt(idx + ((length + 1) / 2))) queue.offer(idx);
                }
            }
            
            if(length + 2 > s.length() || queue.isEmpty()) break;
            length += 2;
        } 
        
        max = length;
        
        queue.clear();
        
        for(int i = 0 ; i < s.length() - 1; i ++) {
            if(s.charAt(i) == s.charAt(i + 1)) queue.add(i);
        }
        
        length = queue.isEmpty() ? 1 : 2;
        
        while(true) {
            int size = queue.size();
            
            for(int i = 0 ; i < size ; i ++) {
                int idx = queue.poll();
                
                if(idx - (((length + 2) / 2) - 1) >= 0 && idx + ((length + 2) / 2) < s.length()) {
                    if(s.charAt(idx - (((length + 2) / 2) - 1)) == s.charAt(idx + ((length + 2) / 2))) queue.offer(idx);
                }
            }
            
            if(length + 2 > s.length() || queue.isEmpty()) break;
            length += 2;
        } 
        
        return Math.max(length, max);
    }
}