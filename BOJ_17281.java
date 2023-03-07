import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17281 {
    static int N;
    static int[][] ining;
    static int[] baseballTurn;
    static boolean[] visited;
    static int[] baseNow;
    static int score;
    static int save_num; //선수 번호
    static int ans; // 최대 점수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        baseballTurn = new int[9];
        visited = new boolean[9];

        ining = new int[N][9];
        for (int i = 0; i < N; i++) {
            // 각 이닝
            String[] inputStr = br.readLine().split(" ");
            for(int j = 0; j < 9; j++){
                ining[i][j] = Integer.parseInt(inputStr[j]);
            }
        }


        perm(0);
        System.out.println(ans);
        br.close();
    }

    private static void perm(int cnt) {
        if (cnt == 9){
            if (baseballTurn[3] == 0){
                save_num = 0;
                gameStart(baseballTurn);
                ans = Math.max(ans, score);
            }
            return;
        }
        for(int i = 0; i < 9; i++){
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            baseballTurn[cnt] = i;
            perm(cnt+1);
            visited[i] = false;
        }
    }

    private static void gameStart(int [] turn) {
        score = 0; //각 경우의 수의 score
        for(int i = 0; i < N; i++){
            iningStart(turn, i);
            //System.out.println(score);
        }

    }

    private static void iningStart(int [] turn, int ininingNum) {
        int outCnt = 0;
        int t = save_num;
        baseNow = new int[4]; //1루, 2루, 3루, HOME

        while(outCnt != 3){
            int cn = turn[t]; //선수 번호
            int getScore = ining[ininingNum][cn]; // 그 선수가 획득한 점수
            save_num = (t+1)%9;
            switch(getScore){
                case 0:
                    //아웃
                    outCnt += 1;
                    break;

                case 1 :
                    // 안타
                    for(int i = 3; i >= 1; i--){
                        baseNow[i] += baseNow[i-1];
                        baseNow[i-1] = 0;
                    }

                    baseNow[0] = 1;
                    break;

                case 2 :
                    // 2루타
                    if (baseNow[1] == 1){
                        //홈 갈수있음
                        baseNow[3] += 1;
                        baseNow[1] = 0;
                    }
                    if(baseNow[2] == 1){
                        //홈 갈수있음
                        baseNow[3] += 1;
                        baseNow[2] = 0;
                    }
                    if (baseNow[0] == 1){
                        baseNow[2] = 1;
                        baseNow[0] = 0;
                    }
                    baseNow[1] = 1;
                    break;

                case 3:
                    // 3루타
                    if (baseNow[1] == 1){
                        //홈 갈수있음
                        baseNow[3] += 1;
                        baseNow[1] = 0;
                    }
                    if(baseNow[2] == 1){
                        //홈 갈수있음
                        baseNow[3] += 1;
                        baseNow[2] = 0;
                    }
                    if(baseNow[0] == 1){
                        //홈 갈수있음
                        baseNow[3] += 1;
                        baseNow[0] = 0;
                    }
                    baseNow[2] = 1;
                    break;

                case 4:
                    //홈런
                    for(int i = 0; i < 3; i++){
                        if (baseNow[i] != 0){
                            baseNow[3] += 1;
                        }
                    }
                    baseNow[3] += 1; //지금 주자 들어옴
                    for(int i = 0; i < 3; i++){
                        baseNow[i] = 0;
                    }
                    break;
            }

            t = (t+1)%9;
            //System.out.println(Arrays.toString(baseNow));
        }
        score += baseNow[3];
    }


}
