import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_1954 {
    static int [][] board;
    static int[] dx = {0, 1, 0, -1}; //우하좌상
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T+1; t++){

            int N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            int num = 2;
            int x = 0;
            int y = 0;
            board[x][y] = 1;

            int i =0;
            while(num <= N*N){
                int new_x = x + dx[i];
                int new_y = y + dy[i];
                if (new_x >= N || new_x < 0 || new_y < 0 || new_y >= N || board[new_x][new_y] != 0){
                    i = (i+1)%4;

                }
                else{
                    board[new_x][new_y] = num;
                    num++;
                    x = new_x;
                    y = new_y;
                }
            }

            System.out.println("#"+t);
            // answer
            for(int k = 0; k < N; k++){
                for (int j = 0; j < N; j++) {
                    System.out.print(board[k][j] + " ");
                }
                System.out.println();
            }

        }
        br.close();
    }
}
