import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2961 {
    static int[] sinlst;
    static int[] ssnlst;
    static int[] p;
    static int n;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sinlst = new int[n];
        ssnlst = new int[n];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int i = 0; i < n; i++) {
            String[] inputStr = br.readLine().split(" ");
            sinlst[i] = Integer.parseInt(inputStr[0]);
            ssnlst[i] = Integer.parseInt(inputStr[1]);
        }

        if (n == 1) {
            System.out.println(Math.abs(ssnlst[0] - sinlst[0]));
            return;
        }

        food(0, 0, 1, 0);

        System.out.println(ans);
        br.close();
    }

    public static void food(int input_cnt, int cnt, int sin_sum, int ss_sum) {
        if(cnt == n) {
            if(input_cnt !=0) {
                ans = Math.min(ans, Math.abs(sin_sum-ss_sum));
            }
            return;
        }
        food(input_cnt, cnt+1, sin_sum, ss_sum);
        food(input_cnt+1, cnt+1, sin_sum*sinlst[cnt], ss_sum+ssnlst[cnt]);
    }

}