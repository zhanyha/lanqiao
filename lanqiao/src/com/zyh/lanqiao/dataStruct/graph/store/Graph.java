package com.zyh.lanqiao.dataStruct.graph.store;

import java.util.Scanner;
import java.util.TreeSet;
/**
 * 无向无权图的存储
* @author zhanyuhao
* @version 创建时间：2020年2月25日 下午4:46:03
* 类说明
 */
public class Graph implements Cloneable {
	private int V;
	private int E;
	private TreeSet<Integer>[] treeSet;

	public Graph(Scanner sc) {
		this.V = sc.nextInt();
		this.E = sc.nextInt();
		treeSet = new TreeSet[V];
		for (int i = 0; i < V; i++)
			treeSet[i] = new TreeSet<Integer>();
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			treeSet[a].add(b);
			treeSet[b].add(a);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public boolean hasEdge(int v1, int v2) {
		return treeSet[v1].contains(v2);
	}

	public int degree(int v) {
		return treeSet[v].size();
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
		treeSet[w].remove(v);
	}

	@Override
	public Object clone() {
		Graph g = null;
		try {
			g = (Graph) super.clone();
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
		Graph g = new Graph(sc);
		System.out.println(g);
		System.out.println(g.adj(2));
		System.out.println(g.hasEdge(2, 3));
	}
}
