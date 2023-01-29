package javaAlgorithm;

import java.util.Scanner;

public class Main {
	/*
	 * space_cnt = 2*n-3;
	 * cnt = n;
	 * height = 2*(n-1)+1 = 2*n-1
	 * width = 4*n-3;
	 */
	static char[][] board = new char[199][397];
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		int n = scnn.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.print("*");
		}
		for(int i = 0; i < 2*n-3; i++) {
			System.out.print(" ");
		}
		for(int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(int i = 1; i < n-1; i++) {
			System.out.println(" ".repeat(i) + "*" + " ".repeat(n-2) + "*" + " ".repeat(2*(n-i)-3) + "*" + " ".repeat(n-2) + "*" );
		}
		System.out.println(" ".repeat(n-1) + "*" +" ".repeat(n-2) + "*"+" ".repeat(n-2) + "*");
		for(int i = n-2; i >0; i--) {
			System.out.println(" ".repeat(i) + "*" + " ".repeat(n-2) + "*" + " ".repeat(2*(n-i)-3) + "*" + " ".repeat(n-2) + "*" );
		}
		for(int i = 0; i < n; i++) {
			System.out.print("*");
		}
		for(int i = 0; i < 2*n-3; i++) {
			System.out.print(" ");
		}
		for(int i = 0; i < n; i++) {
			System.out.print("*");
		}
	}


}
