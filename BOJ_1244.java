import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1244 {
    static int n;
    static int [] nowSwitch;
    static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] inputStr = br.readLine().split(" ");
        nowSwitch = new int[n];
        for(int i = 0; i < n; i++){
            nowSwitch[i] = Integer.parseInt(inputStr[i]);
        }

        int total = Integer.parseInt(br.readLine());
        for (int i = 0; i < total; i++) {
            String[] inputStr2 = br.readLine().split(" ");
            if (Integer.parseInt(inputStr2[0]) == 1){
                int bn = Integer.parseInt(inputStr2[1]);
                //boyNum.add(bn);
                boyDo(bn);
            }
            else{
                int gn = Integer.parseInt(inputStr2[1]);
                //girlNum.add(gn);
                girlDo(gn);
            }
        }
        for(int i=0;i<n;i++) {
            System.out.print(nowSwitch[i]+" ");
            if((i+1) % 20 == 0) {
                System.out.println();
            }
        }


        br.close();
    }

    private static void girlDo(int gn) {
        int cnt = 0;
        gn = gn-1;
        for (int i = 1; i < Math.min(gn+1, n-gn); i++){
            if (nowSwitch[(gn-i)] == nowSwitch[(gn+i)]){
                cnt += 1;
            }
            else{
                break;
            }
        }
        nowSwitch[gn] = Math.abs(nowSwitch[gn] - 1);
        for (int i = 1; i < cnt+1; i++){
            nowSwitch[gn-i] = Math.abs(nowSwitch[gn-i] - 1);
            nowSwitch[gn+i] = Math.abs(nowSwitch[gn+i] - 1);
        }
        //System.out.println(Arrays.toString(nowSwitch));
    }

    private static void boyDo(int bn) {
        for (int i = bn-1; i < n; i+=bn){
            nowSwitch[i] = Math.abs(nowSwitch[i] - 1);
        }
        //System.out.println(Arrays.toString(nowSwitch));
    }
}
