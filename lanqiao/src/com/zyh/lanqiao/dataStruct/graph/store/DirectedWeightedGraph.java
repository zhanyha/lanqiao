package com.zyh.lanqiao.dataStruct.graph.store;

import java.util.Scanner;
import java.util.TreeMap;

public class DirectedWeightedGraph {
	private int V;
	private int E;
	private TreeMap<Integer,Integer>[] treeMap;
	private int[] indegrees;
	private int[] outdegrees;
	public DirectedWeightedGraph(Scanner sc) {
		this.V = sc.nextInt();
		this.E = sc.nextInt();
		treeMap = new TreeMap[V];
		indegrees = new int[V];
		outdegrees = new int[V];
		for (int i = 0; i < V; i++)
			treeMap[i] = new TreeMap<Integer,Integer>();
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int weight = sc.nextInt();
			
			treeMap[a].put(b, weight);
			indegrees[b]++;
			outdegrees[a]++;
		}
	}
	public DirectedWeightedGraph(int v) {
		this.E = 0;
		this.V = v;
		this.treeMap = new TreeMap[v];
		for(int i=0;i<v;i++){
			this.treeMap[i] = new TreeMap<Integer, Integer>();
		}
		this.indegrees = new int[v];
		this.outdegrees = new int[v];
	}
	public int V() {
		return V;
	}

	public int E() {
		return E;
	}
	public int indegree(int v) {
		return indegrees[v];
	}
	public int outdegree(int v) {
		return outdegrees[v];
	}
	public boolean hasEdge(int v1, int v2) {
		return treeMap[v1].containsKey(v2);
	}
	
	public void removeEdge(int v, int w) {
		treeMap[v].remove(w);
		indegrees[w]--;
		outdegrees[v]--;
	}
	public void addEdge(int v, int w,int weight) {
		treeMap[v].put(w, weight);
		indegrees[w]++;
		outdegrees[v]++;
		this.E++;
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
	public void setWeight(int v,int w,int neWeight) {
		treeMap[v].put(w, neWeight);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("V = %d,E = %d\n", V, E));
		for (int v = 0; v < V; v++) {
			sb.append(String.format("%d: ", v));
			for (int w : adj(v)) {
				sb.append(String.format("(%d: %d) ", w,getWeight(v, w)));
			}
			sb.append("\n");
		}
		return sb.toString();
	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		DirectedWeightedGraph g = new DirectedWeightedGraph(sc);
//		System.out.println(g);
//		System.out.println(g.adj(1));
//		System.out.println(g.hasEdge(3, 5));
//	}
}
