package com.zyh.lanqiao.dp;

import java.util.Scanner;

/**
 * https://vjudge.net/problem/51Nod-1134
 * @author zhanyuhao
 *
 */
public class 问题6_最长递增子序列 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int max = solution(arr);
		System.out.println(max);
		sc.close();
	}

	private static int solution(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0]=1;
		int max = 0;
		int flag = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j] && dp[j]+1 > max) {
					dp[i]=dp[j]+1;
					max = dp[i];
					flag = 1;
				}
			}
			if(flag == 0) {
				dp[i] = 1;
			}
			flag = 0;
			max = 0;
		}
		max = 0;
		for (int i = 0; i < dp.length; i++) {
			if(max<dp[i]) {
				max = dp[i];
			}
		}
		return max;
	}

}
