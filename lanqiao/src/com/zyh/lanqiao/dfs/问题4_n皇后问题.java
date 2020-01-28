package com.zyh.lanqiao.dfs;

import java.util.Scanner;
/**
 * https://vjudge.net/problem/HDU-2553
 * �����޵ĸ������������Ч�Ľ����ʱ����
 * @author zhanyuhao
 *
 */
//1 ,0, 0,2,10,4,40,92,352,724
public class ����4_n�ʺ����� {
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
	 * @return �Ƿ���Խ��ʺ���ڸ�λ�ã�x,y��
	 */
	private static boolean check(int N,int x, int y) {
		if(x>=N || y>=N) return false;
		//��������Խ��ߺ͸���
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
