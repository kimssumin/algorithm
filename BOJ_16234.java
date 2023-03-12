package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_16234 {
	
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	private static final String Queue = null;
	static int N, L, R;
	static int ans;
	static int [][] map ;
	static boolean [][] visited ;
	static List<Node> moveList;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nlr = br.readLine().split(" ");
		N = Integer.parseInt(nlr[0]);
		L = Integer.parseInt(nlr[1]);
		R = Integer.parseInt(nlr[2]);
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] inputStr = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputStr[j]);
			}
		}
		
		peopleMove();
		System.out.print(ans);

		br.close(); 
	}

	private static void peopleMove() {
		while(true) {
			boolean flag = false;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						int popsum = bfs(i, j);
						if (moveList.size() > 1) {
							change(popsum);
							flag = true;
						}
					}
				}
			}
			if (!flag) {
				return;
			}
			ans ++;
		}
	}

	private static void change(int popsum) {
		int avg = popsum / moveList.size();
		for(Node candidate: moveList) {
			map[candidate.x][candidate.y] = avg;
		}
		
	}

	private static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		moveList = new ArrayList<>();
		q.offer(new Node(x, y));
		moveList.add(new Node(x, y));
		visited[x][y] = true;
		
		int sum = map[x][y];
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx= now.x + dx[i];
				int ny = now.y + dy[i];
				
				if (canGo(nx, ny)) {
					int diff = Math.abs(map[now.x][now.y] - map[nx][ny]);
					if (L <= diff  && diff <= R) {
						q.offer(new Node(nx, ny));
						visited[nx][ny] = true;
						sum += map[nx][ny];
						moveList.add(new Node(nx, ny));
					}
				}
			}
		}
		
		return sum;
		
	}

	private static boolean canGo(int nx, int ny) {
		if(!inRange(nx, ny)) {
			return false;
		}
		if (visited[nx][ny]) {
			return false;
		}
		return true;
	}

	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < N;
	}

}
