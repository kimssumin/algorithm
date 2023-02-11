import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178 {
    static int N,M;
    static int[][] board;
    static int[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; //상우하좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        board = new int[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split("");
            for (int j = 0; j < M ; j++) {
                board[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        bfs();
        System.out.println(visit[N-1][M-1]);

        br.close();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visit[0][0] = 1;
        
        //queue가 비지않았으면
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (x==N-1 && y == M-1) return;

            //4방 탐색
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!check(nx, ny)) continue;
                if (board[nx][ny] == 1 && visit[nx][ny] == 0){
                    queue.offer(new int[] {nx, ny});
                    visit[nx][ny] = visit[x][y] + 1;
                }
            }
        }
    }

    private static boolean check(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
