import java.util.*;

class Solution {
    
    static Map<Integer, Integer> map;
    
    public int solution(int[][] scores) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        map = new HashMap<>();
                
        TreeSet<Integer> set = new TreeSet<>();
        
        Map<Integer, Integer> next = new HashMap<>();
        
        int max = 0;
        
        int[] sum = new int[scores.length];
        
        Integer[] arr = new Integer[scores.length];
        
        for(int i = 0 ; i < scores.length ; i ++) {
            if(!map.containsKey(scores[i][0])) map.put(scores[i][0], scores[i][1]);
            
            if(map.get(scores[i][0]) < scores[i][1]) map.put(scores[i][0], scores[i][1]);
            
            arr[i] = scores[i][0];
            sum[i] = scores[i][0] + scores[i][1]; 
        }
        
        Arrays.sort(arr, Comparator.reverseOrder());
        
        for(int i = 1 ; i < arr.length ; i ++) {
            if(map.get(arr[i-1]) > map.get(arr[i])) map.put(arr[i], map.get(arr[i-1]));
        }
        
        for(int i = arr.length - 1 ; i > 0 ; i --) {
            if(arr[i] < arr[i-1]) next.put(arr[i], arr[i-1]);
        }
                
        for(int i = 0 ; i < scores.length ; i++) {
            boolean check = true;
            
            if(next.containsKey(scores[i][0])) {
                int n = next.get(scores[i][0]);
                
                if(map.containsKey(n) && map.get(n) > scores[i][1]) {
                    check = false;
                }
            }
            
            if(i == 0 && !check) return -1;
            
            if(check) list.add(i);
        }
        
        Collections.sort(list, (o1, o2)->{
           return (sum[o2]) - (sum[o1]);
        });
        
        int rank = 1;
        
        int count = 0;
        
        int current = scores[list.get(0)][0] + scores[list.get(0)][1];
        
        for(int i = 0 ; i < list.size() ; i ++) {
            
            
            if(current != scores[list.get(i)][0] + scores[list.get(i)][1]) {
                rank += count;  
                count = 1;
            }else {
                count ++;
            }
            
            current = scores[list.get(i)][0] + scores[list.get(i)][1];
            
            if(current == sum[0]) return rank;
            
        }
        
        return answer;
    }
}