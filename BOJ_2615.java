import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2615 {

    static int[][] board = new int[21][21];
    static int base;
    static boolean game_fin = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < 20; i++) {
            String[] inputStr = br.readLine().split(" ");
            for (int j = 1; j < 20; j++) {
                board[i][j] = Integer.parseInt(inputStr[j-1]);
            }
        }

        for(int i = 1 ; i < 20; i++){
            for (int j = 1; j < 20; j++){
                if (board[i][j] != 0){
                    base = board[i][j];
                    game(base, i, j);
                    if (game_fin){
                        return;
                    }
                }
            }
        }
        System.out.println(0);


        br.close();
    }

    private static void game(int base, int x, int y) {
        int[] dx = {1, 0, 1, -1};
        int[] dy = {0, 1, 1, 1};

        for (int i = 0; i < 4; i++){
            int tot = 1;
            int new_y = y;
            int new_x = x;
            while(true){
                new_x += dx[i];
                new_y += dy[i];
                if (tot == 1 && beforeDo(new_x, new_y, dx[i], dy[i])){
                    break;
                }
                if(!canGo(new_x, new_y)){
                    break;
                }
                else if (board[new_x][new_y] == base){
                    tot ++;
                    if (tot == 5 && aftercheck(new_x, new_y, dx[i], dy[i])){
                        System.out.println(base);
                        System.out.printf("%d %d", new_x - (4*dx[i]) , new_y - (4*dy[i]));
                        game_fin = true;
                        return;
                    }
                }
            }
        }
    }

    private static boolean aftercheck(int x, int y, int dx, int dy) {
        if (inRange(x+dx, y+dy) && board[x+dx][y+dy] == base){
            return false;
        }
        return true;
    }

    private static boolean beforeDo(int newX, int newY, int dx, int dy) {
        if (inRange(newX-(2*dx), newY-(2*dy))){
            if(board[newX - (2*dx)][newY - (2*dy)] == base){
                return true;
            }
        }
        return false;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < 21 && y >= 0 && y < 21;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y) || board[x][y] != base)
            return false;

        return true;
    }
}
