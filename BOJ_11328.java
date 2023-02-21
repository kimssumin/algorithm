import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        long sum = Long.parseLong(inputStr[0]) + Long.parseLong(inputStr[1])+ Long.parseLong(inputStr[2]);
        System.out.println(sum);

        br.close();
    }
}
