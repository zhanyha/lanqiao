package com.zyh.lanqiao.dataStruct.graph.mst;

public class WeightedEdge implements Comparable<WeightedEdge>{
	int v;
	int w;
	int weight;
	public WeightedEdge(int v, int w, int weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	@Override
	public int compareTo(WeightedEdge o) {
		return this.weight - o.weight;
	}
}
