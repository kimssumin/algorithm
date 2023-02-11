import java.util.Scanner;

public class BOJ_2615_pf {
	static int N=19;
	static int [][] map;
	// (r,c-1) (r-1,c-1) (r+1,c-1) (r-1,c) 
	static int [] dr= { 0,-1, 1,-1,1,-1,1,0};
	static int [] dc= {-1,-1,-1, 0,0, 1,1,1};
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		map=new int[N+2][N+2]; // 주변을 0으로 채움
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				map[i][j]=in.nextInt();
			}
		}
		//로직 
		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < N+1; c++) {
				// 바둑알이 있니 
				if(map[r][c]!=0) {
					//if (r,c)의 4방향으로 같은 색 바둑알이 5개인가?
					for (int d = 0; d <4; d++) {  //4방향 조사
						// d방향의 반대방향이 비어있거나 다른색이면 시작
						int nr=r+dr[d];
						int nc=c+dc[d];
						// 0 1 2 3 d 방향의 반대방향 7-d로 반대방향설정
						if((map[nr][nc]!=map[r][c]) &&
								(steps(map[r][c],r,c,7-d)) ) {
							System.out.println(map[r][c]);
							System.out.println(r+" "+c);
							return ;
						}
					}
				}
			}
		}
		System.out.println("0");
	}
	static boolean steps(int color, int r, int c, int d) {
		int cnt=1;
		//색상이 같으면서 같은 방향으로 바둑알 개수를 구한다.
		for (; color ==map[r+dr[d]][c+dc[d]]; r+=dr[d],c+=dc[d]) {
			cnt++;
		}
		return cnt==5?true:false;//5목만 살길이다.
	}
	
}