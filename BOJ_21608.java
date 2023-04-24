import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BOJ_21608 {
    static int N;
    static HashMap<Integer, int[]> fav = new HashMap<>();
    static int[][] map;
    static int[] dx = {-1 , 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int ans;
    static int[] nowpos;
    static int empcnt;
    static int favcnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N*N; i++) {
            String[] inputStr = br.readLine().split(" ");
            int key = Integer.parseInt(inputStr[0]);
            fav.put(key, new int[4]);
            for(int j = 1; j < 5; j++){
                fav.get(key)[j-1] = Integer.parseInt(inputStr[j]);
            }
            empcnt = 0;
            favcnt = 0;
            nowpos = new int[]{N, N};
            for(int x = 0; x < N; x++){
                for(int y = 0; y < N; y++){
                    if (map[x][y] != 0){
                        continue;
                    }
                    checkCase(x, y, key);
                }
            }
            //System.out.println(key+ " || "+favcnt+" "+empcnt);

            map[nowpos[0]][nowpos[1]] = key;
            //System.out.println();
        }
//
//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(map[i]));
//        }

        getSatis();
        System.out.println(ans);

        br.close();
    }

    private static void getSatis() {
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                cnt = 0;
                for(int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (!inRange(nx, ny)) {
                        continue;
                    }
                    for(int k = 0; k < 4; k++){
                        if (fav.get(map[i][j])[k] == map[nx][ny]){
                            cnt += 1;
                        };

                    }
                }

                ans += Math.pow(10, cnt-1);
            }
        }


    }

    private static void checkCase(int x, int y, int now) {
        int cnt = 0;
        int ecnt = 0;
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!inRange(nx, ny) ){
                continue;
            }
            for(int i = 0; i < 4; i++){
                if (fav.get(now)[i] == map[nx][ny]){
                    cnt += 1;
                };
            }
            if (map[nx][ny] == 0){
                ecnt ++;
            }
        }
        //System.out.println("now : "+now+ " // "+Arrays.toString(nowpos)+" // "+empcnt+" "+ecnt + " "+favcnt+" "+cnt);

        if (favcnt < cnt){
            nowpos[0] = x;
            nowpos[1] = y;
            favcnt = cnt;
            empcnt = ecnt;
            return;
        }
        else if (favcnt == cnt){
            if (ecnt > empcnt){
                nowpos[0] = x;
                nowpos[1] = y;
                empcnt = ecnt;
                return;
            }
            else if (ecnt == empcnt){
                if (nowpos[0] > x){

                    nowpos[0] = x;
                    nowpos[1] = y;
                    return;
                }
                else if (nowpos[0] == x){

                    if (nowpos[1] > y){
                        nowpos[1] = y;
                        return;
                    }
                }
            }
        }

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}
