import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static List<Integer> list = new ArrayList<>();
	
	static void combi(int out, int depth, boolean[] isBroken, int r) {
		if(depth == r) {
			list.add(out);
			
			return;
		}
		
		for(int i = 0 ; i < 10 ; i ++) {
			if(isBroken[i]) continue;
			if(depth == 0 && i == 0) continue;
			
			combi(out * 10 + i, depth + 1, isBroken, r);
		}
	}
	
    public static int findLowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        int result = -1; // 찾지 못하면 -1 반환

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) <= target) {
                result = mid; // 현재 값 저장 (조건 충족)
                low = mid + 1; // 오른쪽 탐색
            } else {
                high = mid - 1; // 왼쪽 탐색
            }
        }

        return result;
    }

    public static int findUpperBound(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        int result = -1; // 찾지 못하면 -1 반환

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) > target) {
                result = mid; // 현재 값 저장 (조건 충족)
                high = mid - 1; // 왼쪽 탐색
            } else {
                low = mid + 1; // 오른쪽 탐색
            }
        }

        return result;
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
		
		int number = Integer.parseInt(N);
		
		int min = Math.abs(number - 100);
		
		if(!isBroken[0]) list.add(0);

		for(int i = 1 ; i <= 6 ; i ++) {
			combi(0, 0, isBroken, i);
		}
		
		int lowerIdx = findLowerBound(list, number);
		if(lowerIdx != -1) {
			int lower = list.get(lowerIdx);
			min = Math.min(min, Integer.toString(lower).length() + Math.abs(lower - number));
		}
		
		int upperIdx = findUpperBound(list, number);
		if(upperIdx != -1) {
			int upper = list.get(upperIdx);
			min = Math.min(min, Integer.toString(upper).length() + Math.abs(upper - number));
		}
		
		System.out.println(min);
	}
}