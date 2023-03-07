package com.zyh.lanqiao.dataStruct.graph.bfs;

/**
 * D矩阵记录的是点到点之间的距离，
 * P矩阵记录的是从点到点经过哪个点使得距离最短 
 * 矩阵D和矩阵P进行N次更新
 *
 * 
 * @author zhanyuhao
 * @version 创建时间：2020年2月16日 下午11:52:49 类说明
 */
public class 图的最短路径_Floyd {
	static int[][] graph = { { 0, 2, 5, 0, 0, 0, 0 }, { 2, 0, 4, 6, 10, 0, 0 }, { 5, 4, 0, 2, 0, 0, 0 },
			{ 0, 6, 2, 0, 0, 1, 0 }, { 0, 10, 0, 0, 0, 3, 5 }, { 0, 0, 0, 1, 3, 0, 9 }, { 0, 0, 0, 0, 5, 9, 0 } };
	static int n = graph.length;
	static int[][] D = new int[n][n];
	static int[][] P = new int[n][n];

	public static void main(String[] args) {
		init();
		floyd();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%11d",D[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(P[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void floyd() {
		//矩阵D和矩阵P进行N次更新
		int select = 0;
		for (int v = 0; v < D.length; v++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < D.length; j++) {
					select = (D[i][v] == Integer.MAX_VALUE || D[v][j] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : (D[i][v]+D[v][j]);
					if(i!=j&&select < D[i][j]) {
						D[i][j] = select; 
						P[i][j] = v;
					}
				}
			}
		}
	}

	private static void init() {
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				P[row][col] = col;//  P矩阵初始化为目的点。
				if(graph[row][col]>0) {
					D[row][col] = graph[row][col];
				}else
					D[row][col] = Integer.MAX_VALUE;
			}
		}
	}

}
