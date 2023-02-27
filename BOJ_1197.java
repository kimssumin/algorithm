import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1197 {

    static int V, E;
    static int[] r;
    static int[] p;
    static long ans = Integer.MAX_VALUE;

    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            super();
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        } //ascending

    }
    static PriorityQueue<Edge> points;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ve = br.readLine().split(" ");
        V = Integer.parseInt(ve[0]);
        E = Integer.parseInt(ve[1]);

        points = new PriorityQueue<>();
        p = new int[V+1];
        r = new int[V+1];

        for (int i = 0; i < E; i++) {
            String[] inputStr = br.readLine().split(" ");
            int a = Integer.parseInt(inputStr[0]);
            int b = Integer.parseInt(inputStr[1]);
            int c = Integer.parseInt(inputStr[2]);
            points.offer(new Edge(a,b,c));
        }


        makeSet();
        int cnt = 0;
        ans = 0;

        while(cnt != V-1) {
            Edge edge = points.poll(); //최소edge
            if (union(edge.s, edge.e)) {
                cnt ++;
                ans += edge.w;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;

        //rank가 없으면 부하의부하의부하의 로 한쪽으로 쭉 내려가게됨
        //rank가 있으면 최종
        if (r[x] < r[y]) {
            r[y] += r[x];
            p[x] = y;
        } else {
            r[x] += r[y];
            p[y] = x;
        }

        return true;
    }

    //최종보스찾기
    private static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    private static void makeSet() {
        // TODO Auto-generated method stub
        for(int i = 0; i < V+1; i++) {
            p[i] = i;
            r[i] = 1;
        }

    }
}
