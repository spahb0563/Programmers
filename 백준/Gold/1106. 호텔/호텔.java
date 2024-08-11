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
	
	static int C, N;
	
    public static void main(String[] args) throws Exception{
    	
    	st = new StringTokenizer(br.readLine());
    	
    	C = Integer.parseInt(st.nextToken());
    	
    	N = Integer.parseInt(st.nextToken());
    	
    	int[] dp = new int[1101];
    	
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	
    	for(int i = 0 ; i < N  ; i ++ ) {
    		st = new StringTokenizer(br.readLine());
    		
    		int cost = Integer.parseInt(st.nextToken());
    		
    		int customer = Integer.parseInt(st.nextToken());
    		
    		dp[customer] = Math.min(dp[customer], cost);
    	}
    	
    	for(int i = 1; i < dp.length ; i ++) {
    		for(int j = 0 ; j < i ; j ++) {
    			if(dp[j] != Integer.MAX_VALUE && dp[i - j] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);
    			}
    		}
    	}
    	
    	int[] temp = new int[dp.length - C];
    	
    	System.arraycopy(dp, C, temp, 0, temp.length);
    	
    	Arrays.sort(temp);
    	
    	int answer = 0;
    	
    	for(int i = 0 ; i < temp.length; i ++) {
    		if(temp[i] != 0) {
    			answer = temp[i];
    			break;
    		}
    	}
    	
    	bw.write(Integer.toString(answer));
    	bw.flush();
    	bw.close();
    	br.close();
    }
}