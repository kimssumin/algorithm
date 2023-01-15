import java.util.Scanner;

public class BOJ_15727 {
	static int T;
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		T = scnn.nextInt();
		if (T % 5 ==0) {
			System.out.println((T/5));
		}
		else {
			System.out.println((T/5) + 1);
		}
	}
	
}