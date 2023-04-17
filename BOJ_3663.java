import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_3663 {

    static boolean[] visited;
    static int N;
    static int[] p;
    static int answer ;
    static int minmove;
    static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            N = arr.length;
            minmove = N - 1;
            answer = 0;
            for (int c = 0; c < N; c++) {
                int updown = Math.min(arr[c] - 'A', 'Z' - arr[c] + 1);
                answer += updown;

                int next = c + 1;
                while (next < N && arr[next] == 'A') {
                    next += 1;
                }
                minmove = Math.min(minmove, 2 * c + (N - next));
                minmove = Math.min(minmove, c + (2 * (N - next)));
            }
            answer += minmove;
            sb.append(answer +"\n");
        }
        System.out.print(sb);
        br.close();
    }


}