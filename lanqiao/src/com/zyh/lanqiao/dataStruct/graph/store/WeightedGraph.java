package com.zyh.lanqiao.dataStruct.graph.store;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class WeightedGraph {
	private int V;
	private int E;
	private TreeMap<Integer, Integer>[] treeMap;

	public WeightedGraph(Scanner sc) {
		this.V = sc.nextInt();
		this.E = sc.nextInt();
		treeMap = new TreeMap[V];
		for (int i = 0; i < V; i++)
			treeMap[i] = new TreeMap<Integer, Integer>();
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int weight = sc.nextInt();
			treeMap[a].put(b, weight);
			treeMap[b].put(a, weight);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public boolean hasEdge(int v1, int v2) {
		return treeMap[v1].containsKey(v2);
	}

	/**
	 * @param v
	 * @return 返回节点的所有孩子
	 */
	public Iterable<Integer> adj(int v) {
		return treeMap[v].keySet();
	}
	
	public int getWeight(int v,int w) {
		return treeMap[v].get(w);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("V = %d,E = %d\n", V, E));
		for (int v = 0; v < V; v++) {
			sb.append(String.format("%d: ", v));
			for (Entry<Integer,Integer> e : treeMap[v].entrySet()) {
				sb.append(String.format("(%d: %d) ", e.getKey(),e.getValue()));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WeightedGraph g = new WeightedGraph(sc);
		System.out.println(g);
		System.out.println(g.adj(2));
		System.out.println(g.hasEdge(2 , 3));
		System.out.println(g.getWeight(2 , 3));
	}
}
