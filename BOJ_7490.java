import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7490 {
    static int [] nums;
    static final StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            nums = new int[N];
            for(int i = 1; i < N+1; i++){
                nums[i-1] = i;
            }
            getCalc(nums[0], nums[0], 1, Integer.toString(nums[0]));
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void getCalc(int prev, int sum, int idx, String s) {
        //System.out.println("prev = "+prev+"\ts = "+s+"\tsum = "+sum);
        if (idx == N){
            if (sum == 0){
                sb.append(s).append("\n");
                //System.out.println(s);
                return;
            }
            return;
        }



        if (prev < 0){
            getCalc((prev*10) - nums[idx],sum - prev + (prev*10) - nums[idx] , idx + 1, s +" "+nums[idx]);
        }
        else{
            getCalc((prev*10) + nums[idx],sum - prev + (prev*10) + nums[idx] , idx + 1, s +" "+nums[idx]);
        }
        getCalc(nums[idx], sum + nums[idx] , idx + 1, s +"+"+nums[idx]);
        getCalc(-nums[idx],sum - nums[idx] , idx + 1, s +"-"+nums[idx]);

    }
}
