import java.util.Scanner;

public class BOJ_10990 {
	static int N;
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		N = scnn.nextInt();
		String star = "*";
		
		// 문자열 생성 : StringBuilder -> 출력이 많으면 시간이 많이 걸리므로 시간단축을 위해 문자열을 합침
		StringBuilder sb = new StringBuilder(); // mutterable string
		for (int i =0 ; i < N; i++) {
			if (i == 0) {
				int cnt = 1;
				int pre_space = 2*N -1 - (cnt);
				for (int j = 0; j < pre_space/2 ; j++) {
					sb.append(" ");
				}
				sb.append(star);
			}
			else if (i == N-1) {
				int space_cnt = 2*(i)-1;
				sb.append(star);
				for (int j = 0; j < space_cnt ; j++) {
					sb.append(" ");
				}
				sb.append(star);
			}
			else {
				int cnt = 2;
				int space_cnt = 2*(i)-1;
				int pre_space = 2*N -1  - (cnt + space_cnt);
				for (int j = 0; j < pre_space/2 ; j++) {
					sb.append(" ");
				}
				sb.append(star);
				for (int j = 0; j < space_cnt ; j++) {
					sb.append(" ");
				}
				sb.append(star);
			}
			sb.append('\n');
		}
		
		
		System.out.print(sb.toString()); // immuterable
		
	}
}



