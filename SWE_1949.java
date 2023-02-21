import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SWE_1949 {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static List<int[]> highest = new ArrayList<>();
    static int h;
    static int ans;
    static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t<=T; t++) {
            String[] nk = br.readLine().split(" ");
            N = Integer.parseInt(nk[0]);
            K = Integer.parseInt(nk[1]);

            map = new int[N][N];
            visited = new boolean[N][N];
            h = 0;
            ans = 0;
            highest = new ArrayList<>();

            for(int i = 0; i < N; i++){
                String[] m = br.readLine().split(" ");
                for (int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(m[j]);
                    h = Math.max(h, map[i][j]);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == h){
                        highest.add(new int[]{i, j});
                    }
                }
            }

            for (int[] nr : highest){
                visited[nr[0]][nr[1]] = true;
                dfs(nr[0], nr[1], 1, 1);
                visited[nr[0]][nr[1]] = false;
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void dfs(int x, int y, int length, int cnt) {
        int curr= map[x][y];
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(nx, ny))
            {
                visited[nx][ny] = true;
                int next = map[nx][ny];
                if (next < curr) {
                    dfs(nx, ny, length + 1, cnt);
                }
                else if (cnt == 1){
                    // 깎기
                    for(int j = 1; j <= K; j++){
                        if ((map[nx][ny] -j) < curr) {
                            map[nx][ny] -= j;
                            dfs(nx, ny, length +1, cnt-1);
                            map[nx][ny] += j;
                        }
                    }
                }
                visited[nx][ny] = false;
            }


        }
        ans = Math.max(ans, length);
    }

    private static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny) || visited[nx][ny]){
            return false;
        }
        return true;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}
