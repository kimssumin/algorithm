package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SWE_1767 {
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static int N;
	static int [][] map;
	static int ansLink;
	static int ansCore;
	static int MM = 12*12+1; //core^2 +1-> max
	
	static List<Node> cores = new ArrayList<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ansLink = MM;
			ansCore = -1;
			cores = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				String[] inputStr = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(inputStr[j]);
					if (map[i][j] == 1) {
						if (inLast(i, j)) {
							continue;
						}
						cores.add(new Node(i, j));
					}
				}
			}
			
			link(0,0,0);
			
			sb.append("#"+t+" "+ansLink+"\n");
		}
		System.out.print(sb);
		br.close(); 

	}

	private static void link(int idx, int core, int link) {
		if (idx == cores.size()) {
			if (ansCore < core) {
				ansCore = core;
				ansLink = MM;
			}
			else if (ansCore == core && ansLink > link) {
				ansLink = link;
			}
			return;
		}
		
		Node now = cores.get(idx);
		for(int i = 0; i < 4; i++) {
			int cnt = canLink(now, i);
			if (cnt == -1) {
				continue;
			}
			
			link(idx+1, core+1, link + cnt);
			remove(cnt, now, i);
		}
		link(idx+1, core, link);
	}

	private static int canLink(Node now, int d) {
		int nx = now.x + dx[d];
		int ny = now.y + dy[d];
		int len = 0;
		boolean flag = false;
		
		while(true) {
			len++;
			if ((inLast(nx, ny)) && map[nx][ny]== 0) {
				flag = true;
				break;
			}
			if (map[nx][ny] == 2 || map[nx][ny] == 1) {
				flag = false;
				break;
			}
			
			nx += dx[d];
			ny += dy[d];
		}
		
		nx = now.x;
		ny = now.y;
		if (!flag) {
			return -1;
		}
		for(int i = 0; i < len; i++) {
			nx += dx[d];
			ny += dy[d];
			map[nx][ny] = 2;
		}
		return len;
	}

	private static void remove(int len, Node now, int d) {
		int nx = now.x;
		int ny = now.y;
		for(int i = 0; i < len; i++) {
			nx += dx[d];
			ny += dy[d];
			map[nx][ny] = 0;
		}
	}

	private static boolean inLast(int nx, int ny) {
		return nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1;
	}

}
