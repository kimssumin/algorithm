import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_15685 {

    static int N;
    static int [] dx = {1, 0, -1, 0};
    static int [] dy = {0, -1, 0, 1};
    static int[][] map = new int[101][101];

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            int x = Integer.parseInt(inputStr[0]);
            int y = Integer.parseInt(inputStr[1]);
            int d = Integer.parseInt(inputStr[2]);
            int g = Integer.parseInt(inputStr[3]);

            dragon(x, y, d, g);
        }

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if (map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1){
                    ans ++;
                }
            }
        }
        System.out.println(ans);
        br.close();

    }

    private static void dragon(int x, int y, int d, int g) {
        map[y][x] = 1;

        List<Integer> cl = new ArrayList<>();
        cl.add(d);

        for(int i = 1; i <= g; i++){
            for(int j = cl.size()-1; j >= 0; j--){
                cl.add ((cl.get(j) + 1) % 4);
            }
        }
        //System.out.println(Arrays.toString(cl.toArray()));
        for(int k = 0; k < cl.size(); k++){
            int nx = x + dx[cl.get(k)];
            int ny = y + dy[cl.get(k)];
            map[ny][nx] = 1;
            x = nx;
            y = ny;
        }

    }
}
