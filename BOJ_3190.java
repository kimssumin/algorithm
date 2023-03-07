import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_3190 {

    static int N;
    static int [][] map;
    static int time;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    static Queue<int[]> snake = new LinkedList<>();
    static int[] head = {0, 0};
    static HashMap<Integer, Character> move = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < K; i++) {
            String[] inputStr = br.readLine().split(" ");
            map[Integer.parseInt(inputStr[0])-1][Integer.parseInt(inputStr[1])-1] = 2;
        }
        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++){
            String[] in = br.readLine().split(" ");
            move.put(Integer.parseInt(in[0]), in[1].toCharArray()[0]);
        }

        int d = 0; // 시작은 오른쪽으로
        map[0][0] = 1;
        snake.add(new int[] {0,0});
        while(true){
            time ++;
            if (checkTurn(time-1)){
                //System.out.println(time-1 + " "+move.get(time-1));
                if (move.get(time-1) == 'L'){
                    // 왼쪽으로 90도
                    if (d == 0){
                        d = 3;
                        head[0] = head[0] + dx[d];
                        head[1] = head[1] + dy[d];
                    }
                    else{
                        d -= 1;
                        head[0] = head[0] + dx[d];
                        head[1] = head[1] + dy[d];
                    }
                }
                else{
                    //오른쪽으로 90도
                    d = (d+1) % 4;
                    head[0] = head[0] + dx[d];
                    head[1] = head[1] + dy[d];
                }
            }
            else{
                head[0] = head[0] + dx[d];
                head[1] = head[1] + dy[d];
            }


            if (!canGo()){
                break;
            }
            snake.add(new int[]{head[0], head[1]});
            int value = map[head[0]][head[1]];
            map[head[0]][head[1]] = 1;

            if (!appleCheck(value)){
                //사과가 없다면 꼬리 움직임
                int[] t = snake.poll();
                map[t[0]][t[1]] = 0;
            }

            //System.out.println("#time : "+time);
            //print();
            //System.out.println();
            //time ++;
        }
        System.out.println(time);

        br.close();
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean appleCheck(int value) {
        if (value == 2){
            map[head[0]][head[1]] = 0; // 사과 없애고
            return true;
        }
        return false;
    }

    private static boolean checkTurn(int time) {
        if (move.containsKey(time)){
            return true;
        }
        return false;
    }

    private static boolean canGo() {
        //벽에 부딪히거나
        if (!inRange(head[0],head[1])){
            return false;
        }
        //자기자신과 부딪히거나
        if (map[head[0]][head[1]] == 1){
            return false;
        }
        return true;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
