package javaAlgo;

import java.io.*;

public class BOJ_17406 {

	static int N;
	static int M;
	static int K;
	static int[][] map;
	static int[][] originMap;
	static String[][] operations;
	static int ans = Integer.MAX_VALUE;

	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		K = Integer.parseInt(info[2]);
		map = new int[N][M];
		originMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] input1 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input1[j]);
				originMap[i][j] = map[i][j];
			}
		}

		operations = new String[K][3];
		
		for (int i = 0; i < K; i++) {
			String[] input2 = br.readLine().split(" ");
			operations[i] = new String[3];
			operations[i][0] = input2[0];
			operations[i][1] = input2[1];
			operations[i][2] = input2[2];
		}

		// permutation
		perm(0, new int[K], new boolean[K]); 
		System.out.println(ans);
		br.close();
	}

	private static void perm(int cnt, int[] nums, boolean[] visited) {
		if (cnt == K) {
			for (int i = 0; i < cnt; i++) {
				rotation(Integer.parseInt(operations[nums[i]][0]) - 1,
						Integer.parseInt(operations[nums[i]][1]) - 1, Integer.parseInt(operations[nums[i]][2]));
			}
			calcMin();
			copyMap();
			return;
		}

		for (int i = 0; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				nums[cnt] = i;
				perm(cnt + 1, nums, visited);
				visited[i] = false;
			}
		}

	}


	private static void calcMin() {
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
			}
			ans = Math.min(ans, sum);
		}
	}

	private static void rotation(int r, int c, int num) {

		for (int i = 0; i < num; i++) {
			int tmp = map[r - num + i][c - num + i];

			int y = r - num + i;
			int x = c - num + i;
			int d = 0;
			while (d < 4) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny >= r - num + i && nx >= c - num + i && ny <= r + num - i && nx <= c + num - i) {
					map[y][x] = map[ny][nx];
					y = ny;
					x = nx;
				} else {
					d++;
				}
			}
			map[r - num + i][c - num + i + 1] = tmp;
		}

	}
	
	private static void copyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = originMap[i][j];
			}
		}
	}

}
