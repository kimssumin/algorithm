import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_16500 {
    static int [] dp = new int[101];
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = (br.readLine());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            set.add(tmp);
        }

        for (int i = S.length()-1; i >= 0 ; i--) {
            for (int j = i+1; j < S.length(); j++) {
                if (dp[j] == 1){
                    if (set.contains(S.substring(i, j))){
                        dp[i] = 1;
                    }
                }
            }
            if (set.contains(S.substring(i))){
                dp[i] = 1;
            }
        }

        System.out.println(dp[0]);
        br.close();
    }
}
