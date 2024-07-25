import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static StringTokenizer st;
	
	static int N,M;

	static void union(int[] arr, int a, int b) {
		
		a = find(arr, a);
		
		b = find(arr, b);
		
		arr[Math.max(a, b)] = Math.min(a, b);
	}
	
	
	static int find(int[] arr, int a) {
		if(arr[a] == a) {
			return a;
		}else {
			return find(arr, arr[a]);
		}
	}
	
	
    public static void main(String[] args) throws Exception{
    	N = Integer.parseInt(br.readLine());
    	
    	M = Integer.parseInt(br.readLine());
    	
    	int[] arr = new int[N + 1];
    	
    	for(int i = 1 ; i < N + 1 ; i ++) {
    		arr[i] = i;
    	}
    	
    	int[][] input = new int[M][3];
    	
    	for(int i = 0 ; i < M ; i ++) {
    		
    		st = new StringTokenizer(br.readLine());
    		
    		input[i][0] = Integer.parseInt(st.nextToken()); 
    		input[i][1] = Integer.parseInt(st.nextToken());
    		input[i][2] = Integer.parseInt(st.nextToken());
    		
    	}
    	
    	Arrays.sort(input, (o1, o2)->{
    		return o1[2] - o2[2]; 
    	});
    	
    	int totalCost = 0;
    	
    	for(int i = 0 ; i < M ; i ++) {
    		
    		int from = input[i][0];
    		int to = input[i][1];
    		int cost = input[i][2];
    		
    		if(find(arr, arr[from]) != find(arr, arr[to])) {
    			union(arr, from, to);
    			totalCost += cost;
    		}
    	}
    	
    	bw.write(Integer.toString(totalCost));
    	bw.flush();
    	bw.close();
    	br.close();
    }
}