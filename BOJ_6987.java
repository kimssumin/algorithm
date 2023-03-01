package javaAlgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987{
	
	static int win[];
	static int lose[];
	static int draw[];
	static int country1[];
	static int country2[];
	static boolean end;
	static boolean gamestart = true;
	static final StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		country1 = new int[15]; //총경기수 15경기
		country2 = new int[15];
		
		//경기 별 팀
		int idx = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = i+1; j < 6; j++) {
				country1[idx] = i;
				country2[idx++] = j;
			}
		}
		
		
		for(int i = 0; i < 4; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			win = new int[6];		
			lose = new int[6];		
			draw = new int[6];	
			end=false;	
			gamestart = true;
			
			for(int j = 0; j < 6; j++) {
				win[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
				
				if (win[j] + draw[j] + lose[j] != 5) {
					gamestart = false;
					break;
				}
			}
			
			if(gamestart) {
				dfs(0);
				if (end) {
					sb.append(1);
				}
				else {
					sb.append(0);
				}
			}
			else {
				sb.append(0);				
			}
			
			sb.append(" ");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int round) {
		
		if(end) return;
		
		if(round == 15) {
			//모든 round를 돌면 true
			end=true;
			return;
		}
		
		int teamNow = country1[round];
		int teamEnemy = country2[round];
		
		//이기는 경우
		if(win[teamNow]>0 && lose[teamEnemy]>0) {
			win[teamNow]--;
			lose[teamEnemy]--;
			dfs(round+1);
			win[teamNow]++;
			lose[teamEnemy]++;
		}
		//비기는 경우
		if(draw[teamNow]>0 && draw[teamEnemy]>0) {
			draw[teamNow]--;
			draw[teamEnemy]--;
			dfs(round+1);
			draw[teamNow]++;
			draw[teamEnemy]++;
		}
		
		//지는 경우
		if(lose[teamNow]>0 && win[teamEnemy]>0) {
			lose[teamNow]--;
			win[teamEnemy]--;
			dfs(round+1);
			lose[teamNow]++;
			win[teamEnemy]++;
		}
	}
}
