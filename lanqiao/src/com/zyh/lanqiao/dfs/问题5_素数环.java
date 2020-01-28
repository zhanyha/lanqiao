package com.zyh.lanqiao.dfs;

import java.util.Scanner;

/**
 * 问题描述：输入一个整数n，从1-n当中选择数字组成一个环，使得任何相邻的两个
 * 数的和为素数。（输出所有可能，无解输出no solution）
 * 输入：6
 * 输出：3，4，1，2，5，6
 * @author zhanyuhao
 *
 */
public class 问题5_素数环 {
	static int[] arr;
	static int N;
	static int cnt=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] ans = new int[N];
			dfs(ans,0);
		System.out.println(cnt);
		sc.close();
	}
	private static void dfs(int[] ans,int cur) {
		if(cur == N) {
			print(ans);
			cnt++;
			return ;
		}
		for (int i = 1; i <= N; i++) {
			if(check(ans,cur,i)) {
				ans[cur] =  i;
				dfs(ans,cur+1);
				ans[cur] = 0;
			}
		}
		
	}
	private static boolean check(int[] ans,int cur, int num) {
		for (int i = 0; i < ans.length; i++) {
			if(ans[i] == num) return false;
		}
		if(cur == N-1) {
			return isPrime(ans[0]+num) && isPrime(ans[N-2]+num);
		}
		if(cur == 0)
			return true;
		return isPrime(ans[cur-1]+num);
	}
	private static boolean isPrime(int i) {
		if(i<=1)return false;
		if(i==2||i==3) return true;
		if(i%6 != 1 && i%6!=5) return false;
		for (int j = 5; j <=Math.sqrt(i); j+=6) {
			if(i%j == 0 || i%(j+2) == 0) {
				return false;
			}
		}
		return true;
	}
	private static void print(int[] arr) {
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
