package com.zyh.lanqiao.recursion;

import java.util.Scanner;
/**
 * M * N的方格，一个机器人从左上走到右下，只能向右或向下走。有多少种不同的走法？
 * 由于方法数量可能很大，只需要输出Mod 10^9 + 7的结果。
 * @author zhanyuhao
 *
 */
public class 问题2_机器人走方格 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int res1 = solution(N,M);
		System.out.println(res1);
//		int res = recursion(N,M);
//		System.out.println(res);
		sc.close();
	}
	private static int solution(int n, int m) {
		int[][] arr = new int[n][m];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = 1;
		}
		for (int i = 0; i < arr[0].length; i++) {
			arr[0][i] = 1;
		}
		int i=0,j=0;
		for ( i = 1; i < arr.length; i++) {
			for ( j = 1; j < arr[i].length; j++) {
				arr[i][j] = arr[i-1][j]+arr[i][j-1];
			}
		}
		return arr[arr.length-1][arr[0].length-1];
	}
	/**
	 * 递归方式，效率特别低
	 * @param n
	 * @param m
	 * @return 可选方式有几种
	 */
	private static int recursion(int n,int m) {
		if(n==1 || m == 1) {
			return 1;
		}
		return recursion(n-1,m)+recursion(n, m-1);
	}
	
}
