public class  PGM_2023kakao_lv2_emoticon {
    static int [] discount = {10, 20, 30, 40};
    static int [] emti;
    static int N, U;
    static int[] emoticon;
    static int[] answer = new int[2];

    public static void main(String[] args) {
        solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
    }
    public static int[] solution(int[][] users, int[] emoticons) {
        emoticon = emoticons.clone();
        N = emoticons.length;
        U = users.length;
        emti = new int[N];

        perm(0, users);
        return answer;
    }

    public static void perm(int cnt, int[][] users){
        if (cnt == N){
            purchase(emti, users);
            return;
        }
        for (int i = 0; i < 4; i++) {
            emti[cnt] = discount[i];
            perm(cnt+1, users);
        }
    }

    private static void purchase(int[] nums, int[][] users){
        int sum_price = 0;
        int sum_cnt = 0;
        for(int i = 0; i < U; i++){
            int price = 0;
            int cnt = 0;
            for(int n = 0; n < nums.length; n++){
                if (users[i][0] <= nums[n]){
                    //이모티콘 구매
                    //price += ((100-nums[n])*emoticon[n]/100);
                    price += ((100-nums[n])*(emoticon[n]/100));
                }
                if (price >= users[i][1]){
                    //이모티콘 가입
                    cnt ++;
                    price = 0;
                    break;
                }
            }
            sum_price += price;
            sum_cnt += cnt;
        }

        //System.out.println(Arrays.toString(nums)+" : "+ sum_price + " || "+sum_cnt);

        if (answer[0] < sum_cnt){
            answer[0] = sum_cnt;
            answer[1] = sum_price;
        }
        else if (answer[0] == sum_cnt){
            if (answer[1] < sum_price){
                answer[1] = sum_price;
            }
        }
    }
}