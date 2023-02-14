import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_6808 {
    static int[] ku;
    static int[] in;
    static int[] nums;
    static int winCnt;
    static int loseCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            winCnt = 0;
            loseCnt = 0;
            String[] inputStr = br.readLine().split(" ");
            ku = new int[9];
            in = new int[9];
            nums = new int[9];
            for (int i = 0; i < 9; i++){
                ku[i] = Integer.parseInt(inputStr[i]);
            }
            int cnt = 0;
            for (int i = 1; i <= 18; i++){
                boolean check = true;
                for(int k : ku){
                    if (i == k){
                        check = false;
                        break;
                    }
                }
                if (check){
                    in[cnt++] = i;
                }
            }

            perm(0, 0);
            System.out.println("#"+t+" "+winCnt+" "+loseCnt);
        }

        br.close();
    }

    private static void perm(int cnt, int flag) {
        if (cnt == 9){
            switch(win(nums)){
                case -1:
                    loseCnt += 1;
                    break;
                case 0:
                    break;
                case 1:
                    winCnt += 1;
                    break;
            }
            return;
        }
        for(int i = 0; i < 9; i++) {
            if ((flag & (1<<i)) != 0) {
                continue;
            }
            nums[cnt] = in[i];
            perm(cnt+1, (flag | (1<<i))); //1을 이동
        }
    }

    private static int win(int[] nums) {
        int winscore = 0;
        int losescore = 0;
        for(int i = 0; i < 9; i++){
            if (nums[i] < ku[i]){
                winscore += (nums[i] + ku[i]);
            }
            if (nums[i] > ku[i]){
                losescore += (nums[i] + ku[i]);
            }
        }
        if (winscore > losescore){
            return 1;
        }
        else if (winscore == losescore){
            return 0;
        }
        else{
            return -1;
        }
    }
}
