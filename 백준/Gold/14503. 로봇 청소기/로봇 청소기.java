import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static StringTokenizer st;
	
	static final int NORTH = 0;
	static final int EAST = 1;
	static final int SOUTH = 2;
	static final int WEST = 3;
	
	static final int FORWARD = 1;
	static final int BACK = -1;
	
	static int N, M;
	
	static class Robot {
		
		int r, c;
		int direction;
		
		Robot(int r, int c, int direction) {
			this.r = r;
			this.c = c;
			this.direction = direction;
		}
		
		void changeDirection() {
			switch (direction) {
			case NORTH:
				direction = WEST;
				break;
			case EAST:
				direction = NORTH;
				break;
			case SOUTH:
				direction = EAST;
				break;
			case WEST:
				direction = SOUTH;
				break;
			default:
				throw new IllegalStateException();
			}
		}
		
		void move(int direction) {
			switch (this.direction) {
			case NORTH:
				this.r = this.r - direction;
				break;
			case EAST:
				this.c = this.c + direction;
				break;
			case SOUTH:
				this.r = this.r + direction;
				break;
			case WEST:
				this.c = this.c - direction;
				break;
			default:
				throw new IllegalStateException();
			}
		}
		
		boolean findDirtyArea(int[][] map) {
			for(int i = 0 ; i < 4 ; i ++ ) {
				changeDirection();
				
				switch (direction) {
				case NORTH:
					if(this.r - 1 >= 0 && map[this.r - 1][c] == 0) {
						return true;
					}
					break;
				case WEST:
					if(this.c - 1 >= 0 && map[r][this.c - 1] == 0) {
						return true;
					}
					break;
				case SOUTH:
					if(this.r + 1 < N && map[this.r + 1][c] == 0) {
						return true;
					}
					break;
				case EAST:
					if(this.c + 1 < M && map[r][this.c + 1] == 0) {
						return true;
					}
					break;
				default:
					throw new IllegalStateException();
				}
			}
			
			return false;
		}
	}
	
	static int execute(int[][] map, Robot robot) {
		
		int count = 0;
		
		while(true) {
			if(robot.r < 0 || robot.c < 0 || robot.r >= N || robot.c >= M) {
				break;
			}
			
			if(map[robot.r][robot.c] == 1){
				break;
			}
			
			boolean isClean = map[robot.r][robot.c] == -1;
			
			if(!isClean) {
				cleanUp(map, robot.r, robot.c);
				count++;
			}
			
			if(robot.findDirtyArea(map)) {
				robot.move(FORWARD);
			}else {
				robot.move(BACK);
			}
		}
		
		return count;
	}
	
	static void cleanUp(int[][] map, int r, int c) {
		map[r][c] = -1;
	}
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(st.nextToken());
		
		int direction = Integer.parseInt(st.nextToken());
		
		Robot robot = new Robot(r, c, direction);
		
		int[][] map = new int[N][M];
		
		for(int i = 0 ; i < N ; i ++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; j < M ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(execute(map, robot));
	}
}