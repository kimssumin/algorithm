import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15651 {
    static int N;
    static int M;
    static int[] p;
    static int[] nums;
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        N = Integer.parseInt(inputStr[0]);
        M = Integer.parseInt(inputStr[1]);
        p = new int[N];
        nums = new int[M];
        for(int i = 1; i <= N; i++){
            p[i-1] = i;
        }
        perm(0, 0);
        System.out.print(sb);
        br.close();
    }

    private static void perm(int cnt, int flag) {
        if (cnt == M){
            for(int i = 0; i < nums.length; i++){
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            nums[cnt] = p[i];
            perm(cnt+1, (flag | (1<<i))); //1을 이동
        }
    }

}
