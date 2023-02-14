import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_1873 {
    static int H;
    static int W;
    static String[][] map;
    static int N;
    static String[] letter;
    static int[] now = {0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] hw = br.readLine().split(" ");
            H = Integer.parseInt(hw[0]);
            W = Integer.parseInt(hw[1]);

            map = new String[H][W];
            now = new int[]{0, 0};

            for (int i = 0; i < H; i++) {
                String[] mm = br.readLine().split("");
                for (int j = 0; j < W; j++) {
                    map[i][j] = mm[j];
                    if (map[i][j].equals("^") || map[i][j].equals("v") || map[i][j].equals("<") || map[i][j].equals(">")) {
                        now[0] = i;
                        now[1] = j;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            letter = br.readLine().split("");

            game();

            System.out.print("#" + t + " ");
            printMap();
        }

        br.close();
    }

    private static void game() {
        for(String L : letter){
            switch(L){
                case "U":
                    move("^",now[0]-1, now[1]);
                    break;
                case "D":
                    move("v",now[0]+1, now[1]);
                    break;
                case "L":
                    move("<",now[0], now[1]-1);
                    break;
                case "R" :
                    move(">",now[0], now[1]+1);
                    break;
                case "S" :
                    shoot();
                    break;
            }
        }

    }

    private static void shoot() {
        switch (map[now[0]][now[1]]){
            case "^":
                if (now[0] -1 >= 0){
                    for (int i = now[0]-1; i >= 0; i--){
                        if (strongCheck(i, now[1])){
                            break;
                        }
                        if (normalCheck(i, now[1])){
                            map[i][now[1]] = ".";
                            break;
                        }
                    }
                }
                break;
            case "v":
                if (now[0] +1 < H){
                    for (int i = now[0]+1 ; i < H; i++){
                        if (strongCheck(i, now[1])){
                            break;
                        }
                        if (normalCheck(i, now[1])){
                            map[i][now[1]] = ".";
                            break;
                        }
                    }
                }
                break;
            case ">":
                if (now[1] +1 < W){
                    for (int i = now[1]+1; i < W; i++){
                        if (strongCheck(now[0], i)){
                            break;
                        }
                        if (normalCheck(now[0], i)){
                            map[now[0]][i] = ".";
                            break;
                        }
                    }
                }
                break;
            case "<" :
                if (now[1] - 1 >= 0){
                    for (int i = now[1]-1; i >= 0; i--){
                        if (strongCheck(now[0], i)){
                            break;
                        }
                        if (normalCheck(now[0], i)){
                            map[now[0]][i] = ".";
                            break;
                        }
                    }
                }
                break;
        }
    }

    private static boolean normalCheck(int x, int y) {
        return map[x][y].equals("*");
    }

    private static boolean strongCheck(int x, int y) {
        return map[x][y].equals("#");
    }


    private static void move(String arrow, int dx, int dy){
        map[now[0]][now[1]] = arrow;
        if (inRange(dx, dy) && map[dx][dy].equals(".")){
            map[dx][dy] = arrow;
            map[now[0]][now[1]] = ".";
            now[0] = dx;
            now[1] = dy;
        }
    }

    private static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < H && ny >= 0 && ny < W);
    }


    private static void printMap() {
        for(String[] s : map){
            for(String x : s){
                System.out.print(x);
            }
            System.out.println();
        }
    }
}
