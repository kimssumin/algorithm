package javaAlgo;
import java.io.*;
import java.util.*;

public class BOJ_1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,String> map1 = new HashMap<>();
        map1.put("black","0");
        map1.put("brown", "1");
        map1.put("red", "2");
        map1.put("orange", "3");
        map1.put("yellow", "4");
        map1.put("green", "5");
        map1.put("blue", "6");
        map1.put("violet", "7");
        map1.put("grey", "8");
        map1.put("white", "9");
        
        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();
        long ans = Long.parseLong(map1.get(color1) + map1.get(color2));
        ans *= Math.pow(10.0, (double) Integer.parseInt(map1.get(color3)));
        System.out.print(ans);
    }
}