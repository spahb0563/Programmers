import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int toIdx(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		
		int month = Integer.parseInt(date.substring(5, date.length()));
		
		int idx = ((year - 2000) * 12) + (month - 1);
		
		return idx;
	}
	
	static String toDate(int idx) {
		int year = 2000 + (idx / 12);
		
		int month = (idx % 12) + 1;
		
		return String.format("%4d-%02d", year, month);
	}
	
    public static void main(String[] args) throws Exception{
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] arr = new int[((9999 - 1999) * 12) + 1];
    	
    	for(int i = 0 ; i < N ; i ++) {
    		String line = br.readLine();
    		
    		String from = line.substring(0, 7);
    		
    		String to = line.substring(8, line.length());
    		
    		int fromIdx = toIdx(from); 
    		int toIdx = toIdx(to); 
    		arr[fromIdx]++;
    		arr[toIdx + 1]--;
    	}
    	
    	int max = arr[0];
    	int maxIdx = 0;
    	for(int i = 1 ; i < arr.length - 1; i ++) {
    		arr[i] = arr[i] + arr[i-1];
    		
    		if(max < arr[i]) {
    			max = arr[i];
    			maxIdx = i;
    		}
    		
    	}
    	
    	System.out.println(toDate(maxIdx));
    	br.close();
    }
}