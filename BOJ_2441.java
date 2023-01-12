import java.util.Scanner;

public class BOJ_2441 {
	static int N;
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		N = scnn.nextInt();
		String star = "*";
		
		//문자열 생성 : StringBuilder -> 출력이 많으면 시간이 많이 걸리므로 시간단축을 위해 문자열을 합침
		StringBuilder sb = new StringBuilder(); //mutterable string
		
		for (int i = N+1; i >1; i--) {
			for(int k =0 ; k < N - i+1 ; k++) {
				sb.append(" ");
			}
			for (int j = 1; j < i; j++) {
				sb.append(star);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString()); //immuterable
	}
}

/*
for(int i = 0; i < N; i++){
	for(int k = 0; k <N-i; k++){
		System.out.print('*')
	}
}
*/
