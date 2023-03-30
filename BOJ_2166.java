import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2166 {

    static Long[] x;
    static Long[] y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        x = new Long[n+1];
        y = new Long[n+1];
        double answer;
        for (int i = 0; i < n; i++) {
            String[] inputStr = br.readLine().split(" ");
            x[i] = Long.parseLong(inputStr[0]);
            y[i] = Long.parseLong(inputStr[1]);
        }
        x[n] = x[0];
        y[n] = y[0];

        double sum = 0.0;
        double sum2 = 0.0;
        for(int i = 0; i < n; i++){
            sum += (x[i] * y[i+1]);
        }for(int i = 0; i < n; i++){
            sum2 += (y[i] * x[i+1]);
        }
        //System.out.println(sum+" "+sum2);
        answer = Math.abs((sum - sum2)) / 2.0;
        System.out.println(String.format("%.1f",answer));
        br.close();
    }
}
