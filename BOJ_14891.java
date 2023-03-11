import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ_14891 {

    static Deque<Integer> [] topni = new ArrayDeque[4];
    static int ans;
    static boolean[] visit = new boolean[4];
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i++){
            topni[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < 4; i++) {
            String[] inputStr = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                topni[i].add(Integer.parseInt(inputStr[j]));
            }
        }

        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            String[] in = br.readLine().split(" ");
            int num = Integer.parseInt(in[0]) -1;
            int dir = Integer.parseInt(in[1]);

            int left = (Integer) topni[num].toArray()[6];
            int right = (Integer) topni[num].toArray()[2];
            visit = new boolean[4];
            if (dir == -1){
                int v = topni[num].pollFirst();
                topni[num].addLast(v);
            }
            else{
                int v = topni[num].pollLast();
                topni[num].addFirst(v);
            }
            visit[num] = true;
            //System.out.println(left+" : "+right);
            rotation(num, dir, left, right);
//            System.out.println(i+"번회전");
//            print();
//            System.out.println();
        }
        score();
        System.out.println(ans);
        br.close();
    }

    private static void score() {
        //print();
        if(topni[0].getFirst() == 1){
            ans += 1;
        }if(topni[1].getFirst() == 1){
            ans += 2;
        }if(topni[2].getFirst() == 1){
            ans += 4;
        }if(topni[3].getFirst() == 1){
            ans += 8;
        }
    }

    private static void rotation(int num, int dir, int leftVal, int rightVal) {
        if (num < 0 && num > 3){
            //print();
            return;
        }
        //좌측검사
        if (num -1 >= 0){
            if ((Integer)topni[num-1].toArray()[2] != leftVal && !visit[num-1]){
                visit[num-1]= true;
                int left = (Integer) topni[num-1].toArray()[6];
                int right = (Integer) topni[num-1].toArray()[2];
                if (dir == 1){
                    int v = topni[num-1].pollFirst();
                    topni[num-1].addLast(v);
                }
                else{
                    int v = topni[num-1].pollLast();
                    topni[num-1].addFirst(v);
                }
                rotation(num-1, -1 *(dir), left, right);
            }
        }

        //우측검사
        if(num+1 <= 3){
            if ((Integer)topni[num+1].toArray()[6] != rightVal && !visit[num+1]){
                visit[num+1]= true;
                int left = (Integer) topni[num+1].toArray()[6];
                int right = (Integer) topni[num+1].toArray()[2];
                //System.out.println(left+" : "+right);
                if (dir == 1){
                    int v = topni[num+1].pollFirst();
                    topni[num+1].addLast(v);
                }
                else{
                    int v = topni[num+1].pollLast();
                    topni[num+1].addFirst(v);
                }
                rotation(num +1, -1*(dir), left, right);
            }
        }

    }

    private static void print() {
        for(int i = 0; i < 4; i++){
            System.out.println(Arrays.toString(topni[i].toArray()));
        }
    }
}
