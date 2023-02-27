import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17471 {
    static int N;
    static int[] people;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> in = new ArrayList<>();
    static HashMap<Integer, int[]> link = new HashMap<>();
    static int[] numA;
    static int[] numB;
    static int now;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] p = br.readLine().split(" ");
        people = new int[N];
        map = new int[N][N];
        visited = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(p[i]);
        }

        for (int i = 0; i < N; i++) {
            String[] inputStr = br.readLine().split(" ");
            int cnt = Integer.parseInt(inputStr[0]);
            int[] temp = new int[cnt];
            for(int c = 0; c < cnt; c++){
                temp[c] = Integer.parseInt(inputStr[c+1])-1;
            }
            link.put(i, temp);
        }
        for(int i = 0; i < link.size(); i++){
            System.out.println("**** :" + Arrays.toString(link.get(i)));
        }


        for(int R = 1; R < N/2+1; R++){
            numA = new int[R];
            numB = new int[N - R];
            combi(0, 0, R);
            ans = Math.min(ans, now);
        }


        System.out.println(ans);


        br.close();
    }

    private static void combi(int cnt, int start, int r) {
        if (cnt == r){
            //System.out.println(Arrays.toString(numA));
            numB = rest(numA);
            //System.out.println("bfs수: "+bfs(numA[0]));
            if (bfs(numA[0], numA) && bfs(numB[0], numB)){
                now = Math.abs(getPeople(numA) - getPeople(numB));
            }
            return;

        }
        for(int i = start; i < N; i++){
            numA[cnt] = i;
            combi(cnt+1, i+1, r);
        }
    }


    private static boolean bfs(int s, int[] num) {
        //int count = 0;
        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[N];
        que.offer(s);
        visit[s] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            //System.out.println(Arrays.toString(link.get(cur)));
            for (int next : link.get(cur)) {
                System.out.println("next> " +next);
                if (visit[next]){
                    System.out.println("이미 방문");
                    continue;
                }
                if (!check(num,next)){
                    System.out.println("같은 그룹이 아님");
                    //System.out.println("next> " +next);
                    continue;
                }
                que.offer(next);
                visit[next] = true;
                //count++;
            }
        }
        System.out.println(Arrays.toString(visit));
        for(int i : num){
            if (!visit[i]){
                //System.out.println("problem:"+i+" "+Arrays.toString(visit));
                return false;
            }
        }
        return true;
    }



    private static int getPeople(int[] num) {
        int sum = 0;
        for(int n : num){
            sum += people[n];
        }
        return sum;
    }

    private static int[] rest(int[] numA) {
        int[] temp = new int[N - numA.length];
        System.out.println(Arrays.toString(temp)+" : "+Arrays.toString(numA));
        int idx = 0;
        for(int i = 0; i < N; i++){
            boolean flag = true;
            for(int a : numA){
                if (a == i){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                continue;
            }

            temp[idx] = i;
            idx++;
        }
        return temp;
    }


    private static boolean check(int[] now, int k) {
        for (int n : now){
            if (k == n){
                return true;
            }
        }
        return false;
    }
}
