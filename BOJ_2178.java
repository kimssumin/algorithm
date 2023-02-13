import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178 {
	
	static int N, M;
	static int [][] map;
	static int [][] distance;
	static int min;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1}; //상우하좌
	
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		distance = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] inputStr = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(inputStr[j]);
			}
		}
		
		bfs();
		br.close(); 
	}

	private static void bfs() {
		Queue<Point> points = new LinkedList<>();
		points.offer(new Point(0,0));
		distance[0][0] = 1;
		while(!points.isEmpty()) {
			Point cur = points.poll();
			int r = cur.r;
			int c = cur.c;
			if (r == N-1 && c == M-1) {
				min = distance[N-1][M-1];
				System.out.println(min);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = r + dx[i];
				int ny = c + dy[i];
				if (!check(nx, ny)) {
					continue;
				}
				if (map[nx][ny] == 1 && distance[nx][ny] == 0) {
					points.offer(new Point(nx, ny));
					distance[nx][ny] = distance[r][c] + 1;
				}
			}
		}
		 
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
