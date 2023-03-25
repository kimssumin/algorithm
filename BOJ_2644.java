package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2644 {
	static int N, M;
	static int start, end;
	static List<Integer>[] family;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE/100;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] se = br.readLine().split(" ");
		family = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			family[i] = new ArrayList<>();
		}
		
		visited=new boolean[N];
		
		start = Integer.parseInt(se[0]) - 1;
		end = Integer.parseInt(se[1]) - 1;
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] inputStr = br.readLine().split(" ");
			int x = Integer.parseInt(inputStr[0]) - 1;
			int y = Integer.parseInt(inputStr[1]) - 1;
			family[y].add(x);
			family[x].add(y);
		}
		
		dfs(start, end, 0);
		System.out.println(ans == Integer.MAX_VALUE/100 ? -1  : ans);
		br.close(); 
	}

	static void dfs(int start, int end, int cnt) {
		if(start == end) {
			ans = cnt;
			return; 
		}
		
		visited[start] = true;
		for(int next : family[start]) {
			if(!visited[next]) {
				dfs(next, end, cnt+1);
			}
		}
	}
}
