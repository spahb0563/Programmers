import java.util.*;

class Solution {
    
    static Map<String, List<String>> map = new HashMap<>();
    
    static String[] words;
    
    static class Node {
        
        String word;
        
        int count;
        
        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
        
    }
    
    static int bfs(String begin, String target) {
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(begin, 0));
        
        Map<String, Boolean> visit = new HashMap<>();
        
        visit.put(begin, false);
        
        for(int i = 0 ; i < words.length ; i ++) {
            visit.put(words[i], false);
        }
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(node.word.equals(target)) return node.count;
            
            if(visit.get(node.word)) continue;
            
            visit.put(node.word, true);
                        
            List<String> list = map.get(node.word);
            
            for(int i = 0 ; i < list.size() ; i ++) {
                String next = list.get(i);
                
                if(!visit.get(next)) {
                    queue.add(new Node(next, node.count + 1));
                }
            }
        }
        
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        
        map.put(begin, new ArrayList<>());
        
        for(int i = 0 ; i < words.length ; i ++) {
            int dif = 0;
            
            for(int j = 0 ; j < begin.length() ; j ++) {
                if(begin.charAt(j) != words[i].charAt(j)) dif++;
                
                if(dif > 1) break;
            }
            
            if(dif <= 1) map.get(begin).add(words[i]);
        }
        
        for(int i = 0 ; i < words.length ; i ++) {
            map.put(words[i], new ArrayList<>());
            
            for(int j = 0 ; j < words.length ; j ++) {
                if(i == j) continue;
                
                int dif = 0;
                
                for(int k = 0 ; k < words[i].length(); k ++) {
                    if(words[i].charAt(k) != words[j].charAt(k)) {
                        dif ++ ;
                    }
                    
                    if(dif > 1) break;
                }
                
                if(dif <= 1) {
                    map.get(words[i]).add(words[j]);
                }
            }
        }
        return bfs(begin, target);
    }
}