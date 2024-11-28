import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
		String N = br.readLine();
		
		int M = Integer.parseInt(br.readLine());
		
		String[] arr = new String[M];
		
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			for(int i = 0 ; i < M ; i ++) {
				arr[i] = st.nextToken();
			}
		}
		
		int number = Integer.parseInt(N);
		
		int min = Math.abs(number - 100);
		
		loop:
		for(int i = 0 ; i <= 1000000 ; i ++) {
			
			String channel = Integer.toString(i);
			
			for(int j = 0 ; j < arr.length; j ++) {
				if(channel.contains(arr[j])) continue loop;
			}
			
			min = Math.min(min, channel.length() + Math.abs(Integer.parseInt(channel) - number)); 
		}
		
		System.out.println(min);
	}
}