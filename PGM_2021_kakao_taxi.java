import java.util.*;
class PGM_2021_kakao_taxi {
    static int[][] taxi;
    static int INF = Integer.MAX_VALUE;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        taxi = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(taxi[i], INF);
            taxi[i][i] = 0;
        }
        for(int i = 0; i < fares.length; i++){
            taxi[fares[i][0] - 1][fares[i][1] - 1] = fares[i][2];
            taxi[fares[i][1] - 1][fares[i][0] - 1] = fares[i][2];
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if (taxi[i][k] == INF || taxi[k][j] == INF){
                        continue;
                    }
                    taxi[i][j] = Math.min(taxi[i][j], taxi[i][k] + taxi[k][j]);
                }
            }
        }

        for(int k = 0; k < n; k++){
            int cnt= 0;
            cnt += taxi[s-1][k];
            cnt += taxi[k][a-1];
            cnt += taxi[k][b-1];
            answer = Math.min(answer, cnt);
        }


        //System.out.println(taxi[a-1][s-1]+" "+taxi[b-1][s-1]);

        return answer;
    }
}