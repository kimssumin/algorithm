import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1759 {
    static int n;
    static int m;
    static String[] letters;
    static List<String> ml = new ArrayList<>(Arrays.asList(new String[]{"a", "e", "i", "o", "u"}));
    static String[] sl ;
    static boolean[] visited;

    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");


        n = Integer.parseInt(inputStr[0]);
        m = Integer.parseInt(inputStr[1]);

        letters = br.readLine().split(" ");
        Arrays.sort(letters);
        sl = new String[n];
        visited = new boolean[m];

        combi(0, 0);

        for (String answer : ans){
            System.out.println(answer);
        }
        br.close();
    }

    private static void combi(int cnt, int start) {
        if(cnt == n) {
            if (check(sl)){
                String temp = "";
                for (String sss : sl){
                    temp += sss;
                }
                ans.add(temp);
                
            }
            return;

        }
        for (int i = start; i < m; i++) {
            //start 가 중요함!
            visited[i] = true;
            sl[cnt] = letters[i];
            combi(cnt+1, i+1);
            visited[i] = false;
            //backtracking
        }

    }

    private static boolean check(String[] sl) {

        int cnt = 0;
        boolean check = false;
        for (String s : sl){
            if (ml.contains(s)){
                cnt += 1;
            }
        }
        if (cnt >= 1 && n - cnt >= 2){
            return true;
        }

        return check;
    }
}
