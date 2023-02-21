import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb.append(br.readLine());
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            stack.push(sb.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean flag = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag == true) {
                    for (int k = 0; k < bomb.length(); k++) {
                        stack.pop();
                    }
                }
            }
        }
        sb.setLength(0);
        for (Character c : stack) {
            sb.append(c);
        }
        if (sb.length() == 0){
            System.out.print("FRULA");
        }
        else{
            System.out.print(sb);
        }
        br.close();
    }
}
