import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Flood fill
public class BOJ_2667 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static List<Integer> ans = new ArrayList<>();
	static int cnt;
	
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
					dfs(i, j);
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

	private static void dfs(int x, int y) {
		int [] dx = {-1, 0, 1, 0};
		int [] dy = {0, 1, 0, -1};
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (canGo(nx, ny)) {
				visit[nx][ny] = true;
				cnt ++;
				dfs(nx, ny);
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
