import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> rope = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
            rope.add(Integer.parseInt(stt.nextToken()));
        }
        rope.sort(Comparator.reverseOrder());
        //System.out.println(rope);
        int max = rope.get(0);

        for (int r = 1; r < n; r++){

            if (max < rope.get(r)*(r+1)){
                max = rope.get(r) * (r+1);
            }
        }
        int answer = max;

        System.out.println(answer);
        br.close();
    }
}
