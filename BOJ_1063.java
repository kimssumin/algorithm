import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1063 {

    static class Node{
        int c;
        int r;

        public Node(int c, int r) {
            this.c = c;
            this.r = r;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "c=" + c +
                    ", r=" + r +
                    '}';
        }
    }
    static Node K;
    static Node S;

    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int N;
    static String[] mv = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        N = Integer.parseInt(inputStr[2]);
        K = new Node(8 - Integer.parseInt(inputStr[0].split("")[1]) , inputStr[0].charAt(0)- 'A');
        S = new Node(8 - Integer.parseInt(inputStr[1].split("")[1]), inputStr[1].charAt(0)- 'A');

        for (int i = 0; i < N; i++) {
            String in= br.readLine();
            for(int j = 0; j < 8; j++){
                if (mv[j].equals(in)){
                    int nc = K.c + dx[j];
                    int nr = K.r + dy[j];

                    if (!inRange(nc, nr)){
                        break;
                    }

                    if (nc == S.c && nr == S.r){
                        int sc = S.c + dx[j];
                        int sr = S.r + dy[j];
                        if (!inRange(sc, sr)){
                            break;
                        }
                        S = new Node(sc, sr);
                    }

                    K = new Node(nc, nr);
                }
            }
        }

        System.out.println((char)(K.r+65)+""+(8-K.c));
        System.out.println((char)(S.r+65)+""+(8-S.c));
        br.close();

    }

    private static boolean inRange(int nc, int nr) {
        return nc >= 0 && nc < 8 && nr >= 0 && nr < 8;
    }
}
