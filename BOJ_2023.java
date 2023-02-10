import java.util.Scanner;

public class BOJ_2023 {
    static int N;
    static int[] first = {2,3,5,7};
    static int[] p = {1,3,7,9};
    static int [] nums ;
    public static void main(String[] args) {
        Scanner scnn = new Scanner(System.in);
        N = scnn.nextInt();
        nums = new int[N-1];

        for (int f : first){
            recursion(f);
        }

    }

    private static void recursion(int f){
        if (Integer.toString(f).length() == N){
            System.out.println(f);
        }
        else {
            for (int i : p) {
                int tmp = f * 10 + i;
                if (isPrime(tmp) == 1) {
                    recursion(tmp);
                }
            }
        }
    }

    public static int isPrime(int n) {
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}

