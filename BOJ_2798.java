import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2798 {
    static int n;
    static int m;
    static int[] cardlst;
    static boolean[] visited;
    static int ans;
    static int[] nums = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        n = Integer.parseInt(inputStr[0]);
        m = Integer.parseInt(inputStr[1]);
        String[] cardStr = br.readLine().split(" ");
        cardlst = new int[n];
        for (int i = 0; i < n; i++){
            cardlst[i] = Integer.parseInt(cardStr[i]);
        }
        visited = new boolean[n];
        combi(0, 0);
        System.out.println(ans);
        br.close();
    }

    private static void combi(int cnt, int start) {
        if(cnt == 3) {
            if (sum(nums) <= m){
                ans = Math.max(ans, sum(nums));
            }
            return;
        }
        for (int i = start; i < n; i++) {
            //start 가 중요함!
            visited[i] = true;
            nums[cnt] = cardlst[i];
            combi(cnt+1, i+1);
            nums[cnt] = 0;
            visited[i] = false;
            //backtracking
        }

    }

    private static int sum(int[] nums){
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        return sum;
    }
}
