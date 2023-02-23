
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWE_1868 {
    static int ans;
    static int N;
    static String [][] map;
    static int [][] visited;
    static int cnt;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T+1; t++) {
            N = Integer.parseInt(br.readLine());
            map = new String[N+2][N+2];
            visited = new int[N+2][N+2];

            Arrays.fill(map[0], ".");
            Arrays.fill(map[N+1], ".");
            for(int i = 0; i <N+2; i++){
                map[i][0] = ".";
                map[i][N+1] = ".";
            }
            for (int i = 1; i < N+1; i++){
                String[] inputStr = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    map[i][j+1] = inputStr[j];
                }
            }
            ans = 0;
            check();

            for(int i = 1; i < N+1; i++){
                for (int j = 1; j < N+1; j++) {
                    if (map[i][j].equals(".") && visited[i][j] == 0){
                        click(i, j);
                        ans ++;
                    }
                }
            }


            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < N+1; j++) {

                    if (visited[i][j] > 0 && map[i][j].equals(".")){
                        ans ++;
                    }
                }
            }
            System.out.println("#"+t+" "+ans);
        }

        br.close();
    }

    private static void click(int x, int y) {
        int now = visited[x][y];
        visited[x][y] = -1;

        if(now == 0) {
            //주변에 지뢰가 없는 곳
            for(int i = 0; i < 8 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inRange(nx, ny) && !map[nx][ny].equals("*")) {
                    click(nx, ny);
                }
            }
        }

    }

    private static boolean inRange(int nx, int ny) {
        // TODO Auto-generated method stub
        return nx >= 1 && nx < N+1 && ny >=1 &&ny < N+1;
    }

    private static void check() {

        for (int x = 1; x < N+1; x++) {
            for (int y = 1; y < N+1; y++) {
                if(map[x][y].equals(".")) {
                    int cnt = 0;
                    for (int d = 0; d < 8; d++) {
                        int xx = x + dx[d];
                        int yy = y + dy[d];

                        if(!map[xx][yy].equals("*")) {
                            continue;
                        }
                        cnt++;
                    }

                    visited[x][y] = cnt;
                }
            }
        }

    }
}
