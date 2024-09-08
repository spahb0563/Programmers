import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int temp = 0;
		for(int i=0; i<N; i++) {
			temp = Integer.parseInt(st.nextToken());
			if(!map.containsKey(temp)) {
				map.put(temp, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			temp = Integer.parseInt(st.nextToken());
			if(map.containsKey(temp)) {
				bw.write(map.get(temp)+" ");
			}else {
				bw.write(0 + " ");
			}
		}
		bw.flush();
		bw.close();
	}
}