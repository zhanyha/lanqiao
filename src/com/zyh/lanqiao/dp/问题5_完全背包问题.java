package com.zyh.lanqiao.dp;

import java.util.Scanner;
/**
 * ����������Ʒ����������������Wֵ����V�����ֵ
 * @author zhanyuhao
 *
 */
//4 5
//2 3
//1 2
//3 4
//2 2
public class ����5_��ȫ�������� {
	static Product2[] arr;// ������Ʒ
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
		int[][] dp = new int[n][W+1];//W+1��ԭ����dp���0��ʼ
		//��ʼ��dp��ĵ�һ��
		for (int i = 0; i < W+1; i++) {
			if(i>=arr[0].getW()) {//Ҫ�����һ����Ʒ
				dp[0][i] = arr[0].getV()*(i/arr[0].getW());//�����õ��𼸸�
			}else {
				dp[0][i] = 0;
			}
		}
		//�ӵڶ��п�ʼ��������һ���Ľ�����Ƴ���һ���Ľ��
		int v1=0;
		int v2=0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < W+1; j++) {
				//�ж��Ƿ�Ҫ����ǰ�Ŀ�ѡ��Ʒ
				if(j>=arr[i].getW()) {
					//���Ҫ����,v1=
					v1 = dp[i][j-arr[i].getW()]+arr[i].getV();
					v2 = dp[i-1][j];
				}else {
					//���Ҫ����,v2=
					v2 = dp[i-1][j];
				}
				//dp��ĵ�ǰλ��ȡMax(v1,v2);
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
		return dp[n-1][W];//��������һ��λ��
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
