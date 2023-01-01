package javaAlgorithm;

import java.util.Scanner;

public class SWE_1209 {
	public static void main(String args[]) throws Exception
	{

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int tn = sc.nextInt();
			int[][] arr = new int[100][100];
			
			int row_max = 0;
			int col_max = 0;
			int leftright_max = 0;
            int rightleft_max = 0;
            
			for (int i = 0; i < 100; i++) {
				int row = 0;
				for (int j = 0; j < 100; j++) {
					int val = sc.nextInt();
					arr[i][j] = val;
					
					row += val;
					
					if (j == 99) {
						row_max = Math.max(row, row_max);
					}
				}
			}
			
			for(int i = 0; i<100; i++){
                
                leftright_max += arr[i][i];
                rightleft_max += arr[i][99-i];
                int col = 0;
                for(int j=0; j<100; j++){
                    col += arr[j][i];
                    if (j == 99) {
						col_max = Math.max(col, col_max);
					}
                }
            }
			
            int first_max = Math.max(rightleft_max,leftright_max);
            int second_max = Math.max(row_max, col_max);
            int fin_max = Math.max(first_max, second_max);
             
            System.out.println("#" + tn + " " + fin_max);

		}
	}
}
