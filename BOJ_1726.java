import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1726 {

    static class Node{
        int x, y, dir, cnt;

        public Node(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    ", cnt=" + cnt +
                    '}';
        }
    }
    static int M, N;
    static int[][] map;
    static Node start;
    static Node end;
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    static int ans = Integer.MAX_VALUE;
    static boolean[][][] visit ;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");
        M = Integer.parseInt(mn[0]);
        N = Integer.parseInt(mn[1]);
        map = new int[M][N];
        visit = new boolean[M][N][4];
        for (int i = 0; i < M; i++) {
            String[] inputStr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        String[] st = br.readLine().split(" ");
        start = new Node(Integer.parseInt(st[0]) - 1, Integer.parseInt(st[1]) - 1, Integer.parseInt(st[2])-1, 0);
        String[] ed = br.readLine().split(" ");
        end = new Node(Integer.parseInt(ed[0]) - 1, Integer.parseInt(ed[1]) - 1, Integer.parseInt(ed[2])-1, 0);

        visit[start.x][start.y][start.dir] = true;
//        visit[start.x][start.y] = true;
        q.add(start);
        bfs();
        System.out.println(ans);
        br.close();
    }

    private static void bfs() {

        while(!q.isEmpty()){
            Node now = q.poll();
            //System.out.println(now.toString());
//            if (ans < now.cnt){
//                continue;
//            }
            if (now.x == end.x && now.y == end.y && now.dir == end.dir){
                //System.out.println("fin >>> "+ now.toString());
                ans = Math.min(ans, now.cnt);

                return;

            }

            int nx = -1;
            int ny = -1;
            //명령1

            for(int k = 1; k < 4; k++) {
                nx = now.x + k * dx[now.dir];
                ny = now.y + k * dy[now.dir];
                if (!inRange(nx, ny)){
                    continue;
                }
                if (map[nx][ny] == 1){
                    break;
                }
                if (!visit[nx][ny][now.dir]) {
                    visit[nx][ny][now.dir] = true;
                    q.add(new Node(nx, ny, now.dir, now.cnt+1));
                }
            }
            //명령2
            if (now.dir == 0 || now.dir == 1){
                if (!visit[now.x][now.y][3]){
                    visit[now.x][now.y][3] = true;
                    q.add(new Node(now.x ,  now.y, 3, now.cnt+1));
                }

                if (!visit[now.x][now.y][2]){
                    visit[now.x][now.y][2] = true;
                    q.add(new Node(now.x ,  now.y, 2, now.cnt+1));
                }
            }
            else{
                if (!visit[now.x][now.y][0]){
                    visit[now.x][now.y][0] = true;
                    q.add(new Node(now.x ,  now.y, 0, now.cnt+1));
                }

                if (!visit[now.x][now.y][1]){
                    visit[now.x][now.y][1] = true;
                    q.add(new Node(now.x ,  now.y, 1, now.cnt+1));
                }
            }

        }
    }


    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < M && ny >= 0 && ny < N;
    }
}
