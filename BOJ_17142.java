import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static class Virus
	{
	    int x,y,cnt;

	    public Virus(int x, int y)
	    {
	        this.x = x;
	        this.y = y;
	    }
	    public Virus(int x, int y,int cnt)
	    {
	        this.x = x;
	        this.y = y;
	        this.cnt = cnt;
	    }
	}
	
    static int zero_cnt;
    static int answer = Integer.MAX_VALUE;
    static int N,M;
    static int v_size;
    static int [][] map;
    static boolean [][] visited;
    static List<Virus> virus;
    static Virus[] p;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        p = new Virus[M];
        map = new int[N][N];
        virus = new ArrayList<>();

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                {
                    virus.add(new Virus(i,j));
                }
                else if(map[i][j] == 0) zero_cnt++;
            }
        }
        v_size = virus.size();
        chooseVirus(0, 0);
        //comb("",M,0,0);
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.print(answer);
    }
    
    private static void chooseVirus(int cnt, int start) {
        if (cnt == M){
        	visited = new boolean[N][N];
        	spread(p);
            return;
        }
        for(int i = start; i < virus.size(); i++){
            p[cnt] = virus.get(i);
            chooseVirus(cnt +1, i+1);
        }

    }
    
    static void spread(Virus [] arr)
    {
        Queue<Virus> q = new LinkedList<>();
        for(Virus v : arr)
        {
            q.add(new Virus(v.x,v.y,0));
            visited[v.x][v.y] = true;
        }

        int tmp_cnt = zero_cnt;
        int time = Integer.MIN_VALUE;
        while(!q.isEmpty())
        {
            Virus now = q.poll();
            if(tmp_cnt == 0)
            {
                time = Math.max(time, now.cnt);
                continue;
            }
            for(int d = 0; d < 4; ++d)
            {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(!inRange(nx,ny) || visited[nx][ny] || map[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                if(map[nx][ny] == 0) tmp_cnt--;
                q.add(new Virus(nx,ny,now.cnt+1));
            }
        }
        if(time == Integer.MIN_VALUE) return;
        answer = Math.min(time,answer);

    }
    static boolean inRange(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
