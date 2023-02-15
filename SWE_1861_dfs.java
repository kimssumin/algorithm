import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWE_1861_dfs {
    static int N;
    static int[][] A;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int anscnt;
    static int ansnum;
    static int nowcnt;
    static int nownum;

    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T+1; t++) {
            N = Integer.parseInt(br.readLine());
            A = new int[N][N];
            anscnt = 0;
            ansnum = 0;

            for(int i = 0; i < N; i++){
                String[] inputStr = br.readLine().split(" ");
                for(int j = 0; j < N; j++){
                    A[i][j] = Integer.parseInt(inputStr[j]);
                }
            }

            for(int i = 0; i < N; i++){
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    nowcnt = 1;
                    nownum = A[i][j];
                    dfs(i, j);
                    if (anscnt < nowcnt){
                        anscnt = nowcnt;
                        ansnum = nownum;
                    }
                    if (anscnt == nowcnt){
                        ansnum = Math.min(nownum, ansnum);
                    }
                }
            }

            System.out.println("#"+t+" "+ansnum+" "+anscnt);
        }

        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nowRoom = A[x][y];
            if(canGo(nx, ny, nowRoom)){
                nowcnt ++;
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    private static boolean canGo(int nx, int ny, int now) {
        if (!inRange(nx, ny) || visited[nx][ny]){
            return false;
        }
        if (!roomCheck(nx, ny, now)){
            return false;
        }
        return true;
    }

    private static boolean roomCheck(int nx, int ny, int now) {
        return A[nx][ny] - now == 1;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }


}
