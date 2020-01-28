package com.zyh.lanqiao.recursion;

import java.util.Scanner;

public class 问题1_上楼梯 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean next = sc.hasNext();
		int N = 0;
		if(next) {
			N = sc.nextInt();
			System.out.println(solution(N));
		}
		sc.close();
	}

	/**
	 * 迭代方式
	 * @param n
	 * @return
	 */
	private static int solution(int n) {
		int[] arr = new int[n];
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i < arr.length; i++) {
			arr[i] = arr[i-1] + arr[i - 2];
		}
		return arr[n-1];
	}
	/**
	 * 递归方式
	 * @param n
	 * @return
	 */
	private static int recursion(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 3;
		return recursion(n-1)+recursion(n-2);
	}

}
