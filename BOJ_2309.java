import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2309 {
    static List<Integer> child = new ArrayList<>();
    static int[] ans = new int[7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum_init = 0;
        for (int i = 0; i < 9; i++){
            int val =Integer.parseInt(br.readLine());
            sum_init += val;
            child.add(val);
        }

        int total = sum_init;
        aa : for (int i = 0; i < 9; i++){
            for (int j = i+1; j < 9; j++){
                if (100 == total - (child.get(i) + child.get(j))){
                    int n1 = child.get(i);
                    int n2 = child.get(j);

                    child.remove(Integer.valueOf(n1));
                    child.remove(Integer.valueOf(n2));

                    for (int k = 0 ;k < 7; k++){
                        ans[k] = child.get(k);
                    }

                    Arrays.sort(ans);
                    for (int a : ans){
                        System.out.println(a);
                    }
                    break aa;
                }
            }
        }



        br.close();
    }
}
