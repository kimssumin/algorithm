import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2146 {

    static class Node{
        int x, y, dist;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> island = new LinkedList<>();
    static Queue<Node> bridge = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        //섬 구분
        int cnt = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){

                if (map[i][j] == 1 && !visited[i][j]){
                    bfs(i, j, cnt++);

                }
            }
        }



        //다리 놓기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if (map[i][j] != 0){
                    visited = new boolean[N][N];
                    bfs2(i, j, map[i][j]);
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    private static void bfs2(int i, int j, int now) {
        bridge = new LinkedList<>();
        bridge.add(new Node(i, j, 0));
        visited[i][j] = true;
        while(!bridge.isEmpty()){
            Node now2 = bridge.poll();
            for(int d = 0; d < 4; d++){
                int nx = now2.x + dx[d];
                int ny = now2.y + dy[d];
                if (inRange(nx, ny) && !visited[nx][ny]){
                    if (map[nx][ny] == now || map[nx][ny] == 0){
                        bridge.add(new Node(nx, ny, now2.dist+1));
                        visited[nx][ny] = true;
                    }
                    else{
                        ans = Math.min(ans, now2.dist);
                    }
                }

            }
        }
    }


    private static void bfs(int i, int j, int cnt) {
        island = new LinkedList<>();
        island.add(new Node(i, j));
        visited[i][j] = true;
        map[i][j] = cnt;
        while(!island.isEmpty()){
            Node now = island.poll();
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (canGo(nx, ny)){
                    island.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = cnt;
                }
            }
        }

    }

    private static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny) || visited[nx][ny]){
            return false;
        }
        if (map[nx][ny] == 0){
            return false;
        }
        return true;
    }


    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }

    private static void print(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
