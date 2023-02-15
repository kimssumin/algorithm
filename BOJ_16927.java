import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16927 {
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
        for(int i = 0; i < base; i++){
            rotate(i, R);
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
    public static void rotate(int l, int count) {
        int V_mod = 2 * (N - 2 * l) + 2 * (M - 2 * l - 2);
        count %= V_mod;

        for (int k = 0; k < count; k++) {
            temp = A[l][l];
            for (int j = l; j < M - l - 1; j++) // upside
                A[l][j] = A[l][j + 1];
            for (int i = l; i < N - l - 1; i++) // rightside
                A[i][M - l - 1] = A[i + 1][M - l - 1];
            for (int j = M - l - 2; j >= l; j--) // downside
                A[N - l - 1][j + 1] = A[N - l - 1][j];
            for (int i = N - l - 2; i >= l; i--) // leftside
                A[i + 1][l] = A[i][l];

            A[l + 1][l] = temp;
        }
    }

}

/*
if(R < N){
            start = new int[]{i+R, i};
        }
        if (R >= N && R < N+M-1){
            start = new int[]{R, i+R-N+1};
        }
        if (R >= N+M-1 && R < N+2*M-2){
            start = new int[]{i-(R-N-M+2) , i};
        }
        else{
            start = new int[]{i, i - (R-N-2*M+3)};
        }
 */