import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static StringTokenizer st;
	
	static int N,M,start,end;
	
	static Map<Integer, List<Node>> adjacent;
	
	static int max;
	
	static Stack<Integer> stack = new Stack<>();
	
	static Map<Node, Boolean> visit = new HashMap<>();
	
	static boolean dfs(int weight) {
		
		stack.clear();
		visit.clear();
		
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int from = stack.pop();
			
			if(from == end) {
				max = Math.max(max, weight);
				return true;
			}
			
			for(int i = 0 ; i < adjacent.get(from).size(); i ++) {
				Node node = adjacent.get(from).get(i);
				
				int to = from == node.from ? node.to : node.from;
				int capacity = node.capacity; 
				
				if(capacity < weight) break;
				
				if(!visit.containsKey(node) && capacity >= weight) {
					stack.push(to);
					visit.put(node, true);
				}
			}
		}
		
		return false;
	}
	
	static int biarySearch(int maxCapa) {
		int left = 0;
		
		int right = maxCapa + 1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(dfs(mid)) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		
		return left - 1;
	}
	
	
	static class Node {
		int from;
		int to;
		int capacity;
		
		Node(int from, int to, int capacity) {
			this.from = from;
			this.to = to;
			this.capacity = capacity;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(from, to, capacity);
		}
		
		@Override
		public boolean equals(Object obj) {
			Node n = (Node) obj;
			
			return from == n.from && to == n.to && capacity == n.capacity;  
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		adjacent = new HashMap<>();
		
		int maxCapa = 0;
		
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			
			int to = Integer.parseInt(st.nextToken());
			
			int capacity = Integer.parseInt(st.nextToken());
			
			if(!adjacent.containsKey(from)) {
				adjacent.put(from, new ArrayList<>());
			}
			
			if(!adjacent.containsKey(to)) {
				adjacent.put(to, new ArrayList<>());				
			}
			
			Node node = new Node(from, to, capacity);
			
			adjacent.get(from).add(node);
			adjacent.get(to).add(node);
			
			maxCapa = Math.max(maxCapa, capacity);
		}
		
		for(List<Node> list : adjacent.values()) {
			Collections.sort(list, (o1, o2)->{
				return o2.capacity - o1.capacity;
			});
		}
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		biarySearch(maxCapa);
		
		System.out.println(Integer.toString(max));
		br.close();
			
	}
}