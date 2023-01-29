package javaAlgorithm;

import java.util.Scanner;

/*
 * 가로 길이 : 1, 5, 9, 13, ... (4n-3)
 * 세로 길이 : 1, 7, 11, 15, ... (4n-1)
 */

public class Main {
	static char[][] board = new char[399][397];
	public static void main(String[] args) {
		Scanner scnn = new Scanner(System.in);
		int n = scnn.nextInt();
		
		if (n == 1) {
			System.out.print("*");
			return;
		}
		
		int width = 4*n -3;
		int height = 4*n -1;
		
		for(int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = ' ';
			}
		}
		
		star(n, 0, 4*n-4);
		
		StringBuilder sb = new StringBuilder();
	    for(int i=0; i<height; i++) {
	            for(int j=0; j<width; j++) {
	                if(i == 1) {
	                    sb.append(board[i][0]);
	                    break;
	                }
	                sb.append(board[i][j]);
	            }
	            sb.append("\n");
        }
	    System.out.println(sb.toString());
		
	}

	private static void star(int n, int x, int y) {
		
		int width = 4*n -3;
		int height = 4*n -1;
		
		for (int i = 1; i < width; i++) {
			board[x][y--] = '*';
		}
		for(int i = 1; i < height ; i++) {
			board[x++][y] = '*';
		}
		for (int i = 1; i < width; i++) {
			board[x][y++] = '*';
		}
		for (int i = 1; i < height -2 ; i++) {
			board[x--][y] = '*';
		}
		
		board[x][y] = '*';
		y--;
		board[x][y] = '*'; 
		
		if (n == 2) {
			board[x][y-1] = '*';
			board[x+1][y-1] = '*';
			board[x+2][y-1] = '*';
			return;
		}
		
		star(n-1, x, y-1);
	}	
}
