import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_15683 {

    public static class CCTV{
        int i;
        int j;
        int camNum;
        public CCTV(int i, int j, int camNum) {
            this.i = i;
            this.j = j;
            this.camNum = camNum;
        }
    }
    static int N;
    static int M;
    static int [][] map;
    static List<CCTV> cctvs = new ArrayList<>();
    static int ans;
    static int cctvsize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputStr[j]);
                if (map[i][j] != 0 && map[i][j] != 6){
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        ans = Integer.MAX_VALUE;
        cctvsize = cctvs.size();

        dfs(0, map);
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);

        br.close();
    }

    private static void dfs(int cnt, int[][] map2) {
        if (cnt == cctvsize){
            //모든 cctv 방문
            ans = Math.min(ans, getblindSpot(map2));
            return;
        }

        int cameraNum = cctvs.get(cnt).camNum;
        int x = cctvs.get(cnt).i;
        int y = cctvs.get(cnt).j;

        int[][] now;
        switch(cameraNum){
            case 1:
                now = copyMap(map2);
                goLeft(now, x, y);
                dfs(cnt+1,now);

                now = copyMap(map2);
                goRight(now, x, y);
                dfs(cnt+1,now);

                now = copyMap(map2);
                goUp(now, x, y);
                dfs(cnt+1,now);

                now = copyMap(map2);
                goDown(now, x, y);
                dfs(cnt+1,now);
                break;

            case 2:
                now = copyMap(map2);
                goLeft(now, x, y);
                goRight(now, x, y);
                dfs(cnt+1,now);

                now = copyMap(map2);
                goUp(now, x, y);
                goDown(now, x, y);
                dfs(cnt+1,now);
                break;

            case 3:
                now = copyMap(map2);
                goLeft(now, x, y);
                goUp(now, x, y);
                dfs(cnt+1,now);

                now = copyMap(map2);
                goRight(now, x, y);
                goUp(now, x, y);
                dfs(cnt+1,now);

                now = copyMap(map2);
                goRight(now, x, y);
                goDown(now, x, y);
                dfs(cnt+1,now);

                now = copyMap(map2);
                goLeft(now, x, y);
                goDown(now, x, y);
                dfs(cnt+1,now);
                break;

            case 4:
                now = copyMap(map2);
                goLeft(now, x, y);
                goUp(now, x, y);
                goRight(now, x, y);
                dfs(cnt+1,now);

                now = copyMap(map2);
                goLeft(now, x, y);
                goUp(now, x, y);
                goDown(now, x, y);
                dfs(cnt+1,now);

                now = copyMap(map2);
                goRight(now, x, y);
                goUp(now, x, y);
                goDown(now, x, y);
                dfs(cnt+1,now);

                now = copyMap(map2);
                goLeft(now, x, y);
                goRight(now, x, y);
                goDown(now, x, y);
                dfs(cnt+1,now);
                break;


            case 5:
                now = copyMap(map2);
                goLeft(now, x, y);
                goRight(now, x, y);
                goUp(now, x, y);
                goDown(now, x, y);
                dfs(cnt+1,now);
                break;
        }


    }

    private static void goDown(int[][] tmp, int x, int y) {
        for(int nx = x+1; nx < N; nx++){
            if (tmp[nx][y] == 6){
                return;
            }
            if (tmp[nx][y] != 0){
                continue;
            }
            tmp[nx][y] = -1;
        }
    }

    private static void goUp(int[][] tmp, int x, int y) {
        for(int nx = x-1; nx >= 0; nx--){
            if (tmp[nx][y] == 6){
                return;
            }
            if (tmp[nx][y] != 0){
                continue;
            }
            tmp[nx][y] = -1;
        }
    }

    private static void goRight(int[][] tmp, int x, int y) {
        for(int ny = y+1; ny < M; ny++){
            if (tmp[x][ny] == 6){
                return;
            }
            if (tmp[x][ny] != 0){
                continue;
            }
            tmp[x][ny] = -1;
        }
    }

    private static void goLeft(int[][] tmp, int x, int y) {
        for(int ny = y-1; ny >= 0; ny--){
            if (tmp[x][ny] == 6){
                return;
            }
            if (tmp[x][ny] != 0){
                continue;
            }
            tmp[x][ny] = -1;
        }
    }

    private static int[][] copyMap(int[][] map2) {
        int[][] temp = new int[N][M];
        for(int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                temp[i][j] = map2[i][j];
            }
        }
        return temp;
    }

    private static int getblindSpot(int[][] map2) {
        int cnt = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (map2[i][j] == 0){
                    cnt ++;
                }
            }
        }
        return cnt;
    }

}
