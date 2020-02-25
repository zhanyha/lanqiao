package com.zyh.lanqiao.dataStruct.graph.sp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import com.zyh.lanqiao.dataStruct.graph.store.WeightedGraph;


public class BellmanFord02 {
	private int V;
	private int E;
	private int[] dis;
	private int s;
	private boolean hasNegativeCycle = false;
	private int[] pre;
	public BellmanFord02(WeightedGraph g, int s) {
		this.V = g.V();
		this.E = g.E();
		this.s = s;
		dis = new int[V];
		pre = new int[V];
		// bellmanFord算法的初始化
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[s] = 0;

		// 进行V-1次的松弛操作
		for (int pass = 1; pass < V; pass++) {

			for (int v = 0; v < V; v++) {
				for (int w : g.adj(v)) {
					if (dis[v]!=Integer.MAX_VALUE && dis[v] + g.getWeight(v, w) < dis[w]) {
						dis[w] = dis[v] + g.getWeight(v, w);
						pre[w] = v;
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
	public Iterable<Integer> path(int v){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(!isConnectedTo(v)) return res;
		int cur = v;
		while(cur!=s) {
			res.add(cur);
			cur = pre[cur];
		}
		res.add(cur);
		Collections.reverse(res);
		return res;
	}
	public static void main(String[] args) {
		WeightedGraph g =new WeightedGraph(new Scanner(System.in));
		BellmanFord02 bf = new BellmanFord02(g, 0);
		if(!bf.hasNegativeCycle) {
			for (int v = 0; v < g.V(); v++) {
				System.out.print(bf.pathTo(v) + " ");
			}
			System.out.println();
			System.out.println("from 0 to 3: "+bf.path(3));
		}else {
			System.out.println("exists negative weighted cycle");
		}
		
	}
}
