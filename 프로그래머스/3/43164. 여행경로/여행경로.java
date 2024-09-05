import java.util.*;

class Solution {
    
    static Map<String, List<String>> tikets;
    
    static Map<String, List<Boolean>> visit;
    
    static Set<String> set = new HashSet<>();
    
    static StringBuffer sb = new StringBuffer();
    
    static int n;
    
    static String answer = "";
    
    static void dfs(String[] arr, String from, int r, int depth) {
        
        if(r == depth) {
            
            set.clear();
            set.add("ICN");
            StringBuffer sb = new StringBuffer("ICN ");
            
            for(int i = 0 ; i < arr.length ; i ++) {
                set.add(arr[i]);
                sb.append(arr[i] + " ");
            }
            
            if(set.size() == n) {
                if(answer.equals("")) {
                    answer = sb.toString();
                }else {
                    
                    if(answer.compareTo(sb.toString()) > 0) answer = sb.toString();
                    
                }
            }
            
        }
        
        if(tikets.get(from) != null) {
            for(int i = 0 ;  i < tikets.get(from).size() ; i ++) {
                if(visit.get(from).get(i)) continue;
                visit.get(from).set(i, true);
                arr[depth] = tikets.get(from).get(i);
                dfs(arr, tikets.get(from).get(i), r, depth  + 1);
                visit.get(from).set(i, false);
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        tikets = new HashMap<>();
        
        visit = new HashMap<>();
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0 ; i < tickets.length; i ++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            if(!tikets.containsKey(from)) {
                tikets.put(from, new ArrayList<>());
            }
            
            if(!visit.containsKey(from)) {
                visit.put(from, new ArrayList<>());
            }
            
            tikets.get(from).add(to);
            visit.get(from).add(false);
            set.add(from);
            set.add(to);
        }
        
        n = set.size();
        
        dfs(new String[tickets.length], "ICN", tickets.length,0);
        
        return answer.split(" ");
    }
}