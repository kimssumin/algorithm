package HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOJ_15961 {
	static int N, D, K, C;
	static int[] belt;
	static int ans;
	static int[] eated;
	static int i, j;
	static int base;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStr = br.readLine().split(" ");
		N = Integer.parseInt(inputStr[0]);
		D = Integer.parseInt(inputStr[1]);
		K = Integer.parseInt(inputStr[2]);
		C = Integer.parseInt(inputStr[3]);
		
		belt = new int[N];
		eated = new int[D+1];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		
		for(int i = 0; i < K; i++) {
			if (eated[belt[i]] == 0) {
				base ++;
			}
			eated[belt[i]] ++;
			
		}
		if (eated[C] == 0) {
			base ++;
		} //초기상태
		eated[C] ++;
		
		chooseSushi();
		System.out.println(ans);
		br.close(); 
	}
	
	private static void chooseSushi() {
		for(int i = 0; i < N; i++) {
			eated[belt[i]] -= 1;
			
			if (eated[belt[i]] == 0) {
				base --;
			}
			eated[belt[(i+K)%N]] ++;
			if (eated[belt[(i+K)%N]] == 1) {
				base ++;
			}
			ans = Math.max(ans,  base);
			
		}
	}
	
}
