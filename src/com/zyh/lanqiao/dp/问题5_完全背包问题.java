package com.zyh.lanqiao.dp;

import java.util.Scanner;
/**
 * 给定几种物品，不限数量，给定W值，求V的最大值
 * @author zhanyuhao
 *
 */
//4 5
//2 3
//1 2
//3 4
//2 2
public class 问题5_完全背包问题 {
	static Product2[] arr;// 所有商品
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int W = sc.nextInt();
		arr = new Product2[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Product2(sc.nextInt(), sc.nextInt());
		}
		int res = dp(arr,n,W);
		System.out.println(res);
		sc.close();
	}
	private static int dp(Product2[] arr,int n,int W) {
		int[][] dp = new int[n][W+1];//W+1的原因是dp表从0开始
		//初始化dp表的第一行
		for (int i = 0; i < W+1; i++) {
			if(i>=arr[0].getW()) {//要的起第一个商品
				dp[0][i] = arr[0].getV()*(i/arr[0].getW());//可以拿的起几个
			}else {
				dp[0][i] = 0;
			}
		}
		//从第二行开始，根据上一步的结果，推出这一步的结果
		int v1=0;
		int v2=0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < W+1; j++) {
				//判断是否要的起当前的可选商品
				if(j>=arr[i].getW()) {
					//如果要的起,v1=
					v1 = dp[i][j-arr[i].getW()]+arr[i].getV();
					v2 = dp[i-1][j];
				}else {
					//如果要不起,v2=
					v2 = dp[i-1][j];
				}
				//dp表的当前位置取Max(v1,v2);
				dp[i][j] = Math.max(v1, v2);
			}
			v1=0;
			v2=0;
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < W+1; j++) {
//				System.out.printf("%3d",dp[i][j]);
//			}
//			System.out.println();
//		}
		return dp[n-1][W];//结果在最后一个位置
	}
}
class Product2 {
	private int w;
	private int v;

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public Product2(int w, int v) {
		this.w = w;
		this.v = v;
	}

}
