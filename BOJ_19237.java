import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_19237 {

    static int [] dx = {1, 0, -1, 0}; //아래 왼 위 오
    static int [] dy = {0, -1, 0, 1};
    static Map<Integer, int[][]> sharkDir = new HashMap<>();
    static int[][] dir = new int[4][4];
    static int N, M, K;
    static int[][] map;

    static int ans;
    public static void main(String[] args) throws IOException {

        dir = new int[][] {{0, 1, 2, 3}, {3, 2, 0, 1}, {1, 3, 0, 2}, {3, 1, 2, 0}};
        sharkDir.put(1, dir);
        dir = new int[][] {{0, 3, 1, 2}, {0, 2, 1, 3}, {1, 3, 2, 0}, {3, 2, 0, 1}};
        sharkDir.put(2, dir);
        dir = new int[][] {{3, 1, 0, 2}, {2, 3, 1, 0}, {2, 1, 0, 3}, {1, 0, 2, 3}};
        sharkDir.put(3, dir);
        dir = new int[][] {{1, 3, 2, 0}, {1, 0, 3, 2}, {2, 3, 0, 1}, {2, 3, 0, 1}};
        sharkDir.put(4, dir);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmk = br.readLine().split(" ");
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
        }

        br.close();
    }
}
