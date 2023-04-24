import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int x;
    int y;
    int dir;
    int cnt;

    public Node(int x, int y, int dir, int cnt) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cnt = cnt;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.cnt - o.cnt;
    }
}

public class BOJ_2151 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int N;
    static Node start;
    static Node end;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '#') {
                    if (idx == 0) {
                        start = new Node(i, j);
                    } else {
                        end = new Node(i, j);
                    }
                    idx++;
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][][] visited = new boolean[N][N][4];

        for (int i = 0; i < 4; i++) {
            pq.add(new Node(start.x, start.y, i, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cnt = cur.cnt;

            visited[x][y][dir] = true;

            if (x == end.x && y == end.y) {
                System.out.println(cnt);
                return;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if ( canGo(nx, ny) && !visited[nx][ny][dir]) {
                if (map[nx][ny] == '!') {
                    //오른쪽
                    int nDir = (dir + 3) % 4;
                    pq.add(new Node(nx, ny, nDir, cnt + 1));

                    // 왼쪽
                    nDir = (dir + 1) % 4;
                    pq.add(new Node(nx, ny, nDir, cnt + 1));
                }

                pq.add(new Node(nx, ny, dir, cnt));
            }
        }
    }

    private static boolean canGo(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != '*';
    }

}