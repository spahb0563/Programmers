import java.util.*;

class Solution {
    
    static Map<Integer, Integer> map;
    
    public int solution(int[][] scores) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        map = new HashMap<>();
                
        TreeSet<Integer> set = new TreeSet<>();
        
        int max = 0;
        
        Integer[] arr = new Integer[scores.length];
        
        for(int i = 0 ; i < scores.length ; i ++) {
            if(!map.containsKey(scores[i][0])) map.put(scores[i][0], scores[i][1]);
            
            if(map.get(scores[i][0]) < scores[i][1]) map.put(scores[i][0], scores[i][1]);
            
            set.add(scores[i][0]);
            
            max = Math.max(max, scores[i][0]);
            
            arr[i] = scores[i][0];
        }
        
        Arrays.sort(arr, Comparator.reverseOrder());
        
        for(int i = 1 ; i < arr.length ; i ++) {
            if(map.get(arr[i-1]) > map.get(arr[i])) map.put(arr[i], map.get(arr[i-1]));
        }
                
        for(int i = 0 ; i < scores.length ; i++) {
            boolean check = true;
            
            Integer higher = scores[i][0];
            
            while(set.higher(higher) != null) {
                higher = set.higher(higher);
                
                if(map.containsKey(higher) && map.get(higher) > scores[i][1]) {
                    check = false;
                    break;
                }else {
                    break;
                }
            }
            
            if(i == 0 && !check) return -1;
            
            if(check) list.add(i);
        }
        
        Collections.sort(list, (o1, o2)->{
           return (scores[o2][0] + scores[o2][1]) - (scores[o1][0] + scores[o1][1]);
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
            // System.out.println("rank : " + rank + " score : " + (scores[list.get(i)][0] + scores[list.get(i)][1]) + " current : " + current + " count : " + count);
            
            current = scores[list.get(i)][0] + scores[list.get(i)][1];
            
            if(current == (scores[0][0] + scores[0][1])) return rank;
            
        }
        
        return answer;
    }
}