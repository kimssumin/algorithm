import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWE_1486 {
    static int N, B;
    static int[] height;
    static int[] choose;
    static final StringBuilder sb = new StringBuilder();
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t= 1; t <= T; t++) {
            String[] inputStr = br.readLine().split(" ");
            N = Integer.parseInt(inputStr[0]);
            B = Integer.parseInt(inputStr[1]);
            String[] hs = br.readLine().split(" ");
            ans = Integer.MAX_VALUE;
            height = new int[N];

            for(int i = 0; i < N; i++){
                height[i] = Integer.parseInt(hs[i]);
            }

            for(int r = 1; r <= N; r++){
                choose = new int[r];
                combi(0, 0, r);
            }
            sb.append("#"+t+" "+(ans - B)+"\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void combi(int cnt, int start, int r) {
        if (cnt == r){
            int h = sum(choose);
            if (h >= B){
                //System.out.println(h);
                ans = Math.min(ans, h);
            }
            return;
        }
        for(int i = start; i < N; i++){
            choose[cnt] = height[i];
            combi(cnt+1, i+1, r);
        }
    }

    private static int sum(int[] choose) {
        int sum = 0;
        for(int i = 0; i < choose.length; i++){
            sum += choose[i];
        }
        return sum;
    }
}
