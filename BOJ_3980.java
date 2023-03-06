import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3980 {

    static int [][] map;
    static boolean[] visited;
    static int[] nums;
    static final StringBuilder sb = new StringBuilder();
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        for (int c = 0; c < C; c++) {
            map = new int[11][11];
            visited = new boolean[11];
            nums = new int[11];
            ans = 0;
            for (int i = 0; i < 11; i++) {
                String[] inputStr = br.readLine().split(" ");
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(inputStr[j]);
                }
            }
            getPosition(0);
            sb.append(ans).append("\n");

        }
        System.out.print(sb);
        br.close();
    }

    private static void getPosition(int cnt) {
        if (cnt == 11){
            ans = Math.max(ans, checkSum(nums));
            return;
        }
        for(int i = 0; i < 11; i++){
            if (!visited[i] && map[i][cnt] != 0){
                visited[i] = true;
                nums[cnt] = i; //cnt번 포지션. i번 선수
                getPosition(cnt+1);
                visited[i] = false;
            }
        }
    }

    private static int checkSum(int[] nums) {
        int sum = 0;
        for(int n = 0; n < 11; n++){
            sum += map[nums[n]][n];
        }
        return sum;
    }
}
