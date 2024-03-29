import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class SWE_cook2 {
	
	static int N;
	static int[][] taste;
	static boolean[] visit;
	
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			 
			taste = new int[N][N];
			visit = new boolean[N];
	 
			ans = 20000;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	 
				for (int j = 0; j < N; j++) {
					taste[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combi(0, 0);
			System.out.println("#"+t+" "+ans);
		}
 
	}
 
	// count :조합 개수(=재귀 깊이)
	static void combi(int idx, int count) {
		if(count == N / 2) {
		 //음식 맛 차이 계산
			diff();
			return;
		}
 
		for(int i = idx; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				combi(i + 1, count + 1);
				visit[i] = false;
			}
		}
	}
 
	// 두 음식 맛의 차
	static void diff() {
		int food_a = 0;
		int food_b = 0;
 
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// a 음식 맛 계산
				if (visit[i] == true && visit[j] == true) {
					food_a += taste[i][j];
					food_a += taste[j][i];
				}
				// b 음식 맛 계산
				else if (visit[i] == false && visit[j] == false) {
					food_b += taste[i][j];
					food_b += taste[j][i];
				}
			}
		}
		// 두 시너지 차이 (절댓값)
		int now_diff = Math.abs(food_a - food_b);
		ans = Math.min(ans, now_diff);
				
	}
 
}
