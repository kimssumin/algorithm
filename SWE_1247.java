import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_1247 {
    static int N;
    static int cx, cy, hx, hy;
    static int [][] customer;
    static boolean [] visited;
    static int ans = Integer.MAX_VALUE;
    static int dist;
    static int now;

    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            String[] inputStr = br.readLine().split(" ");
            cx = Integer.parseInt(inputStr[0]);
            cy = Integer.parseInt(inputStr[1]);
            hx = Integer.parseInt(inputStr[2]);
            hy = Integer.parseInt(inputStr[3]);
            customer = new int[N][2];
            visited = new boolean[N];
            int idx = 0;
            for(int j = 0; j < 2*N; j+=2) {
                customer[idx][0] = Integer.parseInt(inputStr[j + 4]);
                customer[idx][1] = Integer.parseInt(inputStr[j + 5]);
                idx ++;
            }

            ans = Integer.MAX_VALUE;
            dist = 0;
            now = 0;
            distCheck(cx, cy, 0, 0);


            sb.append("#").append(t+1).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private static void distCheck(int cx, int cy, int now, int cnt) {
        if (cnt == N){
            now = now + getDist(cx, cy, hx, hy);
            ans = Math.min(ans, now);
            return;
        }
        for(int i = 0; i < N; i++ ){
            if (visited[i]){
                continue;
            }
            dist = getDist(cx, cy, customer[i][0], customer[i][1]);
            visited[i] = true;
            distCheck(customer[i][0], customer[i][1], now + dist, cnt + 1);
            visited[i] = false;
        }
    }

    private static int getDist(int cx, int cy, int nx, int ny) {
        return Math.abs(nx-cx)+ Math.abs(ny-cy);
    }


}
