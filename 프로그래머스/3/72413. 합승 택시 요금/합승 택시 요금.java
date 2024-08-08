class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        int[][] map = new int[n+1][n+1];
        
        for(int i = 0 ; i < n + 1 ; i ++) {
            for(int j = 0 ; j < n + 1 ; j ++) {
                if(i != j) map[i][j] = 20000001;
            }
        }
        
        for(int i = 0 ; i < fares.length ; i ++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int distance = fares[i][2];
            
            map[from][to] = distance;
            map[to][from] = distance;
            
        }
        
		for (int k = 1; k < n+1; k++) {
			for (int i = 1; i < n+1; i++) {
				for (int j = 1; j < n+1; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
        
        for(int i = 1 ; i < n + 1 ; i ++) {
            answer = Math.min(map[s][i] + map[i][b] + map[i][a], answer);                        
        }
        
        return answer;
    }
}