package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_2115 {

	static int ans;
	static int N, M, C;
	static int [][] map;
	static int[] nums;
	static int sumA, sumB;
	
	static final StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] nmc = br.readLine().split(" ");
			ans = Integer.MIN_VALUE;
			N = Integer.parseInt(nmc[0]);
			M = Integer.parseInt(nmc[1]);
			C = Integer.parseInt(nmc[2]);
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			nums = new int[2];
			
			comb(0, 0);
			
			
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.print(sb);
		br.close(); 

	}
	private static void comb(int cnt, int start) {
		// TODO Auto-generated method stub
		if (cnt == 2) {
			if (!check(nums)) {
				return;
			}
			ans = Math.max(ans,  getHoney(nums[0], nums[1]));
			return;
		}
		
		for(int i = start; i < N*N; i++) {
			nums[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	private static int getHoney(int a, int b) {
		
		// TODO Auto-generated method stub
		sumA = 0;
		for(int i = 1; i <= M; i++) {
			calcA(a, a+M, i, 0, 0, 0);
		}
		
		sumB = 0;
		for(int i = 1; i <= M; i++) {
			calcB(b, b+M, i, 0, 0, 0);
		}
		
		return sumA + sumB;
	}
	
	private static void calcA(int start, int n, int R, int cnt, int sum, int tot) {
		if (cnt == R) {
			if (sum <= C) {
				//System.out.println(tot);
				sumA = Math.max(sumA, tot);
			}
			return;
		}
		for(int i = start; i < n; i++) {
			int val = map[i/N][i%N];
			calcA(i+1, n, R, cnt+1, sum + val, tot + (val*val));
		}
	}
	
	private static void calcB(int start, int n, int R, int cnt, int sum, int tot) {
		if (cnt == R) {
			if (sum <= C) {
				sumB = Math.max(sumB, tot);
			}
			return;
		}
		for(int i = start; i < n; i++) {
			int val = map[i/N][i%N];
			calcB(i+1, n, R, cnt+1, sum + val, tot + (val*val));
		}
	}
	
	
	private static boolean check(int[] n) {
		if (n[0] < n[1] && n[1] < n[0] + M) {
			return false;
		}
		if (n[0]/ N != (n[0] + (M-1))/N) {
			return false;
		}
		if (n[1]/ N != (n[1] + (M-1))/N) {
			return false;
		}
		return true;
	}

}
