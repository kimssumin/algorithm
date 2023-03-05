package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2583 {

	static int M, N, K;
	static int [][] map;
	static boolean [][] visited;
	static List<int[]> box = new ArrayList<>();
	static int cnt;
	static int areaI;
	static List<Integer> area = new ArrayList<>();
	static int [] dx = { -1 ,1 ,0, 0};
	static int [] dy = { 0, 0, 1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmk = br.readLine().split(" ");
		M = Integer.parseInt(nmk[0]);
		N = Integer.parseInt(nmk[1]);
		K = Integer.parseInt(nmk[2]);
		
		map = new int[M][N];
		visited =new boolean[M][N];
		for (int k = 0; k < K; k++) {
			String[] xy = br.readLine().split(" ");
			box.add(new int[] {Integer.parseInt(xy[0]), Integer.parseInt(xy[1]), Integer.parseInt(xy[2]), Integer.parseInt(xy[3])});
		}
		
		boxfill();
		
//		for(int i = 0; i < M ; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(int i = 0; i < M ; i++) {
			for(int j = 0; j < N; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					areaI = 1;
					visited[i][j] = true;
					dfs(i, j);
					area.add(areaI);
					cnt ++;
				}
			}
		}
		
		System.out.println(cnt);
		Collections.sort(area);
		for(int i = 0; i < area.size(); i++) {
			System.out.print(area.get(i) + " ");
		}
		
		br.close(); 

	}
	private static void dfs(int x, int y) {
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!inRange(nx,ny)) {
				continue;
			}
			if (map[nx][ny] == 0 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				areaI ++;
				dfs(nx, ny);
			}
		}
		
		
	}
	private static boolean inRange(int nx, int ny) {
		
		return nx >= 0 && nx < M && ny >= 0 && ny < N;
	}
	private static void boxfill() {
		for(int[] now : box) {
			int height = now[3] - now[1];
			int width = now[2] - now[0];
			for(int i = 0; i < height; i ++) {
				for(int j = 0; j < width; j++) {
					map[M-1-now[1]-i][now[0]+j] = 1;
				}
			}
		}
		
	}

}
