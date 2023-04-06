import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SWE_2382 {

    static class Node{
        int num, dir;

        public Node(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", dir=" + dir +
                    '}';
        }
    }
    static int N, M, K;
    static Node[][] map;
    static List<Node>[][] temp;
    static int ans;
    static final StringBuilder sb = new StringBuilder();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0 ,0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] nmk = br.readLine().split(" ");
            N = Integer.parseInt(nmk[0]);
            M = Integer.parseInt(nmk[1]);
            K = Integer.parseInt(nmk[2]);

            map = new Node[N+1][N+1];
            tempInit();

            for(int k = 0; k < K; k++){
                String[] groups = br.readLine().split(" ");
                int n = Integer.parseInt(groups[0]);
                int m = Integer.parseInt(groups[1]);
                int num = Integer.parseInt(groups[2]);
                int dir = Integer.parseInt(groups[3])-1; //0 1 2 3
                map[n][m] = new Node(num, dir);
            }

            for(int m = 0; m < M; m++){
                //1시간마다
                tempInit();
                move();
                sumOne();
                tempToMap();
                //System.out.println("#### "+(m+1)+"시간 경과!!");
                //print();
            }

            ans = countMisang();
            sb.append("#"+t+" "+ans+"\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void print(){
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < N+1; j++){
                if (map[i][j] != null){
                    System.out.print(map[i][j].toString()+" ");
                }
                else{
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    private static void sumOne() {
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < N+1; j++){
                if (temp[i][j].size() > 1){
                    int sum =0;
                    int b = 0;
                    int dir = -1;
                    for(int t = 0; t < temp[i][j].size(); t++){
                        if (b < temp[i][j].get(t).num){
                            dir = temp[i][j].get(t).dir;
                            b = temp[i][j].get(t).num;
                        }
                        sum += temp[i][j].get(t).num;
                    }
                    temp[i][j].clear();
                    temp[i][j].add(new Node(sum, dir));
                }
            }
        }
    }

    private static void tempInit() {
        temp = new List[N+1][N+1];

        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < N+1; j++){
                temp[i][j] = new ArrayList<>();
            }
        }
    }

    private static void move() {
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < N+1; j++){
                if (map[i][j] != null){
                    boolean flag = false;
                    int d = map[i][j].dir;

                    int num = map[i][j].num;
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    //System.out.println(d+" "+nx+" "+ny);
                    if (nx == 0 || ny == 0 || nx == N-1 || ny == N-1){
                        //끝점으로 간거임 -> 방향전환
                        if (d == 0 || d == 1){
                            d = (1 - d);
                        }
                        else{
                            d = d == 2 ? 3 : 2;
                        }
                        //미생물 죽음
                        num = num / 2;
                        if (num == 0){
                            flag = true;
                        }
                    }
                    if (!flag){
                        temp[nx][ny].add(new Node(num, d));
                    }
                }
            }
        }
    }

    private static void tempToMap() {
        map = new Node[N+1][N+1];
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < N+1; j++){
                if (temp[i][j].size() != 0){
                    map[i][j] = new Node(temp[i][j].get(0).num, temp[i][j].get(0).dir);
                }
            }
        }
    }

    private static int countMisang() {
        int cnt =0;
        for(int i = 0; i < N+1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (map[i][j] != null){
                    cnt += map[i][j].num;
                }
            }
        }
        return cnt;
    }
}
