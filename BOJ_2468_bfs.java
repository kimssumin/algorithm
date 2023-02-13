import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2468_bfs {
    static int N;
    static int height;
    static int[][] region;
    static int cnt;
    static int ans = 1;
    static boolean[][] visit;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        region = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                region[i][j] = Integer.parseInt(inputStr[j]);
                height = Math.max(height, region[i][j]);
            }
        }

        for (int h = height; h > 0; h--){
            getZone(h);
            ans = Math.max(cnt, ans);
        }

        System.out.println(ans);

        br.close();
    }

    private static void getZone(int h) {
        cnt = 0;
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N ; j++) {
                if (canGo(i, j, h)){
                    visit[i][j] = true;
                    cnt ++;
                    bfs(i, j, h);
                }
            }
        }

    }

    private static void bfs(int x, int y, int h) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
        	Point now;
        	now = q.poll();
        	for (int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (canGo(nx, ny, h)){
                    visit[nx][ny] = true;
                    bfs(nx, ny, h);
                }
            }
        }
        
    }

    private static boolean canGo(int nx, int ny, int h) {
        if (!inRange(nx, ny) || visit[nx][ny]){
            return false;
        }
        if (region[nx][ny] <= h){
            return false;
        }
        return true;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}
