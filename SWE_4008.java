import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_4008 {
    static int ansmax;
    static int ansmin;
    static int N;
    static int[] mode = new int[4];
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            num = new int[N];
            mode = new int[4];
            ansmax = Integer.MIN_VALUE;
            ansmin = Integer.MAX_VALUE;
            String[] inputStr = br.readLine().split(" ");
            for(int i = 0; i < 4; i++){
                mode[i] = Integer.parseInt(inputStr[i]);
            }
            String[] inputStr2 = br.readLine().split(" ");
            for(int i = 0; i < N; i++){
                num[i] = Integer.parseInt(inputStr2[i]);
            }

            calc(num[0], 1, mode[0], mode[1], mode[2], mode[3]);


            System.out.println("#"+t+ " "+ (ansmax - ansmin));
        }

        br.close();
    }

    private static void calc(int n, int i, int add, int sub, int mul, int div){
        if (i == N){
            ansmax = Math.max(ansmax, n);
            ansmin = Math.min(ansmin, n);
        }
        if (add > 0){
            calc(n + num[i], i+1, add-1, sub, mul, div);
        }
        if (sub > 0){
            calc(n- num[i], i+1, add, sub-1, mul, div);
        }
        if (mul > 0){
            calc(n * num[i], i+1, add, sub, mul-1, div);
        }
        if (div > 0){
            calc(n / num[i], i+1, add, sub, mul, div-1);
        }
    }

}
