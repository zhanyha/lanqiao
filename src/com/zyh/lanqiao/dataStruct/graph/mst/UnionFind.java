package com.zyh.lanqiao.dataStruct.graph.mst;

public class UnionFind {
	public UFNode find(UFNode x) {
		UFNode p = x;
		while(p.parent != p) {
			p = p.parent;
		}
		return p;
	}
	public void union(UFNode x,UFNode y) {
		find(y).parent = find(x);
	}
}
