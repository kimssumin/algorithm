import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10971 {
    static int N;
    static boolean[] visited;
    static int[][] W;
    static long ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];


        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            for (int j = 0 ; j < N; j++){
                W[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        for (int i = 0; i < N; i++){
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, i , 0);
        }
        System.out.println(ans);

        br.close();
    }

	private static void dfs(int start, int now, long pay) {
		// TODO Auto-generated method stub
		if (visitCheck()) {
			if (W[now][start] != 0) {
				ans = Math.min(ans, pay + W[now][0]);
			}
			return;
		}
		
		for (int i = 1; i < N; i++) {
			if (!visited[i] && W[now][i] != 0) {
				visited[i] = true;
				dfs(start, i, pay+W[now][i]);
				visited[i] = false;
			}
		}
		
	}

	private static boolean visitCheck() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                return false;
            }
        }
		return true;
	}

    

}
