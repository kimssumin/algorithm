import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14726 {
    static int T;
    public static void main(String[] args) {
        Scanner scnn = new Scanner(System.in);
        T = scnn.nextInt();
        for (int i = 0 ; i < T; i++) {
            String card = scnn.next();
            String new_number = new_num(card);
            System.out.println(new_number);
            
        }
    }
    
    public static String new_num(String card) {
        String number = "";
        String[] arr = card.split("");
        int cnt = 0;
        for (int i = arr.length - 1 ; i >= 0 ; i--) {
            cnt += 1;
            if (cnt %2 == 0) {
                int n =Integer.parseInt(arr[i]);
                if ((2*n) >= 10) {
                    arr[i] = Integer.toString(2*n/10 + 2*n%10);
                }
                else {
                    arr[i] =  Integer.toString(2*n);
                }
            }
        }
//        System.out.println(String.join("", arr));
        int sum = 0;
        for (String c : arr) {
            sum += Integer.parseInt(c);
        }
        if (sum % 10 ==0 ) {
            return "T";
        }
        else {
            return "F";
        }
    }
}