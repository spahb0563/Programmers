import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int min;
	
	static int number;
	
	static void combi(int out, int depth, boolean[] isBroken, int r) {
		if(depth == r) {
			int count = (out == 0) ? 1 : (int) Math.log10(out) + 1;
			
		    min = Math.min(min, Math.abs(number - out) + count);
		    
			return;
		}
		
		for(int i = 0 ; i < 10 ; i ++) {
			if(isBroken[i]) continue;
			if(depth == 0 && i == 0) continue;
			
			combi(out * 10 + i, depth + 1, isBroken, r);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		String N = br.readLine();
		
		int M = Integer.parseInt(br.readLine());
		
		boolean[] isBroken = new boolean[10];
		
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			for(int i = 0 ; i < M ; i ++) {
				isBroken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		number = Integer.parseInt(N);
		min = Math.abs(number - 100);
		
		if(!isBroken[0]) min = Math.min(min, number + 1);
		
		for(int i = 1 ; i <= 6 ; i ++) {
			combi(0, 0, isBroken, i);
		}
		
		System.out.println(min);
	}
}