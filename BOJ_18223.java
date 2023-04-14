import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18223 {

    static class  Node implements Comparable<Node> {
        int x, dist;

        public Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node e) {
            return this.dist - e.dist;   // dist 기준 오름차순 정렬
        }
    }
    static int V, E, P;
    static PriorityQueue<Node> pq;
    static List<Node>[] graph;
    static String isHere = "SAVE HIM";
    static String noHere = "GOOD BYE";
    static int[] dist;
    static int[] savedist;
    static int INF = Integer.MAX_VALUE / 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] vep = br.readLine().split(" ");
        V = Integer.parseInt(vep[0]);
        E = Integer.parseInt(vep[1]);
        P = Integer.parseInt(vep[2]);

        graph = new List[V+1];
        for(int i = 0; i <= V; i++){
            graph[i] = new ArrayList<>();
        }
        dist = new int[V+1];
        savedist = new int[V+1];

        Arrays.fill(dist, INF);
        Arrays.fill(savedist, INF);
        for (int i = 0; i < E; i++) {
            String[] inputStr = br.readLine().split(" ");
            int a = Integer.parseInt(inputStr[0]);
            int b = Integer.parseInt(inputStr[1]);
            int c = Integer.parseInt(inputStr[2]);
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        //1번 -> P번 + P번 -> V 번
        savedist[1] = 0;
        pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        int first = dijkstra(savedist, P);

        Arrays.fill(savedist, INF);
        savedist[P] = 0;
        pq = new PriorityQueue<>();
        pq.add(new Node(P, 0));
        int second = dijkstra(savedist, V);
        int save_dist = first + second;
//        System.out.println(first+" "+second);

        //1번 -> V번
        pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1] = 0;
        int rdist = dijkstra(dist, V);

        System.out.println(rdist < save_dist ? noHere : isHere);
        br.close();
    }

    private static int dijkstra(int[] d, int dest) {
        while(!pq.isEmpty()){
            Node now = pq.poll();
            for(Node next : graph[now.x]){
                if (now.dist + next.dist < d[next.x]){
                    d[next.x] = now.dist + next.dist;
                    pq.add(new Node(next.x, d[next.x]));
                }
            }
        }

        return d[dest];
    }


}
