import java.util.Scanner;

public class BOJ_14852 {

    private static final int MOD = 1000000007;
    static long[][] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new long[1000001][2];

        System.out.print(dp(N));
    }

    public static long dp(int x) {

        arr[0][0] = 0;
        arr[1][0] = 2;
        arr[2][0] = 7;
        arr[2][1] = 1; // 두개씩 공유되는 경우

        for(int i = 3; x>= i; i++) {
            arr[i][1] = (arr[i-1][1] + arr[i-3][0]) % MOD;
            arr[i][0] = (2*arr[i-1][0]+3*arr[i-2][0] + 2*arr[i][1]) % MOD;
        }
        return arr[x][0];
    }
}