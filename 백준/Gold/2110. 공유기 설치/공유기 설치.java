import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N,C;
	
	static int max;
	
	static int binarySearch(int[] arr)throws Exception{
		int left = 1;
		
		int right = arr[arr.length - 1] - arr[0] + 1;
		
		while(left < right) {
			int middle = (left + right) / 2;
			
			int count = 1;
			
			int obj = 0;
			
			for(int i = 1 ; i < arr.length; i ++) {
				if(arr[i] - arr[obj] >= middle) {
					obj = i;
					count++;
				}
			}
			
			if(count < C) {
				right = middle;
			}else{
				left = middle + 1;
			}
		}
		
		return left - 1;
	}
	
    public static void main(String[] args) throws Exception{
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	
    	C = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[N];
    	
    	for(int i = 0 ; i < N ; i ++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	
    	Arrays.sort(arr);

    	System.out.println(binarySearch(arr));
    	
    	br.close();
    }
}