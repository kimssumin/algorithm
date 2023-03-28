import java.util.*;

public class BOJ_12852 {
    static int[] dir;
    static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scnn = new Scanner(System.in);
        int X = scnn.nextInt();
        int[] cal = new int[X+1];
        dir = new int[X+1];
        dir[1] = 1;

        for(int i = 2; i <= X ; i++){
            cal[i] = cal[i-1] + 1;
            dir[i] = i-1;
            if (i % 2 == 0){
                if (cal[i] > cal[i/2] + 1){
                    dir[i] = i/2;
                    cal[i] = cal[i/2] + 1;
                }
            }
            if (i % 3 ==0){
                if (cal[i] > cal[i/3] + 1){
                    dir[i] = i/3;
                    cal[i] = cal[i/3] + 1;
                }
            }
        }
        getLink(X);
        System.out.println(cal[X]);
        System.out.println(sb);

    }

    private static void getLink(int num) {
        sb.append(num+" ");
        while(num != 1){
            sb.append(dir[num]+" ");
            num = dir[num];
            //System.out.println(num);
        }
    }
}
