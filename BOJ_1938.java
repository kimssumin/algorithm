import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1938 {

    static int N;
    static char[][] map;
    static boolean[][][] visited;
    static int ans;
    static class Node {
        int x, y,dir, cnt;

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
    static Node startNode;
    static Node endNode;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N][2];

        int[] s = new int[]{0,0, 1};
        int[] e = new int[]{0, 0, 1};
        boolean sd= false;
        boolean ed= false;

        for (int i = 0; i < N; i++) {
            char[] inputStr = br.readLine().toCharArray();
            map[i] = inputStr;
            sd = false;
            ed = false;
            for(int j = 0; j < N; j++){
                if (map[i][j] == 'B'){
                    if (sd){
                        s[2] = 0; //row
                    }
                    s[1] += j;
                    s[0] += i;
                    sd = true;

                }
                else if (map[i][j] == 'E'){
                    if (ed){
                        e[2] = 0; //row
                    }
                    e[0] += i;
                    e[1] += j;
                    ed = true;
                }
            }
        }

        //row : 0, col : 1
        startNode = new Node(s[0]/3 , s[1]/3, s[2], 0);
        endNode = new Node(e[0]/3 , e[1]/3, e[2], 0);
//        System.out.println(startNode);
//        System.out.println(endNode);

        visited[s[0]/3][s[1]/3][s[2]] = true;
        q.add(startNode);
        bfs();
        System.out.println(ans);
        br.close();
    }

    private static void bfs() {
        int[] dx = {-1, 1, 0 ,0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty()){
            Node now = q.poll();
//            System.out.println(now);
            if (now.x == endNode.x && now.y == endNode.y && now.dir == endNode.dir){
                ans = now.cnt;
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (!inRange(nx, ny, now.dir) || visited[nx][ny][now.dir]){
                    continue;
                }
                if (canMove(nx, ny, now.dir, i)){
                    q.add(new Node(nx, ny, now.dir, now.cnt+1));
                    visited[nx][ny][now.dir] = true;
                }
            }
            //회전
            if (!visited[now.x][now.y][1-now.dir] && canTurn(now.x, now.y)){
                q.add(new Node(now.x, now.y, 1-now.dir, now.cnt+1));
                visited[now.x][now.y][1-now.dir] = true;
            }

        }
        ans = 0;
        return;
    }

    private static boolean inRange(int nx, int ny, int dir) {
        if (dir == 0){
            return nx >= 0 && nx < N && ny >= 1 && ny < N-1;
        }
        else{
            return nx >= 1 && nx < N-1 && ny >= 0 && ny < N;
        }
    }

    private static boolean canTurn(int x, int y) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (!(x+i-1 >= 0 && x+i-1 <N && y+j-1 >= 0 && y+j-1 < N)){
                    return false;
                }
                if (map[x+i-1][y+j-1] != 'B' &&  map[x+i-1][y+j-1] != '0' && map[x+i-1][y+j-1] != 'E'){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean canMove(int nx, int ny, int dir, int nowD) {
        //nowD 상하좌우 순
        switch(dir) {
            case 0:
                if(nowD < 2) {
                    if(nx < 0 || nx >= N) return false;
                    // 나무가 있을 경우 false
                    if(map[nx][ny] == '1' || map[nx][ny - 1] == '1' || map[nx][ny + 1] == '1') return false;
                }
                else {
                    if(ny - 1 < 0 || ny + 1 >= N) return false;
                    if(map[nx][ny] == '1' || map[nx][ny - 1] == '1' || map[nx][ny + 1] == '1') return false;
                }

                break;
            case 1:

                if(nowD < 2) {
                    if(nx - 1 < 0 || nx + 1 >= N) return false;
                    if(map[nx][ny] == '1' || map[nx - 1][ny] == '1' || map[nx + 1][ny] == '1') return false;
                }

                else {
                    if(ny < 0 || ny >= N) return false;
                    if(map[nx][ny] == '1' || map[nx - 1][ny] == '1' || map[nx + 1][ny] == '1') return false;
                }

                break;

            default:
                break;
        }

        return true;
    }
}