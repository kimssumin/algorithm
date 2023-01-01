
package javaAlgorithm;
import java.util.Scanner;

public class SWE_1204 {
	public static void main(String args[]) throws Exception
	{

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int tn = sc.nextInt();
			int[] arr = new int[101];
			
			for (int i = 0; i < 1000; i++) {
				arr[sc.nextInt()]++;
			}
			
			int max = 0;
            int index = 0;
            
            for(int i =0; i<arr.length; i++){
                if(arr[i] >= max){
                    max = arr[i];
                    index = i;
                }
            }
            System.out.println("#" + tn + " " + index);

		}
	}

}
