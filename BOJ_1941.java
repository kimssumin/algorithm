import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1941 {

    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static char[][] map = new char[5][5];
    static int ans;
    static boolean[][] visit = new boolean[5][5];
    static int[] p = new int[7];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0 ,0 , 1, -1};
    static List<int[]> ss = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        combi(0, 0);
        System.out.println(ans);
        br.close();
    }

    private static void combi(int cnt, int start) {
        if (cnt == 7){
            if (bfs()){
                if (checkS()){
                    ans ++;
                    //System.out.println(Arrays.toString(p));
                };
            };
            return;
        }
        for(int i = start; i < 25; i++){
            p[cnt] = i;
            combi(cnt+1, i+1);
        }
    }

    private static boolean checkS() {
        int cnt = 0;
        for(int i = 0; i < 7; i++){
            int nx = p[i]/5;
            int ny = p[i]%5;
            if (map[nx][ny] == 'S'){
                cnt ++;
            }
        }

        return cnt >= 4;
    }

    private static boolean bfs() {
        boolean[] visited = new boolean[7];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(p[0]/5, p[0]%5));
        visited[0] =  true;
        int cnt = 1;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!inRange(nx, ny)){
                    continue;
                }
                for(int i = 1; i < p.length; i++){
                    if (nx == p[i]/5 && ny == p[i]% 5 && !visited[i]){
                        visited[i] = true;
                        q.add(new Node(nx, ny));
                        cnt ++;
                        break;
                    }

                }
            }
        }
        if (cnt == 7){
            return true;
        }
        return false;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < 5 && ny >= 0 && ny < 5;
    }


}
