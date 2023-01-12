//알고리즘 문제는 package 필요없음
import java.util.Scanner;

public class BOJ_2438 {
	//백준에 제출할땐 class명 Main으로 하여서
	static int N;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		String star = "*";
		for (int i = 1; i < N+1 ; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(star);
			}
			System.out.println();
		}
		
	}	
}
	
