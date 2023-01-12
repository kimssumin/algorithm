import java.util.Scanner;

public class BOJ_2440 {
	static int N;
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		N = scnn.nextInt();
		String star = "*";
		for (int i = N+1; i >1; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(star);
			}
			System.out.println();
		}
	}
}

/*
for(int i = 0; i < N; i++){
	for(int k = 0; k <N-i; k++){
		System.out.print('*')
	}
}
*/
