import java.util.Scanner
package javaAlgorithm


public class SWE_1961 {
	public static void main(String args[]) throws Exception
	{

		/ *
       		   표준입력 System. in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         		 * /
		Scanner sc = new Scanner(System. in)
		int T
		T = sc.nextInt()
		/ *
       		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		* /

		for(int test_case=1
                    test_case <= T
                    test_case++)
		{

			int N = sc.nextInt()
			int[][] arr = new int[N][N]

			for (int i=0
                            i < N
                            i++) {
				for (int j=0
                                    j < N
                                    j++) {
					arr[i][j] = sc.nextInt()
                                }
			}

                    System.out.println("#" + test_case)
                    for(int i=0
                        i < N
                        i++) {
				for(int j=0
                                    j < N
                                    j++) {
					System.out.print(arr[N-j-1][i])
                                }
				System.out.print(" ")
				for(int j=0
                                    j < N
                                    j++) {
					System.out.print(arr[N-i-1][N-j-1])
                                }
				System.out.print(" ")
				for(int j=0
                                    j < N
                                    j++) {
					System.out.print(arr[j][N-1-i])
                                }
				System.out.println()
                            }

		}
	}
}
