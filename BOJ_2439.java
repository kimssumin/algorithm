import java.util.Scanner;

public class BOJ_2439 {
	static int N;
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		N = scnn.nextInt();
		String star = "*";
		for (int i = 1; i < N+1 ; i++) {
			for(int k =0 ; k < N - i ; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print(star);
			}
			System.out.println();
		}
	}
}
