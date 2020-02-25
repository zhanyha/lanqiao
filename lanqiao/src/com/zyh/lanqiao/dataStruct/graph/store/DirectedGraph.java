package com.zyh.lanqiao.dataStruct.graph.store;

import java.util.Scanner;
import java.util.TreeSet;

public class DirectedGraph implements Cloneable {
	private int V;
	private int E;
	private TreeSet<Integer>[] treeSet;
	private int[] indegrees;
	private int[] outdegrees;
	public DirectedGraph(Scanner sc) {
		this.V = sc.nextInt();
		this.E = sc.nextInt();
		treeSet = new TreeSet[V];
		indegrees = new int[V];
		outdegrees = new int[V];
		for (int i = 0; i < V; i++)
			treeSet[i] = new TreeSet<Integer>();
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			treeSet[a].add(b);
			indegrees[b]++;
			outdegrees[a]++;
		}
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
		return treeSet[v1].contains(v2);
	}
	

	/**
	 * @param v
	 * @return 返回节点的所有孩子
	 */
	public Iterable<Integer> adj(int v) {
		return treeSet[v];
	}

	public void removeEdge(int v, int w) {
		treeSet[v].remove(w);
	}

	@Override
	public Object clone() {
		DirectedGraph g = null;
		try {
			g = (DirectedGraph) super.clone();
			g.treeSet = new TreeSet[g.V];
			for (int v = 0; v < V; v++) {
				g.treeSet[v] = new TreeSet<Integer>();
				for (int w : this.treeSet[v]) {
					g.treeSet[v].add(w);
				}
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return g;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("V = %d,E = %d\n", V, E));
		for (int v = 0; v < V; v++) {
			sb.append(String.format("%d: ", v));
			for (int w : adj(v)) {
				sb.append(String.format("%d ", w));
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DirectedGraph g = new DirectedGraph(sc);
		System.out.println(g);
		System.out.println(g.adj(1));
		System.out.println(g.hasEdge(1, 3));
	}
}
