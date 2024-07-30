import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static StringTokenizer st;
	
	static int N,M;
	
    public static void main(String[] args) throws Exception{
    	
    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	
    	M = Integer.parseInt(st.nextToken());
    	
    	int[][] arr = new int[N][M];
    	
    	for(int i = 0 ; i < N ; i ++) {
    		String line = br.readLine();
    		for(int j = 0 ; j < M ; j ++) {
    			arr[i][j] = line.charAt(j) - '0';
    		}
    	}
    	
    	List<List<Integer>> list = new ArrayList<>();
    	
    	if(N == 1) {
    		list.add(new ArrayList<>());
    		list.get(0).add(0);
    	}
    	
    	for(int i = 0 ; i < N ; i ++) {
    		for(int j = -N + 1; j < N ; j ++) {
    			if(j == 0) continue;
    			
    			if(i + j > N || i + j < 0) continue;
    			
    			list.add(new ArrayList<>());
    			
    			for(int k = i; k < N && k >= 0; k+=j) {
    				list.get(list.size() - 1).add(k);
    			}
    		}
    	}
    	
    	List<List<Integer>> list2 = new ArrayList<>();
    	
    	if(M == 1) {
    		list2.add(new ArrayList<>());
    		list2.get(0).add(0);
    	}
    	
    	for(int i = 0 ; i < M ; i ++) {
    		for(int j = -M + 1; j < M ; j ++) {
    			if(j == 0) continue;
    			
    			if(i + j > M || i + j < 0) continue;
    			
    			list2.add(new ArrayList<>());
    			
    			for(int k = i; k < M && k >= 0; k+=j) {
    				list2.get(list2.size() - 1).add(k);
    			}
    		}
    	}
    	
    	int max = -1;
    	
    	for(int i = 0 ; i < list.size(); i ++) {
    		List<Integer> a = list.get(i);
    		for(int j = 0 ; j < list2.size(); j ++) {
    			List<Integer> b = list2.get(j);
    			StringBuffer sb = new StringBuffer();
    			for(int k = 0 ; k < Math.min(a.size(), b.size()); k ++) {
    				sb.append(arr[a.get(k)][b.get(k)]);
    				int number = Integer.parseInt(sb.toString());
    				if(Math.sqrt((double)number) % 1 == 0) {
    					max = Math.max(max, number);
    				}
    			}
    			
    		}
    	}
    	
    	for(int i = 0 ; i < N ; i ++) {
    		for(int j = 0 ; j < list2.size(); j ++) {
    			List<Integer> b = list2.get(j);
    			
    			StringBuffer sb = new StringBuffer();
    			for(int k = 0 ; k < b.size(); k ++) {
    				sb.append(arr[i][b.get(k)]);
    				int number = Integer.parseInt(sb.toString());
    				
    				if(Math.sqrt((double)number) % 1 == 0) {
    					max = Math.max(max, number);
    				}
    			}
    			
    		}
    	}
    	
    	for(int i = 0 ; i < M ; i ++) {
    		for(int j = 0 ; j < list.size(); j ++) {
    			List<Integer> a = list.get(j);
    			
    			StringBuffer sb = new StringBuffer();
    			for(int k = 0 ; k < a.size(); k ++) {
    				sb.append(arr[a.get(k)][i]);
    				int number = Integer.parseInt(sb.toString());
    				
    				if(Math.sqrt((double)number) % 1 == 0) {
    					max = Math.max(max, number);
    				}
    			}
    			
    		}
    	}
    	
    	bw.write(Integer.toString(max));
    	bw.flush();
    	bw.close();
    	br.close();
    }
}