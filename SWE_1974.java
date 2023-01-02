package javaAlgorithm;

import java.util.Scanner;

public class SWE_1974 {
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
    int [][] board = new int[9][9];

		for(int test_case = 1; test_case <= T; test_case++)
		{
      int answer = 1;
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
          board[i][j] = sc.nextInt();
        }
      }
      
      for (int i = 0; i < 9 ; i++){
        int row = 0;
				int col = 0;
        for (int j = 0; j < 9; j++){
          row += board[i][j];
          col += board[j][i];
        }
        if (row != 45 || col != 45){
          answer = 0;
          break;
        }
      }

      if (answer != 0){
        for (int i = 0; i< 9 ; i += 3){
          for (int j = 0; j < 9; j += 3){
            int box = 0;
            for (int x = 0; x < 3; x++){
              for (int y = 0; y < 3; y++){
                box += board[i+x][j+y];
              }
            }
            if (box != 45) {
              answer = 0;
              break;
            }
          }
          if (answer == 0) {
            break;
          }
        }
        System.out.println("#" + test_case + " "+answer);
      }
      else{
        System.out.println("#" + test_case + " "+answer);
      }
      
		}
	}
}
