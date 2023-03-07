import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWE_5658 {
    static int N, K;
    static final StringBuilder sb = new StringBuilder();
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T+1; t++) {
            String[] nk = br.readLine().split(" ");
            N = Integer.parseInt(nk[0]);
            K = Integer.parseInt(nk[1]);
            pq = new PriorityQueue<>();

            String inputStr = br.readLine();
            int l = inputStr.length()/4;

            String repeat = inputStr.substring(0, l-1);
            inputStr = inputStr + repeat;
            for(int i = 0; i < l; i++){
                for(int j = 0; j < 4; j++){
                    long num = Long.parseLong(inputStr.substring(i+(l*j), (i+(l*j) + l)), 16);
                    if (!pq.contains(num)){
                        pq.offer(num);
                    }
                }
            }
            //System.out.println(pq.toString());
            int size = pq.size();
            for(int i = 0; i < size - K +1; i++){
                if (i == size - K){
                    sb.append("#").append(t).append(" ").append(pq.poll()).append("\n");
                }
                else{
                    pq.poll();
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}
