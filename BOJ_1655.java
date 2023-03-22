import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1655 {
static List<Integer> rm = new ArrayList<>();
static final StringBuilder sb = new StringBuilder();
static PriorityQueue<Integer> pq_first = new PriorityQueue<>(Collections.reverseOrder());
static PriorityQueue<Integer> pq_second = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N+1; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i == 1){
                pq_first.add(num);
                sb.append(num+"\n");
            }
            else{
                if (num > pq_first.peek()){
                    if (pq_second.size() == 0){
                        pq_second.add(num);
                    }
                    else{
                        if (pq_second.peek() > num){
                            pq_first.add(num);
                        }
                        else{
                            pq_second.add(num);
                        }
                    }
                }
                else{
                    pq_first.add(num);
                }

                if (Math.abs(pq_first.size()- pq_second.size()) >= 2){
                    if (pq_first.size() > pq_second.size()){
                        pq_second.add(pq_first.poll());
                    }
                    else{
                        pq_first.add(pq_second.poll());
                    }
                }
//                System.out.println(pq_first);
//                System.out.println(pq_second);
                if (pq_first.size() == pq_second.size()){
                    sb.append(Math.min(pq_first.peek() , pq_second.peek())+"\n");
                }
                else{
                    if (pq_first.size() > pq_second.size()){
                        sb.append(pq_first.peek()+"\n");
                    }
                    else{
                        sb.append(pq_second.peek()+"\n");
                    }

                }
            }
        }
        System.out.print(sb);
        br.close();
    }

}
