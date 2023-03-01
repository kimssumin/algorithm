package javaAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWE_1238 {
    static int ans;
    static int len, start;
    static boolean[] visited;
    static List<Integer>[] phone = new ArrayList[101];
    static List<Integer> nowlist;
    static Set<Integer> user;
    static Queue<Integer> q = new LinkedList<>();
    static final StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        int T = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= T; t++){
            String[] ls = br.readLine().split(" ");
            len = Integer.parseInt(ls[0]);
            start = Integer.parseInt(ls[1]);

            phone = new ArrayList[101];
            visited = new boolean[101];
            Queue<Integer> q = new LinkedList<>();

            for(int i = 0; i < 101; i++){
                phone[i] = new ArrayList<>();
            }

            String[] inputStr = br.readLine().split(" ");
            for (int i = 0; i < len; i+=2){
                phone[Integer.parseInt(inputStr[i])].add(Integer.parseInt(inputStr[i+1]));
            }


            //System.out.println(Arrays.toString(user.toArray()));

            bfs(start);


            sb.append("#"+t+" "+ans+"\n");


        }
        System.out.println(sb);
        br.close();
    }

    private static void bfs(int start) {
        q.add(start);
        visited[start] = true;
        int cnt = 0; //max-num
        List<Integer> lastlist = new ArrayList<>();
        while(!q.isEmpty()) {
        	int qSize = q.size();
        	cnt = 0;
        	
        	for(int rank = 0; rank < qSize; rank++) {
        		int now = q.poll();
        		for (int n : phone[now]) {
                    if (visited[n]) {
                        continue;
                    }
                    visited[n] = true;
                    q.add(n);
                    cnt = Math.max(cnt, n);
                }
        	}
            
        	lastlist.add(cnt);
        }
        ans = lastlist.get(lastlist.size()-2);
    }
    
    
}
