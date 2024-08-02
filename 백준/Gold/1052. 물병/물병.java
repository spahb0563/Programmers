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
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(st.nextToken());

		int need = 0;
	
		while(Integer.bitCount(N + need) > K) {
			need++;
		}
		
		bw.write(Integer.toString(need));
		bw.flush();
		bw.close();
		br.close();
	}
}