import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static StringTokenizer st;
	
	static int N;
	
	static int[] shuffle(int[] arr, int[] S) {
		
		int[] newArr = new int[arr.length];
		
		for(int i = 0 ; i < arr.length ; i ++) {
			newArr[S[i]] = arr[i];
		}
		
		return newArr;
	}
	
	static boolean check(int[] arr, List<List<Integer>> list) {
		for(int i = 0 ; i < arr.length ; i ++) {
			if(Collections.binarySearch(list.get(i % 3), arr[i]) < 0) return false;
//			if(!list.get(i % 3).contains(arr[i])) return false;
		}
		return true;
	}
	
    public static void main(String[] args) throws Exception{
    	
    	N = Integer.parseInt(br.readLine());
    	
    	int[] S = new int[N]; 
    	
    	List<List<Integer>> list = new ArrayList<>();
    	
    	for(int i = 0 ; i < 3 ; i ++) {
    		list.add(new ArrayList<>());
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0 ; i < N ; i ++) {
    		
    		int p = Integer.parseInt(st.nextToken());
    		
    		list.get(p).add(i);
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0 ; i < N ; i ++) {
    		S[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] arr = new int[N];
    	
    	for(int i = 0 ; i < N ; i ++) {
    		arr[i] = i;
    	}
    	
    	Set<String> set = new HashSet<>();
    	
    	int count = 0;
    	
    	int[] newArr = arr;
    	
    	while(true) {
    		int size = set.size();
    		
    		set.add(Arrays.toString(newArr));
    		
    		if(check(newArr, list)) break;
    		
    		if(set.size() == size) {
    			count = -1;
    			break;
    		}
    		
    		newArr = shuffle(newArr, S);
    		count++;
    	}
    	
    	bw.write(Integer.toString(count));
    	bw.flush();
    	bw.close();
    	br.close();
    }
}