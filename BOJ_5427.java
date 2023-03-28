import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {


    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int W, H;
    static char building[][];
    static Queue<Node> fire;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean visit[][];
    static String NOEXIT = "IMPOSSIBLE";
    static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int T = Integer.parseInt(br.readLine());
        int x = 0, y = 0;

        for(int t = 0; t < T; t++) {
            stz = new StringTokenizer(br.readLine());
            W = Integer.parseInt(stz.nextToken());
            H = Integer.parseInt(stz.nextToken());
            building = new char[H][W];
            fire = new LinkedList<>();

            for(int i = 0; i < H; i++) {
                String line = br.readLine();
                for(int j = 0; j < W; j++) {
                    building[i][j] = line.charAt(j);
                    if(building[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                    else if(building[i][j] == '*')
                        fire.add(new Node(i, j));
                }
            }
            escape(x, y);
        }
        System.out.print(sb);
    }

    public static void escape(int sx, int sy) {
        Queue<Node> q = new LinkedList<>();
        visit = new boolean[H][W];
        visit[sx][sy] = true;
        q.offer(new Node(-1, -1));
        q.offer(new Node(sx, sy));
        int time = -1;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.x == -1 && now.y == -1) {
                burn();
                if(!q.isEmpty())
                    q.offer(now);
                time++;
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >= H || ny >= W || nx < 0 || ny < 0) {
                    sb.append(time+1 + "\n");
                    return;
                }
                if(building[nx][ny] == '.' && !visit[nx][ny]) {
                    q.offer(new Node(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }

        sb.append(NOEXIT+"\n");
    }

    public static void burn() {
        int size = fire.size();

        for(int s = 0; s < size; s++) {
            Node now = fire.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < H && ny < W && (building[nx][ny] == '.' || building[nx][ny] == '@')) {
                    fire.offer(new Node(nx, ny));
                    building[nx][ny] = '*';
                }
            }
        }
    }

}