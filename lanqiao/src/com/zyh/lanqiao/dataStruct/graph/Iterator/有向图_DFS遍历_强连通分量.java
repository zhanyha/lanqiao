package com.zyh.lanqiao.dataStruct.graph.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class 有向图_DFS遍历_强连通分量 {
	private DirectedGraph g;
	private int[] visited;// 标记是否被访问，而且存储强连通分量的id
	private int V;
	private int E;
	private int scccount = 0;// 强连通分量的个数
	ArrayList<Integer>[] res;
	public 有向图_DFS遍历_强连通分量(DirectedGraph g) {
		this.V = g.V();
		this.E = g.E();
		this.g = g;
		visited = new int[V];
		res = new ArrayList[V];
		for(int i=0;i<V;i++)
			res[i] = new ArrayList<Integer>();
		Arrays.fill(visited, -1);
		g.reverseGraph();// 求反图
		ArrayList<Integer> post = g.post();// 后续遍历结果
		Collections.reverse(post);// 逆序
		// 接下来就是无向图求连通分量的思想
		g.reverseGraph();// 求反图
		for (int v: post) {
			if (visited[v] == -1) {
				dfs(v, scccount);
				++scccount;
			}
		}
	}

	private void dfs(int v, int scc) {
		visited[v] = scc;
		res[scc].add(v);
		for (int w : g.adj(v)) {
			if (visited[w] == -1)
				dfs(w, scc);
		}
	}

	public int scccount() {
		return scccount;
	}
	
	public Iterable<Integer> scc(int v){
		return res[v];
	}
	public static void main(String[] args) {
		DirectedGraph g = new DirectedGraph(new Scanner(System.in));
		有向图_DFS遍历_强连通分量 a = new 有向图_DFS遍历_强连通分量(g);
		System.out.println(a.scccount());
		for(int v=0;v<a.scccount();v++) {
			System.out.print(v+": ");
			for(int w:a.scc(v)) {
				System.out.print(w+" ");
			}
			System.out.println();
		}
	}

	static class DirectedGraph {
		int V;
		int E;
		TreeSet<Integer> treeSet[];
		boolean[] visited;
		ArrayList<Integer> res = new ArrayList<Integer>();

		public DirectedGraph(Scanner sc) {
			this.V = sc.nextInt();
			this.E = sc.nextInt();
			treeSet = new TreeSet[V];
			visited = new boolean[V];
			for (int i = 0; i < V; i++) {
				treeSet[i] = new TreeSet<Integer>();
			}
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				treeSet[a].add(b);
			}
		}

		public ArrayList<Integer> post() {
			for (int v = 0; v < V; v++) {
				if (!visited[v])
					dfs(v);
			}
			return res;
		}
		public void dfs(int v) {
			visited[v] = true;
			for (int w : adj(v)) {
				if (!visited[w]) {
					dfs(w);
				}
			}
			res.add(v);
		}

		public Iterable<Integer> adj(int v) {
			return treeSet[v];
		}

		public void reverseGraph() {
			TreeSet<Integer>[] rtreeSet = new TreeSet[V];
			for (int i = 0; i < V; i++) {
				rtreeSet[i] = new TreeSet<Integer>();
			}
			for (int v = 0; v < V; v++) {
				for (int w : adj(v)) {
					rtreeSet[w].add(v);
				}
			}
			treeSet = rtreeSet;
		}

		public int V() {
			return V;
		}

		public int E() {
			return E;
		}
	}
}
