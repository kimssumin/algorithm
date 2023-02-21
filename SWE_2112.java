import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWE_2112 {
    static int D, W, K;
    static int[][] map;
    static int[][] copymap;
    static int[] drug;
    static int[] selectDrug;
    static int[] row;
    static int ans;
    static int[] p = {0, 1};
    static boolean flag=  false;
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] inputStr = br.readLine().split(" ");
            D = Integer.parseInt(inputStr[0]);
            W = Integer.parseInt(inputStr[1]);
            K = Integer.parseInt(inputStr[2]);
            map = new int[D][W];
            copymap = new int[D][W];
            row = new int[D];
            ans = 0;
            flag = false;
            for(int i = 0; i < D; i++){
                row[i] = i;
            }
            for (int i = 0; i < D; i++) {
                String[] in = br.readLine().split(" ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(in[j]);
                    copymap[i][j] = map[i][j];
                }
            }

            if(checkTest()){
                ans = 0;
            }
            else{
                for(int i = 1; i < K+1; i++){
                    drug = new int[i];
                    selectDrug = new int[i];
                    combi(0,0,i);
                    if(flag){
                        ans = i;
                        break;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }

    private static void init(){
        for (int i = 0 ; i < D; i++){
            for (int j = 0; j < W; j++) {
                copymap[i][j] = map[i][j];
            }
        }
    }
    private static boolean checkTest() {
        int tc = 0;
        for(int i = 0; i < W; i++) {
            for (int j = 0; j <= D-K; j++) {
                int cnt = 0;
                for (int k = j; k < j+K; k++) {
                    cnt += copymap[k][i];
                }
                if (cnt == K || cnt == 0) {
                    tc += 1;
                    break;
                }
            }

        }
        if (tc == W){
            return true;
        }
        return false;
    }

    private static void combi(int cnt, int start, int r) {
        //끝나는 조건 명시
        if (cnt == r) {
            init();
            piperm(0, r, drug);
            return;
        }
        //그렇지않으면
        for (int i = start; i < D; i++) {
            drug[cnt] = row[i];
            combi(cnt+1, i+1, r);
        }
    }

    private static void piperm(int cnt, int r, int[] drug) {

        //끝나는 조건 명시
        if (cnt == r) {
            for(int i = 0; i < r; i++){
                Arrays.fill(copymap[drug[i]], selectDrug[i]);
            }
            if (checkTest()){
                flag = true;
                return;
            }
            return;
        }

        //그렇지않으면
        for (int i = 0; i < 2; i++) {
            selectDrug[cnt] = p[i];
            piperm(cnt+1, r, drug);
        }

    }
}
