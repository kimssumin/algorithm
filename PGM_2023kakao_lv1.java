import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PGM_2023kakao_lv1 {

    static HashMap<String, Integer> expireDate=  new HashMap<>();
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
    }
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        String[] tdy = today.split("\\.");
        int ty = Integer.parseInt(tdy[0]);
        int tm = Integer.parseInt(tdy[1]);
        int td = Integer.parseInt(tdy[2]);

        for(String cs : terms){
            String[] c = cs.split(" ");
            expireDate.put(c[0], Integer.parseInt(c[1]));
        }
        int num = 1;
        for(String prv : privacies){
            String[] pv = prv.split(" ");
            String date = pv[0];
            String[] dl = date.split("\\.");
            String now = pv[1];
            int getWhenExpire = expireDate.get(now);
            getWhenExpire *= 28; // 일 기준

            int y = Integer.parseInt(dl[0]);
            int m = Integer.parseInt(dl[1]);
            int d = Integer.parseInt(dl[2]);

            long NowsumDate = ty * 12 * 28 + tm * 28 + td;
            long startDate = y * 12 * 28 + m * 28 + d;


            if (NowsumDate- startDate >= getWhenExpire){
                answer.add(num);
            }


            //System.out.println(NowsumDate- startDate + " : "+ getWhenExpire);
            num ++;
        }

        int[] ans = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}
