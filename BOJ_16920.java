import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16920 {

    static int N, M, P;
    static int[] move ;
    static int [] dx = {-1, 1, 0, 0};
    static int[] dy = { 0, 0, 1, -1};
    static int[] ans;
    static char[][] map;
    static char[][] temp;
    static boolean[][] visited;
    static boolean[] done;
    static Queue<Node> q = new LinkedList<>();
    static class Node{
        int x, y, mv;

        public Node(int x, int y, int mv) {
            this.x = x;
            this.y = y;
            this.mv = mv;
        }
    }
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmp = br.readLine().split(" ");
        N = Integer.parseInt(nmp[0]);
        M = Integer.parseInt(nmp[1]);
        P = Integer.parseInt(nmp[2]);

        map = new char[N][M];
        temp = new char[N][M];
        visited = new boolean[N][M];
        ans = new int[P+1];
        move = new int[P+1];
        done = new boolean[P+1];

        String[] s = br.readLine().split(" ");
        for(int i =1; i <= P; i++){
            move[i] = Math.min(1000, Integer.parseInt(s[i-1]));
        }
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if (map[i][j] !=  '.' && map[i][j] != '#'){
                    ans[map[i][j] - '0']++;
                }
            }
        }
        while(true){
            visited = new boolean[N][M];
            if (allUserCheck()){
                break;
            }
            for(int i = 1; i <= P; i++){
                copy(temp, map);
                userExpand(i);
                copy(map, temp);
                System.out.println("###"+i);
                for(int j = 0; j < N; j++){
                    System.out.println(Arrays.toString(map[j]));
                }
            }

        }
        for(int i = 1; i <= P; i++){
            sb.append(ans[i]+" ");
        }

        System.out.print(sb);
        br.close();
    }

    private static void userExpand(int user) {
        int cnt = 0;

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if (map[i][j] ==  '.'|| map[i][j] == '#'){
                    continue;
                }
                if (map[i][j] - '0' == user && !visited[i][j]){
                    q = new LinkedList<>();
                    if(bfs(user, i, j)){
                        cnt ++;
                    }
                }
            }
        }
        if (cnt == 0){
            done[user] = true;
        }
    }

    private static boolean bfs(int user, int i, int j) {
        visited[i][j] = true;
        q.add(new Node(i, j, 1));
        boolean flag = false;
        int cnt = 0;
        while(!q.isEmpty()){
            cnt ++;
            Node now = q.poll();
            for(int d = 0 ; d < 4; d++){
                //for(int n = 1; n <= move[user]; n++) {
                //}
                int ni = now.x + now.mv*dx[d];
                int nj = now.y + now.mv*dy[d];
                if (!canGo(ni, nj)){
                    //break;
                    continue;
                }
                flag = true;
                visited[ni][nj] = true;
                temp[ni][nj] = map[i][j];
                if (cnt < move[user]){
                    q.add(new Node(now.x, now.y, cnt+1));
                }
                ans[user] ++;

            }
        }
        if (flag){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean canGo(int ni, int nj) {
        if(!inRange(ni, nj) || visited[ni][nj]){
            return false;
        }
        if (map[ni][nj] != '.'){
            return false;
        }

        return true;
    }

    private static boolean inRange(int ni, int nj) {
        return ni >= 0 && ni < N && nj >= 0 && nj < M;
    }

    private static void copy(char[][] cv, char[][] cc){
        for(int i = 0; i < cc.length; i++)
        {
            cv[i] = cc[i].clone();
        }
    }
    private static boolean allUserCheck() {
        for(int i = 1; i <= P; i++){
            if (!done[i]){
                return false;
            }
        }
        return true;
    }
}
