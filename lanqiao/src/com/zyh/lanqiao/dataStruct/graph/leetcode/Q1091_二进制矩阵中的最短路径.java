package com.zyh.lanqiao.dataStruct.graph.leetcode;

import java.util.LinkedList;
import java.util.Queue;

//Solution
public class Q1091_二进制矩阵中的最短路径 {
	private int[][] grid;
	private int R;
	private int C;
	private boolean[][] visited;
	private int[][] depth;
	public int shortestPathBinaryMatrix(int[][] grid) {
		this.grid = grid;
		this.R = grid.length;
		this.C = grid[0].length;
		visited = new boolean[R][C];
		depth = new int[R][C];
		bfs(0,0);
		return 0;
	}
	private int bfs(int x,int y) {
		if(grid[x][y]==1) return -1;
		if(grid[x][y]==0 && R==1&&C==1) return 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x*R+y);
		visited[x][y]=true;
		depth[x][y]=1;
		int nextx=x;
		int nexty=y;
		int poll;
		while(!queue.isEmpty()) {
			poll = queue.remove();
			x=poll/R;
			y=poll%R;
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					nextx = x+i;
					nexty = y+j;
					if(inArea(nextx,nexty) && visited[nextx][nexty]==false && grid[nextx][nexty]==0) {
						queue.add(nextx*R+nexty);
						visited[nextx][nexty] = true;
						depth[nextx][nexty] = depth[x][y]+1;
						if(nextx==R-1 &&nexty==C-1)
							return depth[nextx][nexty];
					}
				}
			}
		}
		return -1;
	}
	private boolean inArea(int nextx, int nexty) {
		return nextx>=0 && nextx<=R &&nexty>=0 &&nexty<=C;
	}
}
