import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1987 {
    static int R;
    static int C;
    static String[][] board;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    static String temp = "";
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        R = Integer.parseInt(inputStr[0]);
        C = Integer.parseInt(inputStr[1]);
        board = new String[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] is = br.readLine().split("");
            board[i] = is;
        }

        temp = board[0][0];
        visited[0][0] = true;
        dfs(0,0, temp);
        System.out.println(ans);
        br.close();
    }

    private static void dfs(int x, int y, String t) {
        ans = Math.max(ans, t.length());
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(nx, ny, t)){
                visited[nx][ny] = true;
                dfs(nx, ny, t+board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    private static boolean canGo(int nx, int ny, String t) {
        if (!inRange(nx, ny) || visited[nx][ny]){
            return false;
        }
        if (t.contains(board[nx][ny])){
            return false;
        }
        return true;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < R && ny >= 0 && ny < C;
    }
}
