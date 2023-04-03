import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11404 {
    private static final long INF = 20_000_000_000L;

    static int N, M;
    static Long[][] bus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        bus = new Long[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(bus[i], INF);
            bus[i][i] = 0L;
        }


        for (int i = 0; i < M; i++) {
            String[] inputStr = br.readLine().split(" ");
            int a = Integer.parseInt(inputStr[0]) - 1;
            int b = Integer.parseInt(inputStr[1]) - 1;
            long c = Long.parseLong(inputStr[2]);

            bus[a][b] = Math.min(bus[a][b], c);
        }


        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if (bus[i][k] == INF || bus[k][j] == INF ){
                        continue;
                    }
                    bus[i][j] = Math.min(bus[i][j], bus[i][k] + bus[k][j]);
                }
            }
        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(bus[i][j] == INF ? 0 : bus[i][j]).append( "");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
