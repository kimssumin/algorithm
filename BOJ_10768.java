
import java.util.*;

public class BOJ_10768 {
	static int month;
	static int day;
	static String after = "After";
	static String before = "Before";
	static String special = "Special";
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		month = scnn.nextInt();
		day = scnn.nextInt();
		int base_month = 2;
		int base_day = 18;
		
		if(month > base_month) {
			System.out.println(after);
		}
		else if (month < base_month) {
			System.out.println(before);
		}
		else {
			if (day == base_day) {
				System.out.println(special);
			}
			else if (day > base_day){
				 System.out.println(after);
			}
			else {
				System.out.println(before);
			}
		}
	}
}
