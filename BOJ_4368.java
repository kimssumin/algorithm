import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class BOJ_4368 {
	
	static int N;
	static double [][] map;
	static int[] p;
	static long ans = Integer.MAX_VALUE;
	
	static class Edge implements Comparable<Edge>{
		int start;
        int end;
        double cost;
        
        public Edge(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge e) {
        	return Double.compare(this.cost, e.cost);
        } //ascending
		
	}
	
	public static class Node {
        int num;
        double x;
        double y;
        
        public Node(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
	
	
	static Node[] r;
	static PriorityQueue<Edge> q = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		p = new int[N];
		r = new Node[N];
		
		for (int i = 0; i < N; i++) {
			String[] inputStr = br.readLine().split(" ");
			double x= Double.parseDouble(inputStr[0]);
			double y = Double.parseDouble(inputStr[1]);
			r[i] = new Node(i, x, y);
		}
		
		for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                double dist = Math.sqrt(Math.pow(r[i].x - r[j].x, 2) + Math.pow(r[i].y - r[j].y, 2));
                q.add(new Edge(i, j, dist));
            }
        }
		
		makeSet();
		
		double ans = 0;
		
		while(!q.isEmpty()) {
            Edge curr = q.poll();
            
            int p1 = find(curr.start);
            int p2 = find(curr.end);
            
            if(p1 != p2) {
                union(p1, p2);
                ans += curr.cost;
            }
        }
		System.out.printf("%.2f",ans);
		br.close();
	}
	
	public static int find(int a) {
        if(p[a] == a) return a;
        else return p[a] = find(p[a]);
    }
    
    public static void union(int a, int b) {
        p[a] = b;
    }

	private static void makeSet() {
		for(int i = 0; i < N; i++) {
			p[i] = i;
		}
		
	}
}
