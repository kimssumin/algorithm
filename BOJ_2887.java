import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2887 {

    static class Edge implements Comparable<Edge>{
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }


        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static class Node{
        int i, x, y, z;

        public Node(int i, int x, int y, int z) {
            this.i = i;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "i=" + i+
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }

    static class x implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.x, o2.x);
        }
    }static class y implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.y, o2.y);
        }
    }static class z implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.z, o2.z);
        }
    }

    static int N;
    static List<Node> planet = new ArrayList<>();
    static List<Edge>[] edgeList;
    static boolean [] visited;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int sumCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        edgeList = new ArrayList[N];

        for(int i = 0; i < N; i++){
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            planet.add(new Node(i, Integer.parseInt(inputStr[0]), Integer.parseInt(inputStr[1]), Integer.parseInt(inputStr[2])));
        }

        planet.sort(new x());
        xcalcDist();

        planet.sort(new y());
        ycalcDist();

        planet.sort(new z());
        zcalcDist();

        prim();
        System.out.println(sumCost);
        br.close();
    }

    private static void prim() {
        pq.add(new Edge(0, 0));
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if (visited[curr.v]){
                continue;
            }
            visited[curr.v] = true;
            sumCost += curr.w;
            for(Edge next : edgeList[curr.v]){
                if (!visited[next.v]){
                    pq.add(next);
                }
            }
        }
    }

    private static void xcalcDist() {
        for(int i = 0; i < planet.size()-1; i++){
            int cost =  Math.abs(planet.get(i).x - planet.get(i+1).x);
            edgeList[planet.get(i).i].add(new Edge(planet.get(i+1).i, cost));
            edgeList[planet.get(i+1).i].add(new Edge(planet.get(i).i, cost));
        }
    }
    private static void ycalcDist() {
        for(int i = 0; i < planet.size()-1; i++){
            int cost =  Math.abs(planet.get(i).y - planet.get(i+1).y);
            edgeList[planet.get(i).i].add(new Edge(planet.get(i+1).i, cost));
            edgeList[planet.get(i+1).i].add(new Edge(planet.get(i).i, cost));
        }
    }
    private static void zcalcDist() {
        for(int i = 0; i < planet.size()-1; i++){
            int cost =  Math.abs(planet.get(i).z - planet.get(i+1).z);
            edgeList[planet.get(i).i].add(new Edge(planet.get(i+1).i, cost));
            edgeList[planet.get(i+1).i].add(new Edge(planet.get(i).i, cost));
        }
    }
}
