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
		// bellmanFord�㷨�ĳ�ʼ��
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[s] = 0;

		// ����V-1�ε��ɳڲ���
		for (int pass = 1; pass < V; pass++) {

			for (int v = 0; v < V; v++) {
				for (int w : g.adj(v)) {
					if (dis[v]!=Integer.MAX_VALUE && dis[v] + g.getWeight(v, w) < dis[w]) {
						dis[w] = dis[v] + g.getWeight(v, w);
					}
				}
			}
		}
		//����ڽ���һ���ɳڲ������ܸ���dis����Ļ���˵�����ڸ�Ȩ��
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
