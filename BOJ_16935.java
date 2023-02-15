import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16935 {
    //TODO : 연산종류 여러개일때 수정
    static int N;
    static int M;
    static int R;
    static int[] Rnum;
    static int[][] A;
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmr = br.readLine().split(" ");
        N = Integer.parseInt(nmr[0]);
        M = Integer.parseInt(nmr[1]);
        R = Integer.parseInt(nmr[2]);

        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                A[i][j] = Integer.parseInt(inputStr[j]);
            }
        }
        String[] rr = br.readLine().split(" ");
        Rnum = new int[rr.length];
        for(int i = 0; i< R; i++){
            Rnum[i] = Integer.parseInt(rr[i]);
        }

        for(int r : Rnum){
            switch(r){
                case 1:
                    N = A.length;
                    M = A[0].length;
                    upDown();
                    break;
                case 2:
                    N = A.length;
                    M = A[0].length;
                    leftRight();
                    break;
                case 3:
                    N = A.length;
                    M = A[0].length;
                    RRotate();
                    break;
                case 4:
                    N = A.length;
                    M = A[0].length;
                    LRotate();
                    break;
                case 5:
                    N = A.length;
                    M = A[0].length;
                    moveF();
                    break;
                case 6:
                    N = A.length;
                    M = A[0].length;
                    moveS();
                    break;
            }
        }

        for(int i = 0; i < A.length; i++){
            for (int j = 0; j < A[i].length; j++) {
                sb.append(A[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void moveS() {
        int[][] temp = new int[N/2][M/2];
        for (int i = 0; i < N/2; i++){
            for (int j = 0; j < M/2 ; j++) {
                temp[i][j] = A[i][j];
                A[i][j] = A[i][j+M/2];
            }
        }
        for(int i = 0; i < N/2; i++){
            for (int j = M/2; j < M; j++) {
                A[i][j] = A[i+N/2][j];
            }
        }
        for(int i = N/2; i<N; i++){
            for (int j = M/2; j < M; j++) {
                A[i][j] = A[i][j-M/2];
            }
        }

        for(int i = N/2; i < N; i++){
            for (int j = 0; j < M/2; j++) {
                A[i][j] = temp[i-N/2][j];
            }
        }

    }

    private static void moveF() {
        int[][] temp = new int[N/2][M/2];
        for (int i = 0; i < N/2; i++){
            for (int j = 0; j < M/2 ; j++) {
                temp[i][j] = A[i][j];
                A[i][j] = A[N/2+i][j];
            }
        }
        for(int i = N/2; i<N;i++){
            for (int j = 0; j < M/2; j++) {
                A[i][j] = A[i][M/2+j];
            }
        }
        for(int i = N/2; i<N; i++){
            for (int j = M/2; j < M; j++) {
                A[i][j] = A[i-N/2][j];
            }
        }
        for(int i = 0; i < N/2; i++){
            for (int j = M/2; j < M; j++) {
                A[i][j] = temp[i][j-M/2];
            }
        }
    }

    private static void LRotate() {
        int[][] C = copy();
        A = new int[C[0].length][C.length];

        for(int i = C[0].length-1; i >=0; i--){
            int[] temp = new int[C.length];
            int cnt = 0;
            for(int j = 0; j < C.length; j++) {
                temp[cnt++] = C[j][i];
            }
            A[C[0].length-1-i] = temp;
        }
    }

    private static void RRotate() {
        int[][] C = copy();
        A = new int[C[0].length][C.length];

        for(int i = 0; i < C[0].length; i++){
            int[] temp = new int[C.length];
            int cnt = 0;
            for(int j = C.length-1; j >= 0; j--) {
                temp[cnt++] = C[j][i];
            }
            A[i] = temp;
        }
    }

    private static int[][] copy() {
        int[][] c = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++) {
                c[i][j] = A[i][j];
            }
        }
        return c;
    }

    private static void leftRight() {
        for(int i = 0; i < M/2; i++){
            int[] temp = new int[N];
            for(int j = 0; j < N; j++){
                temp[j] = A[j][i];
            }
            for(int j = 0; j < N; j++){
                A[j][i] = A[j][M-i-1];
                A[j][M-i-1] = temp[j];
            }
        }
    }

    private static void upDown() {
        for(int i = 0; i < N/2; i++){
            int[] temp = A[i];
            A[i] = A[N-1-i];
            A[N-1-i] = temp;
        }
    }
}
