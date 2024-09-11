import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n,m;
	
	static int[][] map;
	static boolean[][] visit;
	
	static int[][] coor = {{1,0}, {0,1}, {-1,0}, {0,-1}}; 
			
	static int bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(new Node(x, y));
		
		int count = 1;
		visit[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			x = node.x;
			y = node.y;
			
			for(int i = 0 ; i < 4 ; i ++) {
				int newX = x + coor[i][0];
				int newY = y + coor[i][1];
				
				if(newX >= 0 && newY >= 0 && newX < m && newY < n) {
					if(map[newY][newX] == 1 && !visit[newY][newX]) {
						visit[newY][newX] = true;
						count++;
						queue.offer(new Node(newX, newY));
					}
				}
			}
		}
		
		return count;
	}
	
	static class Node {
		int x,y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n][m];
		map = new int[n][m];
		
		int answer = 0;
		
		int count = 0;
		
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < m ; j ++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					answer = Math.max(bfs(j, i), answer);
					count++;
				}
			}
		}
		
		System.out.println(Integer.toString(count)+"\n"+Integer.toString(answer));
    	br.close();
    }
}