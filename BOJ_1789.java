import java.io.IOException;
import java.util.Scanner;

public class BOJ_1789 {
    public static void main(String[] args) throws IOException {
        Scanner scnn = new Scanner(System.in);
        long s = scnn.nextLong();
        int m = (int) Math.sqrt(2*s);
        int n = 0;
        for (int i = m; i > 0 ; i--) {
            if ((long) i * (i+1) <= 2*s){
                n = i;
                break;
            }
        }
        System.out.println(n);
    }
}

