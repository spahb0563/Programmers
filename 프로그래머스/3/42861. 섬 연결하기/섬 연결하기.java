import java.util.*;

class Solution {    

    private static void union(int[] arr, int a, int b) {
		a = find(arr, a);
		b = find(arr, b);
        
        arr[Math.max(a, b)] = Math.min(a,b);
	}

	private static int find(int[] arr, int x) {
		if (arr[x] == x)
			return x;
		else
			return find(arr, arr[x]);
	}
    
    public int solution(int n, int[][] costs) {        
        int answer = 0;
        
        Arrays.sort(costs, (o1, o2)->{
            return o1[2] - o2[2];
        });
        
        int[] arr = new int[n];
        
        for(int i = 0 ; i < n ; i ++) {
            arr[i] = i;
        }
        
        for(int i = 0 ; i < costs.length; i ++) {
            
            int from = costs[i][0];
            int to = costs[i][1];
            int length = costs[i][2];
            
            if(find(arr, from) != find(arr, to)) {
                union(arr, to, from);
                answer += length;
            }
        }

        return answer;
    }
}