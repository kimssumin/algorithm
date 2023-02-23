import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_3055 {
    static int R;
    static int C;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans = Integer.MAX_VALUE;
    static Queue<Point> que = new LinkedList<>();
    static final String cantgo = "KAKTUS";
    static int sr,sc,dr,dc;
    static int[][] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        R = Integer.parseInt(rc[0]);
        C = Integer.parseInt(rc[1]);

        map = new char[R][C];
        time = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] inputStr = br.readLine().toCharArray();
            map[i] = inputStr;
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S'){
                    sr = i;
                    sc = j;
                    que.offer(new Point(i, j));
                }
                else if (map[i][j] == 'D'){
                    dr = i;
                    dc = j;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*'){
                    que.offer(new Point(i, j));
                }
            }
        }

        if(bfs(dr, dc)){
            System.out.println(time[dr][dc]);
        }
        else{
            System.out.println(cantgo);
        }

        br.close();
    }

    private static boolean bfs(int x, int y) {
        while(!que.isEmpty()){
            Point now = que.poll();
            //System.out.println(now.x+": "+now.y);
            if (map[x][y] == 'S'){
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (inRange(nx, ny)){
                    if ((map[nx][ny] == '.' || map[nx][ny] == 'D') && map[now.x][now.y] == 'S'){
                        map[nx][ny] = 'S';
                        time[nx][ny] = time[now.x][now.y] + 1;
                        que.offer(new Point(nx, ny));
                    }
                    else if ((map[nx][ny] == '.' || map[nx][ny] == 'S') && map[now.x][now.y]  == '*'){
                        map[nx][ny] = '*';
                        que.offer(new Point(nx, ny));
                    }
                }
            }

        }
        return false;
    }

    private static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < R && ny >= 0 && ny < C;
    }

}
