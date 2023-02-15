import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286 {
    static int[] input;
    static PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
        int abs1 = Math.abs(o1);
        int abs2 = Math.abs(o2);

        if(abs1 == abs2) return o1 > o2 ? 1 : -1;
        return abs1 - abs2;
    });
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        for(int i : input) {
            if (i == 0) {
                //절댓값 가장 작은 값 출력
                if(q.isEmpty()) {
                    sb.append(0+"\n");
                }
                else {
                    sb.append(q.poll()+"\n");
                }

            }
            else {
                //추가
                q.add(i);
            }
        }

        System.out.println(sb);
        br.close();
    }
}
