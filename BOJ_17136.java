import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_17136 {

    static int[][] map = new int[10][10];
    static int[] lst = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String[] inputStr = br.readLine().split(" ");
            for(int j = 0; j < 10; j++){
                map[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        dfs(0, 0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

        br.close();
    }

    private static void dfs(int x, int y, int cnt) {

        if (x >= 9 && y > 9){
            ans = Math.min(ans, cnt);
            return;
        }

        if (ans <= cnt){
            return;
        }

        if (y > 9){
            dfs(x+1, 0, cnt);
            return;
        }

        if (map[x][y] == 1){
            for(int i = 5; i >= 1; i--){
                if (lst[i] > 0 && canAttach(x, y, i)){
                    lst[i] --;
                    getAttach(x, y, i, 0);
                    dfs(x, y+1, cnt+1);
                    getAttach(x, y, i, 1);
                    lst[i] ++;
                }
            }
        }
        else{
            dfs(x, y+1, cnt);
        }

    }

    private static void getAttach(int x, int y, int save, int val) {
        for(int i = x; i < x + save; i++){
            for(int j = y; j < y+save; j++){
                map[i][j] = val;
            }
        }
    }

    private static boolean canAttach(int x, int y ,int save) {
        for(int i = x; i < x + save; i++){
            for(int j = y; j < y+save; j++){
                if (i >= 10 || i < 0 || j >= 10 || j < 0 ){
                    return false;
                }
                if (map[i][j] != 1){
                    return false;
                }
            }
        }

        return true;
    }

}
