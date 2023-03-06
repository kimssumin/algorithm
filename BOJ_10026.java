import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10026 {
    static char[][] pic;
    static char[][] pic2;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1 ,1 ,0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int normal;
    static int nonnormal;
    static int rcnt, gcnt, bcnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pic = new char[N][N];
        pic2 = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] inputStr = br.readLine().toCharArray();
            pic[i] = Arrays.copyOf(inputStr, N);
            pic2[i] = Arrays.copyOf(inputStr, N);
            for(int j = 0; j < N; j++){
                if (pic2[i][j] == 'G'){
                    pic2[i][j] = 'R';
                }
            }
        }
        //normal
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if (pic[i][j] == 'R' && !visited[i][j]){
                    dfs(i, j, 'R', pic);
                    rcnt++;
                }
                else if (pic[i][j] == 'G' && !visited[i][j]){
                    dfs(i, j, 'G', pic);
                    gcnt++;
                }else if (pic[i][j] == 'B' && !visited[i][j]){
                    dfs(i, j, 'B', pic);
                    bcnt++;
                }
            }
        }
        // System.out.println(rcnt + " "+ gcnt+" "+bcnt);
        normal = rcnt + gcnt + bcnt;

        //NOT normal
        rcnt = 0;
        gcnt = 0;
        bcnt = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if (pic2[i][j] == 'R' && !visited[i][j]){
                    dfs(i, j, 'R', pic2);
                    rcnt++;
                }else if (pic2[i][j] == 'B' && !visited[i][j]){
                    dfs(i, j, 'B', pic2);
                    bcnt++;
                }
            }
        }

        nonnormal = rcnt + bcnt;
        System.out.print(normal + " " + nonnormal);

        br.close();
    }

    private static void dfs(int i, int j, char color, char[][] pann) {
        for(int d = 0; d < 4; d++){
            int ni = i + dx[d];
            int nj = j + dy[d];
            if (!canGo(ni, nj, color, pann)){
                continue;
            }
            visited[ni][nj] = true;
            dfs(ni, nj, color, pann);
        }
    }

    private static boolean canGo(int ni, int nj, char color, char[][] pann) {
        if (!inRange(ni, nj) || visited[ni][nj]){
            return false;
        }
        if (pann[ni][nj] != color){
            return false;
        }
        return true;
    }

    private static boolean inRange(int ni, int nj) {
        return ni >= 0 && ni < N && nj >= 0 && nj < N;
    }

}
