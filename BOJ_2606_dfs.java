import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2606_dfs {
	static int N;
	static int M;
	static int[][] map;
	static boolean[] visit;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int [N+1][N+1];
		visit = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			String[] inputStr = br.readLine().split(" ");
			int s = Integer.parseInt(inputStr[0]);
			int e = Integer.parseInt(inputStr[1]);
			map[s][e] = 1;
			map[e][s] = 1;
		}
		visit[1] = true;
		dfs(1);
		System.out.println(cnt);
		
		br.close(); 
	}

	private static void dfs(int start) {
		for (int i = 0; i < map[start].length; i++) {
			if (map[start][i] == 1) {
				if (!visit[i]) {
					visit[i] = true;
					cnt ++;
					dfs(i);
				}
			}
			
		}
		
	}
}
