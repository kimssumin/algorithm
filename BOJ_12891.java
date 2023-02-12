import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_12891 {
    static int S;
    static int P;
    static String[] DNA;
    static int[] Base = new int[4];
    static Map<String, Integer> idx = new HashMap<>();

    static int[] res = new int[4];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        idx.put("A", 0);
        idx.put("C", 1);
        idx.put("G", 2);
        idx.put("T", 3);

        S = Integer.parseInt(sp[0]);
        P = Integer.parseInt(sp[1]);
        DNA = br.readLine().split("");

        String[] inputStr = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            Base[i] = Integer.parseInt(inputStr[i]);
        }
        int cnt = 0;
        for (int i = 0; i < S - P + 1; i++){
            boolean check = true;
            if (i == 0){
                //기준점
                for (int j = 0; j < P; j++){
                    res[idx.get(DNA[j])] += 1;
                }
            }
            else{
                res[idx.get(DNA[i+P-1])] += 1; // 오른쪽으로 하나 up
                res[idx.get(DNA[i-1])] -= 1; //왼쪽으로 하나 down
            }

            for (int k = 0; k < 4; k++){
                if (res[k] < Base[k]){
                    check = false;
                    break;
                }
            }
            if (check){
                cnt += 1;
            }
        }

        System.out.println(cnt);
        br.close();
    }

}
