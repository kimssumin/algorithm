import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11660 {
    static int N;
    static int M;
    static int[][] sum;
    static int tot;
    static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        N = Integer.parseInt(inputStr[0]);
        M = Integer.parseInt(inputStr[1]);

        sum = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            String[] in = br.readLine().split(" ");
            for(int j = 1; j < N+1; j++){
                tot = Integer.parseInt(in[j-1]) + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
                sum[i][j] = tot;
            }
        }

        for(int i = 0; i < M; i++){
            String[] in2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(in2[0]);
            int y1 = Integer.parseInt(in2[1]);
            int x2 = Integer.parseInt(in2[2]);
            int y2 = Integer.parseInt(in2[3]);

            int a = sum[x1-1][y2];
            int b = sum[x2][y1-1];
            int c = sum[x1-1][y1-1];

            sb.append(sum[x2][y2] - (a + b - c)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
