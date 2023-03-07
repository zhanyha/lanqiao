package com.zyh.lanqiao.dp;

import java.util.Scanner;

public class 问题6_最长递增子序列II {

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
		int p = 0;
		dp[0] = arr[0];
		p++;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > dp[p-1]) {
				dp[p] = arr[i];
				p++;
			}else {
				//更新dp数组中第一个大于arr[i]的数字
				for (int j = 0; j < p; j++) {
					if(dp[j] > arr[i]) {
						dp[j] = arr[i];
						break;
					}
				}
			}
		}
		return p;
	}

}
