import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14499 {

    static class Node{
        int val, x, y;

        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static int N, M, x, y, K;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] move;
    static int [] dice = new int[7];

    static Node now_bottom;
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        x = Integer.parseInt(in[2]);
        y = Integer.parseInt(in[3]);
        K = Integer.parseInt(in[4]);

        map = new int[N][M];
        now_bottom = new Node(6, x, y);
        for (int i = 0; i < N; i++) {
            String[] num = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(num[j]);
            }
        }
        dice[0] = -1; // 의미없는 수

        String[] doing = br.readLine().split(" ");
        move = new int[K];
        for(int i = 0; i < K; i++){
            move[i] = Integer.parseInt(doing[i]);
        }

        for(int m : move){
            switch (m){
                case 1:
                    if (check(0)) {
                        dice = new int[]{-1, dice[4], dice[2], dice[1], dice[6], dice[5], dice[3]};
                        moving(0);
                    }
                    break;
                case 2:
                    if (check(1)) {
                        dice = new int[]{-1, dice[3], dice[2], dice[6], dice[1], dice[5], dice[4]};
                        moving(1);
                    }
                    break;
                case 3 :
                    if (check(2)) {
                        dice = new int[]{-1, dice[5], dice[1], dice[3], dice[4], dice[6], dice[2]};
                        moving(2);
                    }
                    break;
                case 4 :
                    if (check(3)) {
                        dice = new int[]{-1, dice[2], dice[6], dice[3], dice[4], dice[1], dice[5]};
                        moving(3);
                    }
                    break;
            }
        }

        System.out.print(sb);
        br.close();
    }

    private static boolean check(int d) {
        int x = now_bottom.x;
        int y = now_bottom.y;

        int nx = x + dx[d];
        int ny = y + dy[d];

        if(!inRange(nx, ny)){
            return false;
        }
        return true;
    }

    private static void moving(int d) {
        int x = now_bottom.x;
        int y = now_bottom.y;

        int nx = x + dx[d];
        int ny = y + dy[d];

        if(!inRange(nx, ny)){
            return;
        }
        if (map[nx][ny] == 0){
            map[nx][ny] = dice[6];
        }
        else{
            dice[6] = map[nx][ny];
            map[nx][ny] = 0;
        }

        now_bottom.x = nx;
        now_bottom.y = ny;
        //System.out.println(Arrays.toString(dice));
        sb.append(dice[1]+"\n");
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
