import java.util.*;

class Solution {
    
    static Map<Integer, List<Edge>> adjacent;
    
    static int[] dijkstra(int[] arr, int from) {
        arr[from] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        pq.add(new Edge(from, 0));
        
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            int to = edge.to;
            
            List<Edge> list = adjacent.get(to);
            
            for(int i = 0 ; i < list.size() ; i ++) {
                Edge next = list.get(i);
                
                if(arr[next.to] > arr[to] + next.weight) {
                    arr[next.to] = arr[to] + next.weight;
                    pq.add(new Edge(next.to, arr[next.to]));
                }
            }
        }
        return arr;
    }
    
    static class Edge implements Comparable{
        int to;
        
        int weight;
        
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        public int compareTo(Object edge) {
            return this.weight - ((Edge)edge).weight;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        adjacent = new HashMap<>();
        
        int[] fromS = new int[n + 1];
        int[] fromA = new int[n + 1];
        int[] fromB = new int[n + 1];
        
        for(int i = 1 ; i < n + 1 ; i ++) {
            if(i != s) fromS[i] = 20000000;
            if(i != a) fromA[i] = 20000000;
            if(i != b) fromB[i] = 20000000;
            
            adjacent.put(i, new ArrayList<>());
        }
        
        for(int i = 0 ; i < fares.length ; i ++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int distance = fares[i][2];
            
            adjacent.get(from).add(new Edge(to, distance));
            adjacent.get(to).add(new Edge(from, distance));
        }
        
        fromS = dijkstra(fromS, s);
        fromB = dijkstra(fromB, b);
        fromA = dijkstra(fromA, a);
        
        for(int i = 1 ; i < n + 1 ; i ++) {
            answer = Math.min(fromS[i] + fromB[i] + fromA[i], answer);
        }
        
        return answer;
    }
}