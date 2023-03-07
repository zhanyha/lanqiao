package com.zyh.lanqiao.dataStruct.graph.Hamilton;

public class Q980_²»Í¬Â·¾¶III {
	private int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private int[][] grid;
	private int R;
	private int C;
	private boolean[][] visited;
	private int start;
	private int end;
	private int left;

	public int uniquePathsIII(int[][] grid) {
		this.grid = grid;
		R = grid.length;
		C = grid[0].length;
		visited = new boolean[R][C];
		left = R * C;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 1) {
					start = i * C + j;
					grid[i][j] = 0;
				} else if (grid[i][j] == 2) {
					end = i * C + j;
					grid[i][j] = 0;
				} else if (grid[i][j] == -1) {
					left--;
				}
			}
		}
		return dfs(start, left);
	}

	private int dfs(int v, int left2) {
		int res=0;
		int x = v / C;
		int y = v % C;
		visited[x][y] = true;
		left2--;
		if (v == end) {
			if(left2==0)
				return 1;
			else
				return 0;
		}
		for (int d = 0; d < 4; d++) {
			int nextx = x + dirs[d][0];
			int nexty = y + dirs[d][1];
			if (inArea(nextx, nexty) && !visited[nextx][nexty] && grid[nextx][nexty] != -1) {
				res+=dfs(nextx * C + nexty, left2);
				visited[nextx][nexty] = false;
			}
		}
		
		return res;
	}

	private boolean inArea(int nextx, int nexty) {
		return nextx >= 0 && nextx < R && nexty >= 0 && nexty < C;
	}
}
