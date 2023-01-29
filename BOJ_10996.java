package javaAlgorithm;

import java.util.Scanner;

public class Main {
	static char[][] board = new char[399][397];
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		int n = scnn.nextInt();
		
		if (n == 1) {
			System.out.println('*');
		}
		else {
			for (int i = 0; i < 2*n; i++) {
				if(i % 2 == 0){
					for(int j = 1; j <= n; j++){
						if(j % 2 == 1){
							System.out.print("*");
						}
						else{
							System.out.print(" ");
						}
					}
				}
				else{
					for(int j = 1; j <= n; j++){
						if(j % 2 == 1){
							System.out.print(" ");
						}
						else{
							System.out.print("*");
						}
					}
				}
				System.out.println();
			}
		}
		
	}


}
