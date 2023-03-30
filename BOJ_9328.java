import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9328 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static boolean[] key;
    static ArrayList<Node>[] door;
    static boolean[][] visited;
    static int H;
    static int W;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans;
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] inputMap = br.readLine().split(" ");

            H = Integer.parseInt(inputMap[0]);
            W = Integer.parseInt(inputMap[1]);

            map = new char[H + 2][W + 2];
            visited = new boolean[H + 2][W + 2];
            key = new boolean[26];
            door = new ArrayList[26];

            ans = 0;

            for (int i = 0; i < 26; i++) {
                door[i] = new ArrayList<>();
            }

            for (int i = 0; i < H + 2; i++) {
                for (int j = 0; j < W + 2; j++) {
                    map[i][j] = '.';
                }
            }

            for (int i = 1; i <= H; i++) {
                String input = br.readLine();
                for (int j = 1; j <= W; j++) {
                    map[i][j] = input.charAt(j - 1);
                }
            }

            String initKey = br.readLine();
            if (!initKey.equals("0")) {
                for (int i = 0; i < initKey.length(); i++) {
                    int temp = initKey.charAt(i) - 'a';
                    key[temp] = true;
                }
            }

            bfs();
            sb.append(ans + "\n");

        }
        System.out.print(sb);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!canGo(nx, ny)){
                    continue;
                }

                int val = map[nx][ny];
                if (val - 'A' >= 0 && val - 'A' < 26) {
                    if (key[val - 'A']) { //키가 있으면
                        map[nx][ny] = '.';
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    }
                    else {
                        door[val - 'A'].add(new Node(nx, ny));
                    }
                }

                else if (val - 'a' >= 0 && val - 'a' < 26) {
                    // 열쇠 발견
                    key[val - 'a'] = true;
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));

                    for (int j = 0; j < 26; j++) {
                        if (door[j].size() != 0 && key[j]) {
                            for (int z = 0; z < door[j].size(); z++) {
                                Node temp = door[j].get(z);
                                map[temp.x][temp.y] = '.';
                                visited[temp.x][temp.y] = true;
                                q.add(new Node(temp.x, temp.y));
                            }
                        }
                    }
                }

                else if (val == '.'){
                    // 빈 공간
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }

                else if (val == '$') {
                    ans++;
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }

            }
        }
    }

    private static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny) || visited[nx][ny]) {
            return false;
        }

        if (map[nx][ny] == '*') {
            return false;
        }
        return true;
    }


    private static boolean inRange(int nx, int ny) {
        return nx >=0 && ny >= 0 && nx < H + 2 && ny < W + 2;
    }


}