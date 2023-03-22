import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_21610 {

    static class Edge{
        int d, s;

        public Edge(int d, int s) {
            this.d = d;
            this.s = s;
        }
    }
    static int N, M;
    static Edge[] move;
    static int[][] map;
    static int[][] cloud;
    static int[][] copycloud;
    static int [] dx= {0, -1, -1, -1, 0, 1, 1, 1};
    static int [] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        map = new int[N][N];
        move = new Edge[M];
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        copycloud = new int[N][N];
        cloud = new int[N][N];
        cloud[N-1][0] = 1;
        cloud[N-2][0] = 1;
        cloud[N-1][1] = 1;
        cloud[N-2][1] = 1;

        for(int i = 0; i < M ; i++){
            String[] in2 = br.readLine().split(" ");
            move[i] = new Edge(Integer.parseInt(in2[0])-1, Integer.parseInt(in2[1]));
        }

        for(int i = 0; i < M; i++){
            game(move[i].d, move[i].s);
            //print(map);
        }

        remainWater();

        System.out.println(ans);
        br.close();
    }

    private static void print(int[][] table) {
        System.out.println("######");
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(table[i]));
        }
        System.out.println();
    }

    private static void copy() {
        for(int i = 0; i < N; i++){
            cloud[i]= copycloud[i].clone();
        }
    }

    private static void game(int d, int s) {
        moveCloud(d, s);
        addWater();
        copyWater();
        getCloud();
        removeOne();
        copy();
        copycloud = new int[N][N];
        //System.out.println("end cloud");
        //print(cloud);
    }

    private static void removeOne() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copycloud[i][j] == 2){
                    copycloud[i][j] = 0;
                }
            }
        }
    }

    private static void getCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2 && copycloud[i][j] != 2){
                    copycloud[i][j] = 1;
                    map[i][j] -= 2;
                }
            }
        }
    }

    private static void copyWater() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N ; j++){
                if (copycloud[i][j] == 2){
                    int cnt =0;
                    int[] ddx = {-1 ,-1, 1, 1};
                    int[] ddy = {-1, 1, -1, 1};
                    for(int d = 0; d < 4; d++){
                        int nx = i + ddx[d];
                        int ny = j + ddy[d];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N){
                            if(map[nx][ny] > 0){
                                cnt ++;
                            }
                        }
                    }
                    map[i][j] += cnt;
                }
            }
        }
    }

    private static void addWater() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copycloud[i][j] == 2){
                    map[i][j] += 1;

                }
            }
        }
    }

    private static void moveCloud(int d, int s) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j] == 1){
                    int nr = (N + i + dx[d] * ((s) % N))%N;
                    int nc = (N + j + (dy[d] * ((s) % N)))%N;
                    //System.out.println(nr + " : "+nc+" : "+i+" : " +j+" : "+s);
                    copycloud[nr][nc] = 2;
                }
            }
        }

        //System.out.println("cloud");
        //print(copycloud);

    }

    private static void remainWater() {
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += map[i][j];
            }
        }
    }
}
