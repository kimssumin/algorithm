import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2475 {

    static int[] num = new int[5];
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        for (int i = 0; i < 5; i++) {
            num[i] = Integer.parseInt(inputStr[i]);
            ans += (num[i]*num[i]);
        }
        System.out.println(ans%10);
        br.close();
    }
}
