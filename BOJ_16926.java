import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16926 {
    static int N;
    static int M;
    static int R;
    static int[][] A;
    static int temp;
    static int base;
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        N = Integer.parseInt(inputStr[0]);
        M = Integer.parseInt(inputStr[1]);
        R = Integer.parseInt(inputStr[2]);

        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] inputStr2 = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                A[i][j] = Integer.parseInt(inputStr2[j]);
            }
        }

        base = (Math.min(N, M)) / 2;
        for(int i = 0; i < R; i++){
            rotate();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(A[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void rotate() {
        for(int i = 0; i < base; i++){

            temp = A[i][i];
            for(int k=i+1; k<M-i; k++){
                A[i][k-1] = A[i][k];
            }

            for(int k=i+1; k<N-i; k++){
                A[k-1][M-1-i] = A[k][M-1-i];
            }

            for(int k=M-2-i; k>=i; k--){
                A[N-1-i][k+1] = A[N-1-i][k];
            }

            for(int k=N-2-i; k>=i; k--){
                A[k+1][i] = A[k][i];
            }

            A[i+1][i] = temp;
        }
    }

}
