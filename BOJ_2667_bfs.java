import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Flood fill
public class BOJ_2667_bfs {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static List<Integer> ans = new ArrayList<>();
	static int cnt;
	static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		visit = new boolean[N][N];
		map = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			String[] inputStr = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputStr[j]);
			}
		}
		
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < N; j++) {
				if (canGo(i, j)) {
					cnt = 1;
					visit[i][j] = true;
					bfs(i, j);
					ans.add(cnt);
				}
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for (int i : ans) {
			System.out.println(i);
		}
		br.close(); 
	}

	private static void bfs(int x, int y) {
		int [] dx = {-1, 0, 1, 0};
		int [] dy = {0, 1, 0, -1};
		int nx, ny;
		q.offer(new Point(x, y));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			Point now;
			now = q.poll();
			for (int h = 0; h < 4; h++) {
				nx = now.x + dx[h];
				ny = now.y + dy[h];
				
				if (canGo(nx, ny)) {
					visit[nx][ny] = true;
					q.offer(new Point(nx, ny));
					cnt ++;
				}
			}
		}
	}

	private static boolean canGo(int nx, int ny) {
		if (!inRange(nx, ny) || visit[nx][ny]) {
			return false;
		}
		if (map[nx][ny] == 0) {
			return false;
		}
		return true;
	}

	private static boolean inRange(int nx, int ny) {
		return (nx >= 0 && nx < N && ny >= 0 && ny < N);
	}
}
