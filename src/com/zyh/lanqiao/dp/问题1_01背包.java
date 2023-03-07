package com.zyh.lanqiao.dp;

import java.util.Scanner;

public class 问题1_01背包 {
	static Product[] arr;// 所有商品
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
	 * 记忆型递归 DFS是将每个子问题的解都求出来，不管有没有重复的子问题，所以这成为
	 * 性能的瓶颈，记忆型递归可以解决重复子问题不用再解决的问题。
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
		if(memory[cur][m] >0) {//查询
			return memory[cur][m];
		}
		int v1 = dfs(V, m, cur + 1);
		int v2 = dfs(V + arr[cur].getV(), m - arr[cur].getW(), cur + 1);
		memory[cur][m] = Math.max(v1, v2); //记录
		V -= arr[cur].getV();// 回溯
		m += arr[cur].getW();// 回溯
		return Math.max(v1, v2);
	}
	/**
	 * @param V   总价值
	 * @param m   剩余的优惠劵数量（也就是背包剩余的重量）
	 * @param cur 对于当前商品选还是不选
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
		V -= arr[cur].getV();// 回溯
		m += arr[cur].getW();// 回溯
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