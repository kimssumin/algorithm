package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_20056 {
	
	static class Node{
		int m, d, s;

		public Node(int m, int s, int d) {
			super();
			this.m = m;
			this.d = d;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Node [m=" + m + ", d=" + d + ", s=" + s + "]";
		}
		
		
	}
	static int N, M, K;
	static List<Node>[][] map;
	static List<Node>[][] copymap;
	static List<Node>[][] doublecopymap;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmk = br.readLine().split(" ");
		N = Integer.parseInt(nmk[0]);
		M = Integer.parseInt(nmk[1]);
		K = Integer.parseInt(nmk[2]);
		
		map = new ArrayList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		
		for (int i = 0; i < M; i++) {
			String[] inputStr = br.readLine().split(" ");
			int r = Integer.parseInt(inputStr[0])-1;
			int c = Integer.parseInt(inputStr[1])-1;
			int m = Integer.parseInt(inputStr[2]);
			int s = Integer.parseInt(inputStr[3]);
			int d = Integer.parseInt(inputStr[4]);
			map[r][c].add(new Node(m, s, d));
		}
		
		for(int i = 0; i < K; i++) {
			initCopy();
			moveFire();
			doFire();
			copytoMap();
			//printMap(i);
			
		}
		
		ans = getM();
		System.out.println(ans);
		br.close(); 
	}

	private static void printMap(int ii) {
		System.out.println("#"+(ii+1));
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(Node now : map[i][j]) {
					System.out.print(now.toString() + " || ");
				}
			}
			System.out.println();
		}
	}

	private static int getM() {
		int totalM = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(Node now : map[i][j]) {
					totalM += now.m;
				}
			}
		}
		return totalM;
	}

	private static void copytoMap() {
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				map[i][j] = new ArrayList<>(doublecopymap[i][j]);
			}
		}
		
	}

	private static void doFire() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (copymap[i][j].size() >= 2) {
					int sz = copymap[i][j].size();
					int summ = 0;
					int sums = 0;
					int sumd = copymap[i][j].get(0).d;
					boolean dcheck = true;
					for(Node fire : copymap[i][j]) {
						summ += fire.m;
						sums += fire.s;
						if ((sumd + fire.d) % 2 != 0) {
							dcheck = false;
						}
					}
					
					int nm = summ / 5;
					copymap[i][j].clear();
					if (nm != 0) {
						int ns = sums / sz;
						int[] t = {0, 2, 4, 6};
						int[] f = {1, 3, 5, 7};
						for(int k = 0; k < 4; k++) {
							if (dcheck) {
								// 모두 홀수이거나 모두 짝수
								doublecopymap[i][j].add(new Node(nm, ns, t[k]));
							}
							else {
								doublecopymap[i][j].add(new Node(nm, ns, f[k]));
							}
						}
					}
					
				}
				else {
					doublecopymap[i][j] = copymap[i][j];
				}
			}
		}
		
	}

	private static void moveFire() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(Node fire : map[i][j]) {
					//System.out.println(i+" : "+j);
					int fm = fire.m;
					int fs = fire.s;
					int fd = fire.d;
					int nr = (N + i + dx[fd] * (fs % N))%N;
					int nc = (N + j + dy[fd] * (fs % N))%N;
					copymap[nr][nc].add(new Node(fm, fs, fd));
					//System.out.println(fd+" "+dx[fd]+" "+dy[fd]+" "+nr+" "+nc +" "+copymap[nr][nc].toString());
				}
			}
		}
		
	}

	private static void initCopy() {
		copymap = new ArrayList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				copymap[i][j] = new ArrayList<>();
			}
		}
		doublecopymap = new ArrayList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				doublecopymap[i][j] = new ArrayList<>();
			}
		}
		
	}
}
