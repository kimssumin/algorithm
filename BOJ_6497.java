package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_6497 {
	
	static class Edge implements Comparable<Edge> {
		int v;
		int weight;

		Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}

	}

	static int M, N;
	static List<Edge>[] city;
	static boolean[] visited;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	static int allCost;
	static int minCost;
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] inputStr = br.readLine().split(" ");
			M = Integer.parseInt(inputStr[0]);
			N = Integer.parseInt(inputStr[1]);
			if (M == 0 && N == 0) {
				break;
			}
			city = new ArrayList[M];
			visited = new boolean[M];
			for(int i = 0; i < M; i++) {
				city[i] = new ArrayList<>();
			}
			allCost = 0;
			minCost = 0;
			pq = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				String[] in = br.readLine().split(" ");
				int x = Integer.parseInt(in[0]);
				int y = Integer.parseInt(in[1]);
				int z = Integer.parseInt(in[2]);
				city[x].add(new Edge(y, z));
				city[y].add(new Edge(x, z));
				allCost += z;
			}
			
			for(Edge curr : city[0]) {
				pq.add(curr);
			}
			//pq.offer(new Edge(0, 0));
			prim(0);
			
			sb.append(allCost - minCost).append("\n");
			
		}
		
		System.out.print(sb);
		br.close(); 

	}

	private static void prim(int v) {
		visited[v] = true;
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if (visited[now.v]) {
				continue;
			}
			visited[now.v] = true;
			minCost += now.weight;
			
			for(Edge next : city[now.v]) {
				if (!visited[next.v]) {
					pq.add(next);
				}
			}
		}
	
	}

}
