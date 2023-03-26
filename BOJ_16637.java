package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16637 {
	
	static int N;
	static int ans = Integer.MIN_VALUE;
	static char[] sig;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sig = br.readLine().toCharArray();
		
		backtracking(2, sig[0]- '0');
		System.out.println(ans);
		br.close(); 
	}

	private static void backtracking(int cnt, int now) {
		if (cnt >= N) {
			ans = Math.max(ans, now);
			return;
		}
		
		backtracking(cnt+2, cal(now, sig[cnt]- '0', sig[cnt-1]));
		
		if (cnt + 2 < N) {
			int right = cal(sig[cnt]- '0', sig[cnt+2]-'0' , sig[cnt+1]);
			int left = cal(now, right, sig[cnt-1]);
			backtracking(cnt+4, left);
		}
		
		
	}

	private static int cal(int now, int i, char c) {
		switch(c) {
		case '+':
			return now + i;
		case '-':
			return now - i;
		case '*':
			return now * i;
		}
		return now;
	}

}
