import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14503 {
    static int N;
    static int M;
    static int r, c, d;
    static int [][] map;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {-1, 0, 1, 0};

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        map = new int[N][M];
        String[] rdc = br.readLine().split(" ");
        r = Integer.parseInt(rdc[0]);
        c = Integer.parseInt(rdc[1]);
        d = Integer.parseInt(rdc[2]);
        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(inputStr[j]);
            }
        }
        d = 3-d;
        cleaning(r, c);
        System.out.println(ans);
        br.close();
    }

    private static void cleaning(int r, int c) {
        int x = r;
        int y = c;
        while(check()){
            if (map[x][y] == 0){
                ans += 1;
                map[x][y] = 2;
            }
            int move_dir = fourCheck(x, y, d);
            //System.out.println(move_dir);
            if (move_dir != -1){
                int nx = x + dx[move_dir];
                int ny = y + dy[move_dir];
                map[nx][ny] = 2;
                ans += 1;
                x = nx;
                y = ny;
                d = move_dir;
            }
            else{
                //후진가능하면 후진
                int nx = x - dx[d];
                int ny = y - dy[d];
                if (!inRange(nx, ny)){
                    break;
                }
                if (map[nx][ny] == 1){
                    break;
                }
                x = nx;
                y = ny;
            }

        }

    }

    private static int fourCheck(int r, int c, int d) {
        int now_d = d;
        for(int i = 0; i < 4; i++){
            int nr = r + dx[(now_d + i +1) % 4];
            int nc = c + dy[(now_d + i +1) % 4];
            if (!inRange(nr, nc)){
                continue;
            }
            if (map[nr][nc] == 0){
                return (now_d + i +1) % 4;
            }
        }
        return -1;
    }

    private static boolean inRange(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < M;
    }

    private static boolean check() {
        //청소되지 않은 칸 이 없는 경우
        for(int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
