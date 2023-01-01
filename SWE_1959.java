package javaAlgorithm;

import java.util.Scanner;

public class SWE_1259 {
	public static void main(String args[]) throws Exception
	{

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N]; 
			int[] B = new int[M];
			
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			
			
			int max_sum = 0;
			
			if(M > N) {
				 for(int i=0; i<M-N+1; i++) {
					 int temp = 0;
					 
					 for(int j=0; j<N; j++) 
						 temp += A[j] * B[i+j];
					 
					 max_sum = Math.max(max_sum, temp);
				 }
			 }
			 else if(N > M){
				 for(int i=0; i<N-M+1; i++) {
					 int temp = 0;
					 
					 for(int j=0; j<M; j++) 
						 temp += A[i+j] * B[j];
					 
					 max_sum = Math.max(max_sum, temp);
				 }
			 }
			 else { //같은 경우
				 int temp = 0;
				 
				 for(int i=0; i<N; i++) 
					 temp = A[i]*B[i];
				 
				 max_sum = Math.max(max_sum, temp);
			 }
			 
			 System.out.println("#" + test_case + " " + max_sum);

		}
	}
}
