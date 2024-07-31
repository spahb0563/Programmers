import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static StringTokenizer st;
	
	static int N, M;
	
	static Queue<List<Integer>> parties;
	
	static Set<Integer> knows;
	
	static void check() {
		
		int size = parties.size();
		
		loop:
		for(int i = 0 ; i < size ; i ++) {
			
			List<Integer> party = parties.poll();
			
			for(int know : knows) {
				if(Collections.binarySearch(party, know) >= 0) {
					knows.addAll(party);
					continue loop;
				}
			}
			
			parties.offer(party);
		}
	}
	
    public static void main(String[] args) throws Exception{
    	
    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	
    	M = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int count = Integer.parseInt(st.nextToken());
    	
    	knows = new HashSet<>();
    	
    	for(int i = 0 ; i < count; i ++) {
    		knows.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	parties = new LinkedList<>();
    	
    	for(int i = 0 ; i < M ; i ++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int size = Integer.parseInt(st.nextToken());
    		
    		List<Integer> party = new ArrayList<>();
    		
    		for(int j = 0 ; j < size ; j ++) {
    			int person = Integer.parseInt(st.nextToken());
    			
    			party.add(person);
    		}
    		
    		Collections.sort(party);
    		
    		parties.offer(party);
    	}
    	
    	int knowsSize = 0;
    	
    	do {
    		knowsSize = knows.size();
    		check();
    	}while(knowsSize != knows.size());
    	
    	bw.write(Integer.toString(parties.size()));
    	bw.flush();
    	bw.close();
    	br.close();
    }
}