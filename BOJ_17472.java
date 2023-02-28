package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_17472 {

    static public class Node {
        int x;
        int y;
        int move;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int move){
            this.x= x;
            this.y = y;
            this.move = move;
        }
    }

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int dist;

        public Edge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge e) {

            return Integer.compare(this.dist, e.dist);
        } //ascending

    }
    static int N;
    static int M;
    static int num;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] checked;

    static Queue<Node> q = new LinkedList<>();
    static PriorityQueue<Edge> qq = new PriorityQueue<Edge>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[] p;
    static int[] r;
    
    static int ans = Integer.MAX_VALUE;
    static int cnt;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputStr[j]);
            }
        }

        //1. 섬 numbering
        num = 1;
        for(int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j, num);
                    num++;
                }
            }
        }

        //2. 다리 건설
        qq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0){
                	for(int d = 0; d < 4; d++) {
                		int nx = i + dx[d];
                		int ny = j + dy[d];
                		if (inRange(nx, ny) && map[nx][ny] == 0)
                			bridge(i, j, d); }
                	
                }
            }
        }

        //3. 다리 연결
        num -= 1;
        p = new int[num+1];
        makeSet();

        ans = 0;

        while(!qq.isEmpty()) {
            Edge edge = qq.poll(); //최소edge
            if (union(edge.start, edge.end)) {
            	//System.out.println(edge.start+" "+edge.end+" "+edge.dist);
                ans += edge.dist;
                num --;
            }
            
            if (num == 1) {
            	System.out.println(ans);
            	return;
            }
        }
       
        System.out.println(-1);
        
        br.close();
    }
    

    private static boolean union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx == yy) return false;
        
        p[yy] = xx;
        return true;
    }
    
    private static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    private static void makeSet() {
        // TODO Auto-generated method stub
        for(int i = 1; i < num+1; i++) {
            p[i] = i;
        }
    }
    private static void bridge(int x, int y, int d) {
        int now = map[x][y];
        int move = 0;
        while(true){
            int nx = x + dx[d];
            int ny = y + dy[d];
            x = nx;
            y = ny;

			if (inRange(nx, ny)) {
				if (map[nx][ny] != 0) {
					if (move >= 2) {
						//System.out.println(now+" "+map[nx][ny]+" "+move);
						qq.offer(new Edge(now, map[nx][ny], move));
					}
					return;
				}
				move++; //0
				continue;
			}
			break; 
        }
    }

    private static void bfs(int x, int y, int num) {
        map[x][y] = num;
        visited[x][y] = true;
        q.offer(new Node(x, y));
        while(!q.isEmpty()){
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (canGo(nx, ny)){
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = num;
                }
            }


        }
    }

    private static boolean canGo(int nx, int ny) {
        if(!inRange(nx, ny) || visited[nx][ny]){
            return false;
        }
        if (map[nx][ny] != 1){
            return false;
        }
        return true;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
