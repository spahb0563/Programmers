import java.util.*;

class Solution {
    static char[] ch = {'d','l','r','u'};
    static int[][] coor = {{1,0}, {0,-1}, {0,1}, {-1, 0}};
    
    static int[][] distance;
    
    static int n,m,r,c;
    
    static String answer;
    
    static void dfs(char[] arr, int x, int y, int z, int depth) {
        if(answer != null) return;
        
        if(depth == z) {
            if(x == r && y == c) {
                answer = new String(arr);
            }
            return;
        }
        
        for(int i = 0 ; i < 4 ; i ++) {
            int newX = x + coor[i][0];
            int newY = y + coor[i][1];
            if(newX >= 0 && newY >= 0 && newY < m && newX < n) {
                if(distance[newX][newY] > z - depth) continue;
                arr[depth] = ch[i];
                dfs(arr, newX, newY, z, depth + 1);
            }
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = null;
        
        this.r = r - 1;
        this.c = c - 1;
        this.n = n;
        this.m = m;
        
        distance = new int[n][m];
        
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                distance[i][j] = Math.abs(i - (r - 1)) + Math.abs(j - (c - 1));
            }
        }
        
        if(distance[x-1][y-1] > k) return "impossible";
        
        if(distance[x-1][y-1] % 2 != k % 2) return "impossible";
        
        dfs(new char[k], x-1, y-1, k, 0);
        
        return answer;
    }
}