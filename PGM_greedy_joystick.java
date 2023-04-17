class PGM_greedy_joystick {
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution("JAN"));
    }
    public static int solution(String name) {
        int answer = 0;
        char[] arr = name.toCharArray();
        visited = new boolean[name.length()];
        int now = 0;
        visited[0] = true;
        int[] updownlst = new int[arr.length];

        for(int c = 0; c < arr.length; c++){
            if (arr[c] == 'A'){
                visited[c] = true;
            }
            int updown = Math.min(arr[c] - 'A', 'Z' - arr[c] + 1);
            updownlst[c] = updown;
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(updownlst[i] + " ");
        }
        answer += Math.min(arr[now] - 'A', 'Z' - arr[now] + 1);
        while(true){
            if (allCheck()){
                break;
            }

            int turn = 0;
            int moveornot = Integer.MAX_VALUE;

            for(int i = 0; i < arr.length; i++){
                if (i == now || visited[i]){
                    continue;
                }
                int dist = 0;
                if (i < now){
                    dist = Math.min(now - i, arr.length -1 - now + i + 1);
                }
                else{
                    dist = Math.min(i - now, arr.length -1 - i + now + 1);
                }

                if (moveornot > updownlst[i] + dist){
                    moveornot = updownlst[i] + dist;
                    //System.out.println("d : "+dist+" i:"+i+" "+now+" "+updownlst[i]+" "+moveornot);
                    turn = i;
                }

            }

            now = turn;
            visited[now] = true;
            answer += moveornot;
            System.out.println(answer +" : "+moveornot +" "+turn);

        }
        return answer;
    }

    private static boolean allCheck(){
        for(int i = 0; i < visited.length; i++){
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }
}