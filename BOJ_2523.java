import java.util.Scanner;

public class BOJ_2523 {
	static int N;
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		N = scnn.nextInt();
		String star = "*";
		
		// 문자열 생성 : StringBuilder -> 출력이 많으면 시간이 많이 걸리므로 시간단축을 위해 문자열을 합침
		StringBuilder sb = new StringBuilder(); // mutterable string
		for (int i =0 ; i < N; i++) {
			int cnt = 2*(i+1);
			for (int j = 0; j < cnt/2; j++) {
				sb.append(star);
			}

			sb.append('\n');
		}
		for (int i =0 ; i < N-1; i++) {
			int space_cnt =(2*(i+1));
			int cnt = (2*N - space_cnt)/2;
			for (int j = 0; j < cnt; j++) {
				sb.append(star);
			}

			sb.append('\n');
		}
		
		
		System.out.print(sb.toString()); // immuterable
		
	}
}


/*
//if-else문 이용
public class BOJ_2445 {
	static int N;
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		N = scnn.nextInt();
		String star = "*";
		
		// 문자열 생성 : StringBuilder -> 출력이 많으면 시간이 많이 걸리므로 시간단축을 위해 문자열을 합침
		StringBuilder sb = new StringBuilder(); // mutterable string
		N = 2*N-1;
	
		for (int i = 0 ; i <N; i++) { // 절댓값으로 풀수있음 -math.abs()
			if (i >= N) {
				int space_cnt =(2*(i-N+1));
				int cnt = (2*(N) - space_cnt)/2;
				for (int j = 0; j < cnt; j++) {
					sb.append(star);
				}
				for(int k =0 ; k < space_cnt ; k++) {
					sb.append(" ");
				}
				for (int j = 0; j < cnt; j++) {
					sb.append(star);
				}
				sb.append('\n');
			}	
			else {
				int cnt = 2*(i+1);
				int space_cnt = (2*N - cnt);
				for (int j = 0; j < cnt/2; j++) {
					sb.append(star);
				}
				for(int k =0 ; k < space_cnt ; k++) {
					sb.append(" ");
				}
				for (int j = 0; j < cnt/2; j++) {
					sb.append(star);
				}
				sb.append('\n');
			}
		}
		
		
		System.out.print(sb.toString()); // immuterable
	}
}
*/
