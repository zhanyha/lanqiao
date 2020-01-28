package com.zyh.lanqiao.dfs;

import java.util.Scanner;
/**
 * https://vjudge.net/problem/HDU-2553
 * 在有限的个数里，打表可以有效的解决超时问题
 * @author zhanyuhao
 *
 */
//1 ,0, 0,2,10,4,40,92,352,724
public class 问题4_n皇后问题 {
	static int cnt = 0;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while(N != 0) {
			cnt = 0;
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				dfs(N,0,i);
			}
			System.out.println(cnt);
			N = sc.nextInt();
		}
		sc.close();
	}
	private static void dfs(int N,int x,int y) {
		if(x >= N && y == 0) {
			cnt++;
			return;
		}
		if(x >= N && y > 0) {
			return;
		}
		if(check(N,x,y)) {
			arr[x][y] = 1;
			for (int j = 0; j < arr.length; j++) {
					dfs(N,x+1,j);
			}
			arr[x][y] = 0;
		}
		
	}
	private static void print(int[][] arr2) {
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				System.out.print(arr2[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return 是否可以将皇后放在该位置（x,y）
	 */
	private static boolean check(int N,int x, int y) {
		if(x>=N || y>=N) return false;
		//检查主副对角线和该列
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if((i-j) == (x-y) && arr[i][j] == 1) {
					return false;
				}
				if((i+j) == (x+y) && arr[i][j] == 1) {
					return false;
				}
			}
			if(arr[i][y] == 1) {
				return false;
			}
		}
		return true;
	}
}
