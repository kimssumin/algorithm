import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2606_bfs {
    static int N;
    static int M;
    static int[][] board;
    static boolean[] visit;
    static int ans;
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        board = new int[N+1][N+1];
        visit = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            String[] inputStr = br.readLine().split(" ");
            int com1 = Integer.parseInt(inputStr[0]);
            int com2 = Integer.parseInt(inputStr[1]);
            board[com1][com2] = 1;
            board[com2][com1] = 1;
        }
        bfs(1);
        br.close();
    }

    private static void bfs(int first) {
        que.offer(first);
        visit[first] = true;

        while(!que.isEmpty()){
            int next = que.poll();
            visit[next] = true;

            for(int i=1;i<N+1;i++)
            {
                if(board[next][i] == 1 && !visit[i])
                {
                    que.offer(i);
                    visit[i] = true;
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
