import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_swimmingpool {
	static int D;
	static int M;
	static int T;
	static int Y;
	static int[] use ;
	static int [] month = new int[12];
	static boolean[] visit;
	static int cost;
	static int max_month;
	static int ans; 
	static int start;
	static int all;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			String[] inputStr = br.readLine().split(" ");
			D = Integer.parseInt(inputStr[0]);
			M = Integer.parseInt(inputStr[1]);
			T = Integer.parseInt(inputStr[2]);
			Y = Integer.parseInt(inputStr[3]);
			String[] inputStr2 = br.readLine().split(" ");
			
			ans = Integer.MAX_VALUE/1000;
			use = new int[12];
			
			for (int j = 0; j < inputStr2.length; j++) {
				use[j] = Integer.parseInt(inputStr2[j]);
				all += use[j];
				
			}
			for (int j = 0; j < use.length; j++) {
				if (use[j] != 0) {
					start = j;
					break;
				}
			}
			
			cost = all * D;
			dfs(0, 0);
			ans = cost;
			
			ans = Math.min(ans, Y);
			System.out.println("#"+t + " "+ ans);
		}

		br.close(); 
	}

	private static void dfs(int m, int sum) {
	 	System.out.println(m + " " + sum);
		if (sum > cost) {
			return;
		}
		if (m >= 12) {
			if (sum <= cost) cost = sum;
			return;
		}
		if (m < 12) {
			dfs(m + 1, sum + (use[m]*D));
			dfs(m + 1, sum + M);
			dfs(m + 3, sum + T);
		}
	
	}

}
