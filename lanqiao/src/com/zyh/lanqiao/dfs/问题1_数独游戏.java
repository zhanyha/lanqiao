package com.zyh.lanqiao.dfs;

import java.util.Scanner;

/**
 * 问题地址：https://vjudge.net/problem/HRBUST-1955
 * @author zhanyuhao
 *
 */
public class 问题1_数独游戏 {
	static int SIZE = 9;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();sc.nextLine();
		char[][] a = new char[SIZE][SIZE];
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < SIZE; i++) {
				a[i] = sc.nextLine().toCharArray();
			}
			dfs(a,0,0);
		}
		sc.close();
	}
	public static void dfs(char[][] arr,int x,int y) {
		if(x==SIZE){
			print(arr);
			System.exit(0);
		}
		if(arr[x][y] == '*') {
			for (int i = 1; i < SIZE + 1; i++) {
				if(check(arr,x,y,i)) {
					arr[x][y] = (char) (i+48);
					dfs(arr,x+(y+1)/SIZE,(y+1)%SIZE);
					arr[x][y] = '*';
				}
			}
		}else {
			dfs(arr,x+(y+1)/SIZE,(y+1)%SIZE);
		}
	}
	/**
	 * 检查n是否可以填在这个位置
	 * @param arr
	 * @param x
	 * @param y
	 * @param n 填的数字
	 * @return  可不可以填在arr[x][y]的位置
	 */
	private static boolean check(char[][] arr, int x, int y,int n) {
		char c = (char) (n+48);
		for (int i = 0; i < arr[x].length; i++) {//检查该行
			if(arr[x][i] == c) {
				return false;
			}
		}
		for (int i = 0; i < SIZE; i++) {//检查该列是否存在 c
			if(arr[i][y] == c) {
				return false;
			}
		}
		return true;
	}
	private static void print(char[][] arr) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
