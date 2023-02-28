import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14865 {
	static int N; //직교다각형의 꼭짓점 갯수
	static int[][] dist; // 꼭짓점 좌표
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			dist[i][0] = Integer.parseInt(s[0]);
			dist[i][1] = Integer.parseInt(s[1]);
		}
		
		
		br.close();
	}
}
