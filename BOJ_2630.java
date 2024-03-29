import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2630 {

    static int[] cnt = {0, 0};
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        int j;
        for (int i = 0; i < n; i++) {
            String[] inputStr = br.readLine().split(" ");
            j = 0;
            for (String ii : inputStr){
                paper[i][j++]= Integer.parseInt(ii);
            }
        }

        color(0, 0, n);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        br.close();
    }

    private static void color(int r, int c, int n) {

        if (n < 1){
            return;
        }
        if (check(r, c, n) == -1){
            color(r, c, n/2);
            color(r, c+n/2, n/2);
            color(r+n/2, c, n/2);
            color(r+n/2, c+n/2, n/2);

        }
        else{
            cnt[check(r, c, n)] += 1;
            return;
        }
    }

    private static int check(int r, int c, int n){
        int save = paper[r][c] ;
        for (int i = r; i < n+r; i++){
            for (int j = c; j < n+c; j++){
                if (paper[i][j] != save){
                    return -1;
                }
            }
        }
        return save;
    }
}
