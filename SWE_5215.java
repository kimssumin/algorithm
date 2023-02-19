import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_5215 {
    static int N;
    static int L;
    static int [] idx;
    static int [] score;
    static int [] cal;
    static boolean[] visited;
    static int ans;
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] nl = br.readLine().split(" ");
            N = Integer.parseInt(nl[0]);
            L = Integer.parseInt(nl[1]);
            score = new int[N];
            visited = new boolean[N];
            cal = new int[N];
            idx = new int[N];
            ans = 0;
            for (int i = 0; i < N; i++) {
                idx[i] = i;
            }

            for(int i = 0; i < N; i++){
                String[] inputStr = br.readLine().split(" ");
                score[i] = Integer.parseInt(inputStr[0]);
                cal[i] = Integer.parseInt(inputStr[1]);
            }
            //
            power(0, 0, 0);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }


    private static void power(int cnt, int tot, int score_tot) {
        if (tot > L){
            return;
        }
        if (cnt == N) {
            ans = Math.max(ans, score_tot);
            return;
        }

        power(cnt+1, tot+cal[cnt], score_tot + score[cnt]);
        power(cnt+1, tot, score_tot);
    }

}
