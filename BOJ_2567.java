import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2567 {

	static int N; // 검은 스카프의 수
	static int[][] position; // 검은 스카프를 놓은 위치
	static int ans; // 검은 영역의 둘레의 길이
	static int plus; // 두번 세야하는 경우
	static int[][] map = new int[102][102];
	//가장자리에 검은 천이 붙어있는 경우를 고려하여 위 아래 행/열 추가
	
	static int[] leftMin = { 0, 102 }; // 검은 천의 최소 왼쪽 아래 좌표
	static int[] rightMax = { 102, 0 }; // 검은 천의 최대 오른쪽 위 좌표
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		position = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] xy = br.readLine().split(" ");
			position[i][1] = Integer.parseInt(xy[0])+1; // y : 검은 천 왼쪽 변과 흰색 천의 왼쪽 변 사이의 거리
			position[i][0] = 100 - Integer.parseInt(xy[1])+1; // x : 검은 천 아래 변과 흰색 천의 아래 변 사이의 거리
			
			// 따라서 흰색 천의 왼쪽 위 점을 원점으로 했을 때 검은 천의 왼쪽 아래 점의 좌표는
			// (position[i][1], 100 - position[i][0]) 이다
			
			leftMin = new int[] {Math.max(leftMin[0], position[i][0]), Math.min(leftMin[1], position[i][1])};
			rightMax = new int[] {Math.min(rightMax[0], position[i][0]-10), Math.max(rightMax[1], position[i][1]+10)};

		}
		
		makeCal(); // 흰 천을 map으로 하여 그곳에 검은 천이 깔리는 경우 1을 대입하는 메서드

		System.out.println(ans + plus);
		br.close();
	}

	private static void makeCal() {
		for (int i = 0; i < N; i++) {
			// N개의 검은 스카프
			// 흰 천의 왼쪽 아래지점을 기점으로 하여 검은 천의 x, y 좌표를 지정
			int x = position[i][0]; //x
			int y = position[i][1]; //y
			//System.out.println(x + " " + y);
			for (int n = 0; n < 10; n++) {
				// 가로,세로 길이는 10
				for (int m = 0; m < 10; m++) {
					map[x - n][y + m] = 1; // 검은 천 1로 채우기
				}
			}
		}
		
		calc(); //1의 갯수 count 메서드

	}


	
	private static void calc() {
		for (int i =  0 ; i < 102; i++) {
			//가로
			for(int j = 0 ; j < 102; j++) {
				//세로
				if (map[i][j] == 1) {
					//그 위치가 검은천이면서
					if (canCheck(i,j)) {
						//System.out.println((99-i)+" "+(j));
						//가장 자리에 있는 1인지 체크
						ans += 1;
					}
				}
			}
		}
		
	}

	
	private static boolean canCheck(int x, int y) {
		int zeroCnt = 0; //주위에 0이 몇개가 있는지
		for (int i = 0; i < 4; i++) {
			//4방을 다 탐색 후
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!inRange(nx, ny)) {
				continue;
			}
			if (map[nx][ny] == 0) {
				//범위 내에 있으면서 흰 천이 주위에 있으면
				zeroCnt++;
				//주위에 있는 검은 천 갯수 +1
			}
		}
		if (zeroCnt >= 1) {
			if (zeroCnt >= 2) {
				plus ++; //두 변과 겹쳐서 두번 세야하는 경우 추가
			}
			//검은 천 갯수가 1보다 크면 true
			return true;
		}
		else {
			//없으면 빈 공간이니 pass
			return false;			
		}
	}
	

	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && nx < 102 && ny < 102 && ny >= 0;
		//범위를 벗어나지 않는지 체크
	}

}
