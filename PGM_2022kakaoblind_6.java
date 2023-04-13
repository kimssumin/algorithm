import java.util.*;

class Solution {

    static int[][] temp;
    static int[][] sumtemp;

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;

        temp = new int[N+2][M+2];
        sumtemp = new int[N+2][M+2];

        for(int i = 0; i < skill.length; i++){
            int type = skill[i][0];
            int r1 = skill[i][1]+1;
            int c1 = skill[i][2]+1;
            int r2 = skill[i][3]+1;
            int c2 = skill[i][4]+1;
            int degree = skill[i][5];

            switch(type){
                case 1:
                    //내구도를 낮춘다
                    temp[r1][c1] -= degree;
                    temp[r2+1][c2+1] -= degree;
                    temp[r1][c2+1] += degree;
                    temp[r2+1][c1] += degree;
                    break;
                case 2:
                    //내구도를 높인다
                    temp[r1][c1] += degree;
                    temp[r2+1][c2+1] += degree;
                    temp[r1][c2+1] -= degree;
                    temp[r2+1][c1] -= degree;
                    break;
            }
        }

        for(int i = 0; i < N+2; i++){
            sumtemp[i] = temp[i].clone();
        }


        //누적합 계산
        //행마다

        for(int i = 1; i < N+1; i++){
            for(int j = 2; j < M+1; j++){

                sumtemp[i][j] = sumtemp[i][j-1] + sumtemp[i][j];
            }
        }

        // for(int i = 0; i < N+1; i++){
        //     for(int j = 0; j < M+1; j++){
        //         System.out.print(sumtemp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        //열마다
        for(int j = 1; j < M+2; j++){
            for(int i = 2; i < N+2; i++){
                sumtemp[i][j] = sumtemp[i-1][j] + sumtemp[i][j];
            }
        }

//         for(int i = 0; i < N+2; i++){
//             for(int j = 0; j < M+2; j++){
//                 System.out.print(sumtemp[i][j] + " ");
//             }
//             System.out.println();
//         }


        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < M+1 ; j++){
                if (sumtemp[i][j] + board[i-1][j-1] >= 1){
                    answer ++;
                }
            }
        }

        return answer;
    }
}