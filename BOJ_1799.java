import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1799 {
    static int N;
    static int [][] map;
    static boolean [][] visited;
    static int ans;
    static List<Integer> cases;
    static int[] nums;
    static int[] p;
    static boolean flag;
    static int [] dx = {-1, -1, 1, 1};
    static int [] dy = {-1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        cases = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(inputStr[j]);
                if (map[i][j] == 1){
                    int n = i * N + j;
                    cases.add(n);
                }
            }
        }

        nums = new int[cases.size()];
        for(int i = 0; i < cases.size(); i++){
            nums[i] = cases.get(i);
        }
//        System.out.println(Arrays.toString(nums));
        for(int r = cases.size() ; r >= 0; r--){
            p = new int[r];
            combi(0, 0, r);
            if (flag){
                ans = r;
                break;
            }
        }

        System.out.println(ans);
        br.close();
    }

    private static void combi(int start, int cnt ,int r) {
        if (cnt == r){
            if (bishopCheck()){
                flag = true;
            }
            return;
        }

        for(int i = start; i < nums.length; i++){
            p[cnt] = nums[i];
            combi(i+1, cnt+1, r);
        }
    }

    private static boolean bishopCheck() {
        visited = new boolean[N][N];
        for(int i = 0; i < p.length; i++){
            int x = p[i]/N;
            int y = p[i]%N;
            if (visited[x][y] == true){
                return false;
            }

            visited[x][y] = true;

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                while(inRange(nx, ny)){
                    visited[nx][ny] = true;
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }

        return true;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

/*

 */
