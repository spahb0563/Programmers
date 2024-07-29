import java.util.*;

class Solution {
    
    static int[] answer;
        
    static int n;
    
    static List<List<Integer>> adjacent;
    
    static int[] arr;
    
    static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(start);
    
        boolean[] visit = new boolean[n + 1];
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            int road = node.road;
            int count = node.count;
            
            if(visit[road]) continue;
            
            if(arr[road] == -1 || arr[road] > count) arr[road] = count;
        
            if(arr[road] < count) continue;
            
            visit[road] = true;
            
            List<Integer> list = adjacent.get(road);
            
            for(Integer to : list) {
                if(!visit[to]) queue.add(new Node(to, count + 1));
            }
        }
    }
    
    static class Node {
        
        int road;
        
        int count;
        
        Node(int road, int count) {
            this.road = road;
            this.count = count;
        }
        
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        answer = new int[sources.length];
        adjacent = new ArrayList<>();
        
        arr = new int[n+1];
        
        Arrays.fill(arr, -1);
        
        this.n = n;
    
        for(int i = 0 ; i < n + 1; i ++) {
            adjacent.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < roads.length; i ++) {
            int from = roads[i][0];
            
            int to = roads[i][1];
            
            adjacent.get(from).add(to);
            adjacent.get(to).add(from);
        }
        
        bfs(new Node(destination, 0));
        
        for(int i = 0 ; i < sources.length ; i ++){
            answer[i] = arr[sources[i]];
        }
        
        return answer;
    }
}