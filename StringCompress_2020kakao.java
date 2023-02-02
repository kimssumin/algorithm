import java.io.IOException;

public class StringCompress_2020kakao {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        String ex_s = "xababcdcdababcdcd";
        System.out.println(s.solution(ex_s));

    }


}
class Solution{
    public static int solution(String s) {
        int answer;
        answer = s.length();
        if (s.length() == 1){
            return 1;
        }

        for (int i = 1; i < s.length()/2+1; i++) {
            answer = Math.min(cando(s, i).length(), answer);
            //System.out.println(answer+" "+cando(s, i));
        }
        return answer;
    }

    private static String cando(String str, int unit ) {
        String answer = "";
        String prev = "";
        int cnt = 1;
        for (int i = 0; i <= str.length(); i+= unit) {
            //System.out.println(str.substring(i, i + unit));
            int end_index = i + unit;
            if (end_index > str.length()){
                end_index = str.length();
            }
            if (prev.equals(str.substring(i,end_index))) {
                cnt += 1;
            } else {
                if (cnt != 1) {
                    answer += cnt;
                    answer += prev;
                } else {
                    answer += prev;
                }
                prev = str.substring(i, end_index);
                cnt = 1;
            }
        }
        if (cnt != 1) {
            answer += cnt;
            answer += prev;
        } else {
            answer += prev;
        }
        return answer;
    }
}


