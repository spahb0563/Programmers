import java.util.*;

class Solution {
    
    static List<List<Integer>> list;
    
    static int n;

    static int max;
    
    static class Node {
        
        int idx;
        int count;
        
        Node(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }
    
    
    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(1, 0));
        
        int[] memo = new int[n+1];
        
        Arrays.fill(memo, Integer.MAX_VALUE);
        
        memo[1] = 0;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            int idx = node.idx;
            int count = node.count;
            
            if(memo[idx] < count) continue;
            
            if(max < count) max = count;
            
            for(int i = 0 ; i < list.get(idx).size(); i ++) {
                int nextIdx = list.get(idx).get(i);
    
                if(memo[nextIdx] > count + 1) {
                    memo[nextIdx] = count + 1;
                    
                    queue.add(new Node(nextIdx, count + 1));
                }
            }
        }
        
        int cnt = 0;
    
        for(int i = 0 ; i < n + 1 ; i ++) {
            if(memo[i] == max) cnt ++;
        }
        
        return cnt;
    }
    
    public int solution(int n, int[][] edge) {
        this.n = n ;
        
        list = new ArrayList<>();
        
        for(int i = 0 ; i < n + 1 ; i ++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < edge.length ; i ++) {    
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        
        return bfs();
    }
}
