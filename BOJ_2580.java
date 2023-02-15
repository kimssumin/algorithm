import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2580 {
    static final StringBuilder sb = new StringBuilder();
    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] inputStr = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        sudoku(0, 0);

        br.close();
    }

    private static void sudoku(int r, int c) {
        if (c == 9){
            sudoku(r+1, 0);
            return;
        }
        if (r == 9){
            printMap();
            System.exit(0);
            return;
        }
        if (map[r][c] == 0){
            for(int i = 1; i <= 9; i++){
                if (isPossible(r,c,i)){
                    map[r][c] = i;
                    sudoku(r, c+1);
                }
            }
            map[r][c] = 0;
            return;
        }

        sudoku(r, c+1);
    }

    private static void printMap() {
        for(int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static boolean isPossible(int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == value) {
                return false;
            }
        }
        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;
        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
