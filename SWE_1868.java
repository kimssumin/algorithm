import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_1868 {
    static int ans;
    static int N;
    static String [][] map;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T+1; t++) {
            N = Integer.parseInt(br.readLine());
            map = new String[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++){
                String[] inputStr = br.readLine().split("");
                map[i] = inputStr;
            }

            System.out.println("#"+t+" "+ans);
        }

        br.close();
    }
}
