package com.zyh.lanqiao.dp;

import java.util.Scanner;

public class ����1_01���� {
	static Product[] arr;// ������Ʒ
	static int[][] memory;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new Product[n];
		memory = new int[n][m+1];
		for (int i = 0; i < n; i++) {
			arr[i] = new Product(sc.nextInt(), sc.nextInt());
		}
		int dfs = m(0, m, 0);
		System.out.println(dfs);
		sc.close();
	}
	/**
	 * �����͵ݹ� DFS�ǽ�ÿ��������Ľⶼ�������������û���ظ��������⣬�������Ϊ
	 * ���ܵ�ƿ���������͵ݹ���Խ���ظ������ⲻ���ٽ�������⡣
	 * @param V
	 * @param m
	 * @param cur
	 * @return
	 */
	private static int m(int V, int m, int cur) {
		if (m <= 0) {
			return 0;
		}
		if (cur == arr.length) {
			return V;
		}
		if(memory[cur][m] >0) {//��ѯ
			return memory[cur][m];
		}
		int v1 = dfs(V, m, cur + 1);
		int v2 = dfs(V + arr[cur].getV(), m - arr[cur].getW(), cur + 1);
		memory[cur][m] = Math.max(v1, v2); //��¼
		V -= arr[cur].getV();// ����
		m += arr[cur].getW();// ����
		return Math.max(v1, v2);
	}
	/**
	 * @param V   �ܼ�ֵ
	 * @param m   ʣ����Ż݄�������Ҳ���Ǳ���ʣ���������
	 * @param cur ���ڵ�ǰ��Ʒѡ���ǲ�ѡ
	 */
	private static int dfs(int V, int m, int cur) {
		if (m <= 0) {
			return 0;
		}
		if (cur == arr.length) {
			return V;
		}
		int v1 = dfs(V, m, cur + 1);
		int v2 = dfs(V + arr[cur].getV(), m - arr[cur].getW(), cur + 1);
		V -= arr[cur].getV();// ����
		m += arr[cur].getW();// ����
		return Math.max(v1, v2);
	}
}

class Product {
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

	public Product(int w, int v) {
		this.w = w;
		this.v = v;
	}

}