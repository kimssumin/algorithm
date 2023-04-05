import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16987_2 {

    static int N;
    static class Node{
        int strong, weight;

        public Node(int strong, int weight) {
            this.strong = strong;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "strong=" + strong +
                    ", weight=" + weight +
                    '}';
        }
    }
    static Node[] egg ;
    static boolean[] broke;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        egg = new Node[N];
        broke = new boolean[N];
        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            egg[i] = new Node(Integer.parseInt(inputStr[0]), Integer.parseInt(inputStr[1]));
        }

        dfs(0);


        System.out.println(ans);
        br.close();
    }

    private static void dfs(int i) {
        if (i == N){
            //System.out.println(Arrays.toString(egg));
            ans = Math.max(ans, getBreakCnt());
            return;
        }
        for(int a = 0; a < N; a++){
            if (a == i){
                continue;
            }
            if (eggBreak(i, a)){
                egg[i].strong -= egg[a].weight;
                egg[a].strong -= egg[i].weight;
                dfs(i+1);
                egg[i].strong += egg[a].weight;
                egg[a].strong += egg[i].weight;
            }
            else{
                dfs(i+1);
            }
        }
    }

    private static boolean eggBreak(int i, int j) {
        if (egg[i].strong <= 0 || egg[j].strong <= 0){
            return false;
        }
        return true;
    }

    private static int getBreakCnt() {
        int sum = 0;
        for(int i = 0; i < N; i++){
            if ( egg[i].strong <= 0){
                sum ++;
            }
        }
        return sum;
    }
}
