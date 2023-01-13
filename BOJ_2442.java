import java.util.Scanner;

public class BOJ_2442 {
	static int N;
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		N = scnn.nextInt();
		String star = "*";
		
		//문자열 생성 : StringBuilder -> 출력이 많으면 시간이 많이 걸리므로 시간단축을 위해 문자열을 합침
		StringBuilder sb = new StringBuilder(); //mutterable string
		
		for (int i =0 ; i < N; i++) {
			int cnt = 2*(i+1)-1;
			int space_cnt = (2*N - 1 - cnt) / 2;
			for(int k =0 ; k < space_cnt ; k++) {
				sb.append(" ");
			}
			for (int j = 0; j < cnt; j++) {
				sb.append(star);
			}
			sb.append('\n');
		}
		System.out.print(sb.toString()); //immuterable
	}
}

/*
public class BOJ_2442 {
	static int N;
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		N = scnn.nextInt();
		String star = "*";
		for (int i =0 ; i < N; i++) {
			int cnt = 2*(i+1)-1;
			int space_cnt = (2*N - 1 - cnt) / 2;
			for(int k =0 ; k < space_cnt ; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < cnt; j++) {
				System.out.print(star);
			}
			for(int k =0 ; k < space_cnt ; k++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
*/