import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static StringTokenizer st;
	
	static int N,M,start,end;
	
	static List<Edge> edgeList;
	
	static int max;
	
	static Stack<Integer> stack = new Stack<>();
	
	static int find(int[] arr, int a) {
		if(a == arr[a]) return a;
		
		return arr[a] = find(arr, arr[a]);
	}
	
	static void union(int[] arr, int a, int b) {
		a = find(arr, a);
		b = find(arr, b);
		
		if(a == b) return;
		
		if(a > b) {
			arr[a] = b;
		}else{
			arr[b] = a;
		}
	}
	
	static int biarySearch(int maxCapa) {
		int left = 0;
		
		int right = maxCapa + 1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			int[] arr = new int[N + 1];
			
			for(int i = 0 ; i < arr.length ; i ++) {
				arr[i] = i;
			}
			
			for(Edge edge : edgeList) {
				if(edge.weight >= mid) {
					union(arr, edge.from, edge.to);
				}
			}
			
			if(find(arr, start) == find(arr, end)) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		
		return left - 1;
	}
	
	
	static class Edge {
		int from;
		int to;
		int weight;
		
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		edgeList = new ArrayList<>();
		
		int maxCapa = 0;
		
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			
			int to = Integer.parseInt(st.nextToken());
			
			int capacity = Integer.parseInt(st.nextToken());
			
			Edge edge = new Edge(from, to, capacity);
			
			edgeList.add(edge);
			
			maxCapa = Math.max(maxCapa, capacity);
		}
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		System.out.println(Integer.toString(biarySearch(maxCapa)));
		br.close();
			
	}
}