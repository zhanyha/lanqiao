package com.zyh.lanqiao.recursion;

import java.util.Scanner;
/**
 * M * N�ķ���һ�������˴������ߵ����£�ֻ�����һ������ߡ��ж����ֲ�ͬ���߷���
 * ���ڷ����������ܴܺ�ֻ��Ҫ���Mod 10^9 + 7�Ľ����
 * @author zhanyuhao
 *
 */
public class ����2_�������߷��� {
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
	 * �ݹ鷽ʽ��Ч���ر��
	 * @param n
	 * @param m
	 * @return ��ѡ��ʽ�м���
	 */
	private static int recursion(int n,int m) {
		if(n==1 || m == 1) {
			return 1;
		}
		return recursion(n-1,m)+recursion(n, m-1);
	}
	
}
