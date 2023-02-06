package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1074 {
    static int cnt; // 방문순서
    static int end_r; //최종목적지 row
    static int end_c; //최종목적지 col
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        end_r = Integer.parseInt(inputs[1]);
        end_c = Integer.parseInt(inputs[2]);
        
        //시작 row, 시작 col, 변의 길이
        numbering(0, 0, (int)Math.pow(2, n));
        br.close();
    }

    private static void numbering(int r, int c, int n) {
    	/*
    	 * 이 안에 속하면 OK
    	 * r <= end_r < r+n and c <= end_c < c+n
    	 */
    	
        if (r > end_r || r+n <= end_r || c > end_c || c+n <= end_c){
        	//시작지점에서 한 변의 길이만큼을 더한 범위 내에 end_r, end_c가 포함되지않으면
        	//그 제곱값을 반환해서 한번에 칸들을 계산하고 다음으로 넘어감
            cnt += Math.pow(n,2);
            return;
        }
        if (n > 2) {
        	//z순
        	numbering(r, c, n/2);
            numbering(r, c+n/2, n/2);
            numbering(r+n/2, c, n/2);
            numbering(r+n/2, c+n/2, n/2);
        }

        else{
        	 if (end_r == r && end_c == c){
                 System.out.println(cnt);
             }
             else if(end_r == r && end_c == c+1){
                 System.out.println(cnt+1);
             }
             else if(end_r == r+1 && end_c == c){
                 System.out.println(cnt+2);
             }
             else if (end_r == r+1 && end_c == c+1){
                 System.out.println(cnt + 3);
             }
        	 return;
        }

    }
}
