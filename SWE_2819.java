import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SWE_2819 {
    static int[][] map;
    static Set<String> ans = new HashSet<>();
    static String str = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            map = new int[4][4];
            ans = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                String[] inputStr = br.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(inputStr[j]);
                }
            }

            for (int i = 0; i < 4 ; i++){
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, "");
                }
            }

            System.out.println("#"+t+" "+ ans.size());
        }

        br.close();
    }

    private static void dfs(int x, int y, String temp) {
        if (temp.length() == 7){
            ans.add(temp);
            return;
        }
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, 1, 0, -1};

        for (int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (inRange(nx, ny) && temp.length() < 7){
                dfs(nx, ny, temp + map[nx][ny] );
            }
        }
    }
    private static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < 4 && ny >= 0 && ny < 4);
    }
}
