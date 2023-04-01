import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[][] lines;
	static int[] nums;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		lines = new int[n][n];
		nums = new int[n];
		dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for (int i = 0; i < n; i++) {
			String[] inputStr = br.readLine().split(" ");
			lines[i][0] = Integer.parseInt(inputStr[0]);
			lines[i][1] = Integer.parseInt(inputStr[1]);
		}
		
		Arrays.sort(lines, (o1, o2) -> {
			return o1[0] - o2[0];
		});
		
		for(int i = 0; i < n; i++) {
			nums[i] = lines[i][1];
		}
		
		for(int i = 0; i < n; i++) {
			if (Arrays.binarySearch(dp, nums[i]) < 0) {
				int idx =  - (Arrays.binarySearch(dp, nums[i]) + 1);
				dp[idx] = nums[i];
			}
		}
		
		int cnt = 0;
		for(int d : dp) {
			if (d != Integer.MAX_VALUE) {
				cnt ++;
			}
		}
		
		System.out.println(n - cnt);

		br.close(); 
	}

}
