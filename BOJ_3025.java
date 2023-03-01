package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_3025 {
	
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int R, C;
	static char[][] map;
	static int N;
	static List<Node>[] al;
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rc = br.readLine().split(" ");
		R = Integer.parseInt(rc[0]);
		C = Integer.parseInt(rc[1]);
		
		map = new char[R][C];
		al = new ArrayList[C];
		for (int i = 0; i < C; i++) {
			al[i] = new ArrayList<>();
		}
		for(int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();
			map[i] = tmp;
		}
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int col = Integer.parseInt(br.readLine()) - 1;
			
			while(!al[col].isEmpty()) {
				Node now = al[col].get(al[col].size()-1);
				if (map[now.x][now.y] == '.') {
					break;
				}
				al[col].remove(al[col].size()-1);
				
			}
			
			if (!al[col].isEmpty()) {
				Node n = al[col].get(al[col].size()-1);
				al[col].remove(al[col].size()-1);
				game(n.x, n.y, col);
			}
			else {
				game(0, col, col);
			}
			
			Node done = al[col].remove(al[col].size()-1);
			map[done.x][done.y] = 'O';
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);

		br.close(); 

	}
	private static void game(int x, int y, int line) {
		while(true) {
			al[line].add(new Node(x, y));
			if (x+1 == R || map[x+1][y] == 'X') {
				map[x][y] = 'O';
				return;
			}
			if (map[x+1][y] == 'O') {
				if (y >= 1 && map[x][y-1] == '.' && map[x+1][y-1] == '.') {
					y -= 1;
				}
				else if (y +1 < C && map[x][y+1] == '.' && map[x+1][y+1] == '.') {
					y += 1;
				}
				else {
					map[x][y] = 'O';
					return;
				}
			}
			x += 1;
		}
		
	}
	
	

}
