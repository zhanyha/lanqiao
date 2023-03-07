package com.zyh.lanqiao.dataStruct.graph.match;

import com.zyh.lanqiao.dataStruct.graph.store.Graph;

class Bipartite {
	private Graph g;
	private int[] vis;
	private int[] colors;
	private boolean bipartite = false;
	public Bipartite(Graph g) {
		this.g = g;
		vis = new int[g.V()];
		colors = new int[g.V()];
		bipartite = dfs(0,0);
	}
	
	private boolean dfs(int start, int color) {
		vis[start] = 1;
		colors[start] = color;
		for (Integer e : g.adj(start)) {
			if (vis[e] == 0) {
				if (!dfs(e, 1 - color))
					return false;
			}else if (colors[e] == color)
					return false;
		}
		return true;
	}
	public int[] colors(){
		return colors;
	}
	public boolean isBipratite() {
		return bipartite;
	}
}
