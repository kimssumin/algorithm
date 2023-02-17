import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2638 {

    static class P{
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static final int NONE = 0;
    public static final int CHEESE = 1;
    
    public static int N, M;

    public static int[][] map;
    public static int[][] visited;

    public static int[] dx = new int[]{1, -1, 0, 0};
    public static int[] dy = new int[]{0, 0, 1, -1};
    public static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm =  br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(inputStr[j]);
            }
        }
        do {
            simulate();
        } while(isCheese()); // 치즈가 존재하는 한 계속 반복

        System.out.print(time);

        br.close();
    }

    public static void simulate() {
        time++;
        bfs();
        melt();  // 둘러쌓이지 않은 치즈들
    }
    private static boolean isCheese() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(map[i][j] == CHEESE){
                    return true;
                }
        return false;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }


    public static void init() {
        visited = new int[N][M];
    }

    public static void bfs() {
        init();
        Queue<P> q = new LinkedList<>();
        q.add(new P(0, 0));
        visited[0][0] = 2;

        while(!q.isEmpty()) {
            P now = q.poll();
            int x = now.x;
            int y = now.y;

            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (!inRange(x, y)){
                    continue;
                }
                if(inRange(nx, ny) && map[nx][ny] == NONE && visited[nx][ny] == 0) {
                    q.add(new P(nx, ny));
                    visited[nx][ny] = 2;
                }
            }
        }
    }

    public static void melt() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(map[i][j] == CHEESE && outsideCheeseCheck(i, j)) {
                    map[i][j] = NONE;
                }
    }

    public static boolean outsideCheeseCheck(int x, int y) {
        int cnt = 0;
        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(inRange(nx, ny) && visited[nx][ny] == 2) {
                cnt++;
            }
        }
        return cnt >= 2;
    }


}
