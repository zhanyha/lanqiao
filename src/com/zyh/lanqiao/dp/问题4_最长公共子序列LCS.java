package com.zyh.lanqiao.dp;

import java.util.Scanner;

public class 问题4_最长公共子序列LCS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		String res = LCS(s1, s2);
		System.out.println(res);
		sc.close();
	}

	private static String LCS(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		int[][] dp = new int[len2][len1];
		int flag = 0;
		for (int i = 0; i < len1; i++) {
			if (flag == 0) {
				if (s2.charAt(0) == s1.charAt(i)) {
					flag = 1;
					dp[0][i] = 1;
				}
			} else {
				dp[0][i] = 1;
			}
		}
		flag = 0;
		for (int i = 0; i < len2; i++) {
			if (flag == 0) {
				if (s2.charAt(i) == s1.charAt(0)) {
					flag = 1;
					dp[i][0] = 1;
				}
			} else {
				dp[i][0] = 1;
			}
		}
		for (int i = 1; i < len2; i++) {
			for (int j = 1; j < len1; j++) {
				if (s2.charAt(i) == s1.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return parseDp(dp, s1, s2);
	}

	private static String parseDp(int[][] dp, String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		int i=s1.length()-1,j=s2.length()-1;
		while(i>0 && j>0) {
			if (s1.charAt(i) == s2.charAt(j)) {
				sb.append(s1.charAt(i));
				i--;
				j--;
			} else if (dp[j-1][i] < dp[j][i-1]) {// 往上走
				i--;
			} else {//往左走
				j--;
			}
		}
		if(sb.length()>0) {
			if(i==0 && dp[0][j]==1) {
				sb.append(s1.charAt(0));
			}else if(j==0 && dp[j][0]==1){
				sb.append(s2.charAt(0));
			}
		}
		return sb.reverse().toString();
	}

}
