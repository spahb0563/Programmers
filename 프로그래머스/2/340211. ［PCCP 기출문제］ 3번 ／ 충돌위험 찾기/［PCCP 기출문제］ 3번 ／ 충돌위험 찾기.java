import java.util.*;

class Solution {
    
    static int[][] points;
    static int[][] routes;
    
    static class Node {
        int r,c;
        
        Node(int r, int c) {
            this.r = r ;
            this.c = c ;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        this.points = points;
        this.routes = routes;
    
        Queue<Queue<Node>> list = new LinkedList<>();
        
        for(int i = 0 ; i < routes.length ; i ++) {
            
            Queue<Node> route = new LinkedList<>();
    
            for(int j = 0 ; j < routes[i].length - 1 ; j ++) {
                
                int startIdx = routes[i][j];
                int endIdx = routes[i][j + 1];
                
                int startR = points[startIdx - 1][0];
                int startC = points[startIdx - 1][1];
                
                int endR = points[endIdx - 1][0];
                int endC = points[endIdx - 1][1];
                
                if(j == 0) {
                    route.add(new Node(startR, startC));
                }
                
                if(startR < endR) {
                    for(int r = startR + 1; r <= endR ; r ++) {
                        route.add(new Node(r, startC));
                    }         
                }else {
                    for(int r = startR - 1; r >= endR ; r --) {
                        route.add(new Node(r, startC));
                    }
                }
                
                if(startC < endC) {
                    for(int c = startC + 1 ; c <= endC ; c ++) {
                        route.add(new Node(endR, c));
                    }
                }else {
                    for(int c = startC - 1; c >= endC ; c --) {
                        route.add(new Node(endR, c));
                    }
                }
            }
            list.add(route);
        }
        
        int[][] map = new int[101][101];
        
        Queue<Node> removeQueue = new LinkedList<>();
    
        
        while(true) {
            boolean isAllEmpty = true;
            
            for(int i = 0 ; i < routes.length ; i ++) {
                 Queue<Node> route = list.poll();
                
                if(!route.isEmpty()) {
                    isAllEmpty = false;

                    Node node = route.poll();

                    removeQueue.add(node);

                    map[node.r][node.c]++;

                    if(map[node.r][node.c] == 2) answer++;
                }
                
                list.add(route);
            }
            
            if(isAllEmpty) break;
            
            while(!removeQueue.isEmpty()) {
                Node node = removeQueue.poll();
                map[node.r][node.c]--;
            }
        }
        
        return answer;
    }
}