//알고리즘 문제는 package 필요없음
import java.util.Scanner;

public class BOJ_2448 {
	//백준에 제출할땐 class명 Main으로 하여서
	static int N;
	static int [][] star;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		star = new int[N][2*N-1];
		
		//logic
		star(0,N-1,N);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2*N-1; j++) {
					sb. append(star[i][j]== 1 ? "*":" ");
				}
				sb.append ("\n");
		}
		System.out.println(sb.toString());	
	}
	
	static void star(int r, int c, int n) {
		if (n ==3) {
				star[r][c] = 1;
	            star[r + 1][c - 1] = star[r + 1][c + 1] = 1;
	            star[r+ 2][c - 2] = star[r + 2][c - 1] = star[r + 2][c] = star[r + 2][c + 1] = star[r + 2][c + 2] = 1;
	            return;
			}
		else {
			star(r, c, n/2);
			star(r+n/2, c-n/2, n/2);
			star(r+n/2, c+n/2, n/2);
		}
		
	}	
}
	
