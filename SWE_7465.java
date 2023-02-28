package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWE_7465 {

	static int N, M;
	static List<Integer>[] number;
	static boolean[] visit;
	static final StringBuilder sb = new StringBuilder();
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			String[] nm = br.readLine().split(" ");
			N = Integer.parseInt(nm[0]);
			M = Integer.parseInt(nm[1]);
			
			number = new ArrayList[N+1];
			visit = new boolean[N+1];
			ans = 0;
			
			for(int i = 1; i < N+1; i++) {
	        	number[i] = new ArrayList<>();
	        }
			
			for(int i = 0; i < M; i++) {
				String[] inputStr = br.readLine().split(" ");
				int a = Integer.parseInt(inputStr[0]);
				int b = Integer.parseInt(inputStr[1]);
				number[a].add(b);
				number[b].add(a);
			}
			
			for(int i = 1; i < N+1; i++) {
				if (!visit[i]) {
					bfs(i);
					ans ++;
				}
			}
			
			sb.append("#"+t+" "+ans+"\n");
		}
		
		System.out.print(sb);

		br.close(); 


	}

	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visit[x] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			visit[now] = true;
			for(int e : number[now]) {
				if (visit[e]) {
					continue;
				}
				q.offer(e);
				visit[e] = true;
				
			}
		}
}

}
