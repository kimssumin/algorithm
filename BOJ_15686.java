package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_15686 {
	static int N, M, dist;
	static int[][] map;
	static int ans = Integer.MAX_VALUE;
	static int[] nums;
	static List<Integer> q = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] c = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(c[j]);
				if (map[i][j] == 2) {
					int num = i*N+j;
					q.add(num);
				}
			}
		}
		
		for(int i = 1; i <= M; i++) {
			nums = new int[i];
			comb(0, 0, i);
		}
		
		System.out.print(ans);
		br.close();

	}

	private static void comb(int cnt, int start, int R) {
		if (cnt == R) {
			dist = calcDist(nums);
			//System.out.println(dist);
			ans = Math.min(dist, ans);
			return;
		}
		for(int i = start; i < q.size(); i++) {
			nums[cnt] = q.get(i);
			comb(cnt+1, i+1, R);
		}
		
	}

	private static int calcDist(int[] num) {
		int sum = 0;
		for (int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				if (map[x][y] == 1) {
					sum += dist(nums, x, y);
				}
			}
		}
		return sum;
	}

	private static int dist(int[] nums, int x, int y) {
		int d = 2*N;
		for (int n : nums) {
			int i = n / N;
			int j = n % N;
			d = Math.min(d, (Math.abs(x-i) + Math.abs(y-j))) ;
		}
		return d;
	}
}	
