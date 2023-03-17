import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20055 {

    static int N, K;
    static boolean[] robot;
    static int[] strong;
    static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);
        robot = new boolean[N];
        strong = new int[2*N];
        String[] inputStr = br.readLine().split(" ");
        for (int i = 0; i< 2*N; i++) {
            strong[i] =  Integer.parseInt(inputStr[i]);
        }

        while (breakCheck()) {
            int temp = strong[strong.length - 1];
            for (int i = strong.length - 1; i > 0; i--) {
                strong[i] = strong[i - 1];
            }
            strong[0] = temp;

            for (int i = robot.length - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;

            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && strong[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    strong[i]--;
                }
            }

            if (strong[0] > 0) {
                robot[0] = true;
                strong[0]--;
            }

            ans++;
        }

        System.out.println(ans-1);
        br.close();
    }
    public static boolean breakCheck() {
        int cnt = 0;
        for (int i = 0; i < strong.length; i++) {
            if (strong[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }
}
