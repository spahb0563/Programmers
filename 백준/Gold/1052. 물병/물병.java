import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static StringTokenizer st;
	
	static int N, K;
	
	static int counting(String str) {
		int cnt = 0;
		
		for(int i = 0 ; i < str.length(); i ++) {
			if(str.charAt(i) == '1') cnt++;
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(st.nextToken());

		int need = 0;
		
		while(counting(Integer.toBinaryString(N + need)) > K) {
			need++;
		}
		
		bw.write(Integer.toString(need));
		bw.flush();
		bw.close();
		br.close();
	}
}