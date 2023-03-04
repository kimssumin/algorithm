package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_17143 {
    static class Shark{
        int r,c,s,d,z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    '}';
        }
    }
    static int R, C, M;
    static List<Shark>[][] map;
    static List<Shark>[][] temp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rcm = br.readLine().split(" ");
        R = Integer.parseInt(rcm[0]);
        C = Integer.parseInt(rcm[1]);
        M = Integer.parseInt(rcm[2]);
        map = new ArrayList[R][C];
        temp = new ArrayList[R][C];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                map[i][j] = new ArrayList<>();
                temp[i][j] = new ArrayList<>();

            }
        }

        for (int i = 0; i < M; i++) {
            String[] inputStr = br.readLine().split(" ");
            int r = Integer.parseInt(inputStr[0]) - 1;
            int c = Integer.parseInt(inputStr[1]) - 1;
            int s = Integer.parseInt(inputStr[2]);
            int d = Integer.parseInt(inputStr[3]);
            int z = Integer.parseInt(inputStr[4]);
            map[r][c].add(new Shark(r, c, s, d, z));
        }

        for(int i = 0; i < C; i ++){
            //낚시왕 이동 횟수
        	int s = getShark(i);
            if (s != -1){
                ans += s;// 가까운 상어를 잡고
            }
            tempClear();
            moveShark();
            //System.out.println("# "+(i+1)+"초 후 : ");
            map = tempCopy();
            //sharkPrint(); //체크용
            
        }
        
        System.out.print(ans);
        br.close();
    }


    private static List<Shark>[][] tempCopy() {
        List<Shark>[][] tmp = new ArrayList[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tmp[i][j] = temp[i][j];
            }
        }
        return tmp;
    }

    private static void tempClear() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp[i][j] = new ArrayList<>();
            }
        }
    }

    private static void sharkPrint() {
        for(int i = 0; i < R; i++){
            for (int j = 0; j < C; j++) {
                if (map[i][j].size() != 0){
                    System.out.println(map[i][j].toString());
                }
            }
        }
        System.out.println();
        System.out.println();
    }


    private static void moveShark() {
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if (map[i][j].size() != 0){
                    //상어가 존재할 때 이동
                    //System.out.println(map[i][j].toString());
                    int dir = map[i][j].get(0).d;
                    int mv = map[i][j].get(0).s; //속력

                    move(i, j, mv, dir);

                }
            }
        }
    }

    private static void move(int i, int j, int mv, int dir) {
        int d = dir-1;
        int x = i;
        int y = j;
        if (exceptCheck(x,y,d)){
            //처음 경우
            if (d == 0 || d == 1){
                //위 아래 검사
                d = Math.abs(1-d);
            }
            else if (d == 2 || d == 3){
                // 좌 우 검사
                d = Math.abs(5-d);
            }
        }

        int size = map[i][j].get(0).z;
        for(int m = 0; m < mv; m++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (m != mv-1){
                if (d == 0 || d == 1){
                    //위 아래 검사
                    if (nx == 0 || nx == R-1){
                        //System.out.println("방향전환");
                        //부딪힌거니까 방향 전환
                        d = Math.abs(1-d);
                    }
                }
                else if (d == 2 || d == 3){
                    // 좌 우 검사
                    if (ny == 0 || ny == C-1){
                        //System.out.println("방향전환");
                        //부딪힌거니까 방향 전환
                        d = Math.abs(5-d);
                    }
                }
            }
            x = nx;
            y = ny;
            //System.out.println(x+" : "+y+" : "+d);
        }
        
    	if (temp[x][y].size() == 1){
            Shark old = temp[x][y].get(0);
            if (old.z < size) {
            	temp[x][y].clear();
            	temp[x][y].add(new Shark(x, y, mv, d+1, size));
            }
          //다 돌면 최종
            
        }
    	else {
    		//다 돌면 최종
            temp[x][y].add(new Shark(x, y, mv, d+1, size));
    	}
        
        //System.out.println("변경완료 : "+temp[x][y].toString()+"\n");
    }

    private static boolean exceptCheck(int x, int y, int d) {
        if (d == 0 && x == 0){
            return true;
        }
        if (d == 1 && x == R-1){
            return true;
        }
        if (d == 2 && y == C-1){
            return true;
        }
        if (d == 3 && y == 0){
            return true;
        }
        return false;
    }

    private static int getShark(int col) {
        for(int i = 0; i < R; i++){
            if (map[i][col].size() != 0){
                //상어있음
            	//System.out.println("***  "+i);
                int shark = map[i][col].get(0).z;
                map[i][col].clear();
                return shark;
            }
        }
        return -1;
    }
}
