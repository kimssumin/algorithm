import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                if(i == 0){
                    first.add(Integer.parseInt(stt.nextToken()));
                }
                else{
                    second.add(Integer.parseInt(stt.nextToken()));
                }
            }
        }
        first.sort(Comparator.naturalOrder());
        second.sort(Comparator.reverseOrder());

        int answer = 0;
        for (int i = 0; i < first.size(); i++){
            answer += first.get(i) * second.get(i);
        }
        System.out.println(answer);
        br.close();
    }
}