package com.zyh.lanqiao.dataStruct.graph.sp;

import java.util.Arrays;
import java.util.Scanner;

import com.zyh.lanqiao.dataStruct.graph.store.WeightedGraph;


public class BellmanFord {
	private int V;
	private int E;
	private int[] dis;
	private boolean hasNegativeCycle = false;
	public BellmanFord(WeightedGraph g, int s) {
		this.V = g.V();
		this.E = g.E();
		dis = new int[V];
		// bellmanFord算法的初始化
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[s] = 0;

		// 进行V-1次的松弛操作
		for (int pass = 1; pass < V; pass++) {

			for (int v = 0; v < V; v++) {
				for (int w : g.adj(v)) {
					if (dis[v]!=Integer.MAX_VALUE && dis[v] + g.getWeight(v, w) < dis[w]) {
						dis[w] = dis[v] + g.getWeight(v, w);
					}
				}
			}
		}
		//如果在进行一次松弛操作还能更新dis数组的话，说明存在负权边
		for (int v = 0; v < V; v++) {
			for (int w : g.adj(v)) {
				if (dis[v]!=Integer.MAX_VALUE && dis[v] + g.getWeight(v, w) < dis[w])
					hasNegativeCycle = true;
			}
		}
	}
	public boolean hasNegCycle() {
		return hasNegativeCycle;
	}
	public boolean isConnectedTo(int v) {
		return dis[v]!=Integer.MAX_VALUE;
	}
	public int pathTo(int v) {
		if(isConnectedTo(v))
			return dis[v];
		return -1;
	}
	public static void main(String[] args) {
		WeightedGraph g =new WeightedGraph(new Scanner(System.in));
		BellmanFord bf = new BellmanFord(g, 0);
		for(int v=0;v<g.V();v++) {
			System.out.print(bf.pathTo(v)+" ");
		}
		System.out.println();
	}
}
