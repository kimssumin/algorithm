import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1786 {

    static char[] text;
    static char[] pattern;
    static int ans;
    static int[] pi;
    static ArrayList<Integer> idx = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = br.readLine().toCharArray();
        pattern = br.readLine().toCharArray();

        int tl = text.length;
        int pl = pattern.length;
        pi = new int[pl];

        for(int i = 1, j = 0; i < pl; i++){
            while(j > 0 && pattern[j] != pattern[i]){
                j = pi[j-1];
            }
            if (pattern[j] == pattern[i]){
                pi[i] = ++j;
            }
            else{
                pi[i] = 0;
            }
        }

        for(int i = 0, j = 0; i < tl; i++){
            while(j > 0 && pattern[j] != text[i]){
                j = pi[j-1];
            }
            if (pattern[j] == text[i]){
                if (j == pl - 1){
                    idx.add(i - j + 1);
                    ans ++;
                    j = pi[j];
                }
                else{
                    j++;
                }

            }
        }

        System.out.println(Arrays.toString(pi));
        System.out.println(Arrays.toString(idx.toArray()));
        System.out.println(ans);

        br.close();
    }
}
