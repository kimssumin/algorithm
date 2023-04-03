import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWE_4193 {

    static class Node{
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", time=" + time +
                    '}';
        }
    }
    static final StringBuilder sb = new StringBuilder();
    static int ans;
    static int N;
    static int [][] map;
    static boolean [][] visit;
    static Node start;
    static Node end;
    static int[] dx = {-1 , 1, 0, 0};
    static int[] dy = {0 ,0, 1, -1};
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N][N];

            for(int i = 0; i < N; i++){
                String[] inputStr = br.readLine().split(" ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(inputStr[j]);
                }
            }

            q = new LinkedList<>();
            visit = new boolean[N][N];

            String[] in1 = br.readLine().split(" ");
            start = new Node(Integer.parseInt(in1[0]), Integer.parseInt(in1[1]), 0 );
            String[] in2 = br.readLine().split(" ");
            end = new Node(Integer.parseInt(in2[0]), Integer.parseInt(in2[1]), 0);

            q.add(start);
            visit[start.x][start.y] = true;
            if (!bfs()){
                ans = -1;
            }

            sb.append("#"+t+" "+ans+"\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static boolean bfs() {
        while(!q.isEmpty()){
            Node now = q.poll();

            if (now.x == end.x && now.y == end.y){
                ans = now.time;
                return true;
            }
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (!canGo(nx, ny)){
                    continue;
                }

                if ((map[nx][ny] == 2 && now.time % 3 == 2) || map[nx][ny] == 0){
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny, now.time + 1));
                }
                else if (map[nx][ny] == 2){
                    nx = now.x;
                    ny = now.y;
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny, now.time + 1));
                }
            }
        }

        return false;
    }

    private static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny) || visit[nx][ny]){
            return false;
        }
        if (map[nx][ny] == 1){
            return false;
        }
        return true;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >=0 && ny < N;
    }


}
