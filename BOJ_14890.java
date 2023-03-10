import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14890 {
    static int N, L;
    static int [][] map;

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nl = br.readLine().split(" ");
        N = Integer.parseInt(nl[0]);
        L = Integer.parseInt(nl[1]);
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        for(int i = 0; i < N; i++){
            if (checkRow(i)){
                ans += 1;
            }
            if (checkCol(i)){
                ans += 1;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static boolean checkCol(int col) {
        int prev = map[0][col];
        boolean[] stair = new boolean[N];
        int d= 0;
        for(int row = 1; row < N; row++){
            if (Math.abs(prev - map[row][col]) > 1) {
                return false;
            }
            if (prev != map[row][col]){
                d = prev - map[row][col];
                break;
            }
            prev = map[row][col];
        }
        if (d == 0){
            return true;
        }
        if (L == 1){

            prev = map[0][col];
            for(int row = 0; row < N; row++) {
                if (Math.abs(prev - map[row][col]) > 1) {
                    return false;
                }
                prev = map[row][col];
            }
            String temp = "";
            for(int j = 0; j < N-1; j++){
                temp += ("*"+Integer.toString(map[j][col] - map[j+1][col])+"*");
            }
            //System.out.println(temp);
            if (temp.contains("*1**-1*")){ //temp.contains("*-1**1*") ||
                return false;
            }
//            }
//            System.out.println(d);
//            for(int i = 0; i < N ; i++){
//                System.out.print(map[i][col] + " ");
//            }
//            System.out.println();
            return true;
        }

        prev = map[0][col];
        for(int row = 0; row < N; row++){
            if (Math.abs(prev - map[row][col]) > 1){
                return false;
            }
            if (Math.abs(prev - map[row][col]) == 1){
                if (prev < map[row][col]){
                    stair[row-1] = true;
                    boolean flag = true;
                    for(int k = 1; k < L; k++){
                        if (row -1 - k < 0 || stair[row-1-k]){
                            flag = false;
                            break;
                        }
                        if (map[row-1][col] != map[row-1-k][col]){
                            flag = false;
                        }
                        stair[row-1-k] = true;
                    }
                    if (!flag){
                        return false;
                    }
                }
                else{
                    boolean flag = true;
                    stair[row] = true;
                    for(int k = 1; k < L; k++){
                        if (row + k >= N){
                            flag = false;
                            break;
                        }
                        if (map[row][col] != map[row+k][col]){
                            flag = false;
                        }
                        stair[row+k] = true;
                    }
                    if (!flag){
                        return false;
                    }
                }


            }
            prev = map[row][col];
        }
//        for(int i = 0; i < N ; i++){
//            System.out.print(map[i][col] + " ");
//        }
//        System.out.println();
        return true;
    }

    private static boolean checkRow(int row) {
        int prev = map[row][0];
        boolean[] stair = new boolean[N];
        int d= 0;
        for(int col = 1; col < N; col++){
            if (Math.abs(prev - map[row][col]) > 1) {
                return false;
            }
            if (prev != map[row][col]){
                d = prev - map[row][col];
                break;
            }
            prev = map[row][col];
        }
        if (d == 0){
            return true;
        }

        if (L == 1){
            prev = map[row][0];
            for(int col = 0; col < N; col++) {
                if (Math.abs(prev - map[row][col]) > 1) {
                    return false;
                }
                prev = map[row][col];
            }
            String temp = "";
            for(int j = 0; j < N-1; j++){
                temp += ("*"+Integer.toString(map[row][j] - map[row][j+1])+"*");
            }
            if (temp.contains("*1**-1*")){ //temp.contains("*-1**1*") ||
                return false;
            }
            //System.out.println(Arrays.toString(map[row]));
            return true;
        }

        prev = map[row][0];
        for(int col = 0; col < N; col++){
            if (Math.abs(prev - map[row][col]) > 1){
                return false;
            }
            if (Math.abs(prev - map[row][col]) == 1){
                if (prev < map[row][col]){
                    stair[col-1] = true;
                    boolean flag = true;
                    for(int k = 1; k < L; k++){
                        if (col -1 - k < 0 || stair[col-1-k]){
                            flag = false;
                            break;
                        }
                        if (map[row][col-1] != map[row][col-1-k]){
                            flag = false;
                        }
                        stair[col-1-k] = true;
                    }
                    if (!flag){
                        return false;
                    }
                }
                else{
                    boolean flag = true;
                    stair[col] = true;
                    for(int k = 1; k < L; k++){
                        if (col + k >= N){
                            flag = false;
                            break;
                        }
                        if (map[row][col] != map[row][col+k]){
                            flag = false;
                        }
                        stair[col+k] = true;
                    }
                    if (!flag){
                        return false;
                    }
                }


            }
            prev = map[row][col];
        }
//        System.out.println(Arrays.toString(map[row]));
        return true;
    }
}
