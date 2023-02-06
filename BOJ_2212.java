import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        String[] inputStr = br.readLine().split(" ");
        int[] area = new int[n];
        for (int i = 0; i < n; i++){
            area[i] = Integer.parseInt(inputStr[i]);
        }
        Arrays.sort(area);
        int[] diff = new int[n-1];
        for (int i = 0; i < n-1; i++){
            diff[i] = area[i+1] - area[i];
        }
        Arrays.sort(diff);

        int sum = 0;
        for (int i = 0; i < n-k; i++) {
            sum += diff[i];
        }
        System.out.println(sum);

        br.close();
    }
}

/*
1 3 6 6 7 9
2 3 0 1 2
0 1 2 2 3

 */