import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2589 {
    static class Node{
        int x, y, dist;

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dist=" + dist +
                    '}';
        }

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int N, M;
    static char[][] map;
    static int ans = 0;
    static int[] dx = {-1 ,1 ,0 ,0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;
    static int cnt;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        map = new char[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if (map[i][j] == 'L'){
                    visit = new boolean[N][M];
                    q = new LinkedList<>();
                    visit[i][j] = true;
                    q.add(new Node(i, j,0));
                    cnt = 0;
                    bfs(i, j);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.println(ans);

        br.close();
    }

    private static void bfs(int x, int y) {
        while(!q.isEmpty()) {
            Node now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (!canGo(nx, ny)) {
                    continue;
                }
                q.add(new Node(nx, ny, now.dist + 1));
                visit[nx][ny] = true;
                cnt = Math.max(cnt, now.dist+1);
            }
        }
    }

    private static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny) || visit[nx][ny]){
            return false;
        }
        if (map[nx][ny] == 'W'){
            return false;
        }
        return true;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

}
