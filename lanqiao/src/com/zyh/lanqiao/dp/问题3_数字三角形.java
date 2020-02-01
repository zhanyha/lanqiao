package com.zyh.lanqiao.dp;

import java.util.Scanner;

/**
 * https://vjudge.net/problem/POJ-1163
 * @author zhanyuhao
 *
 */
//5
//7
//3 8
//8 1 0 
//2 7 4 4
//4 5 2 6 5
public class ����3_���������� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = new int[i+1];
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int res = solution(arr,n);
		System.out.println(res);
		sc.close();
	}

	private static int solution(int[][] arr,int n) {
		int[][] dp = new int[n][n];
		//��ʼ��
		dp[n-1] = new int[n];
		for (int i = 0; i < n; i++) {
			dp[n-1][i] = arr[n-1][i];
		}
		for (int i = n-2; i >=0 ; i--) {//�ӵ����ڶ��п�ʼ
			dp[i] = new int[i+1];
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = arr[i][j]+Math.max(dp[i+1][j],dp[i+1][j+1]);
			}
		}
		return dp[0][0];
	}

}
