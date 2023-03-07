package com.zyh.lanqiao.dataStruct.graph.Iterator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
public class 无向图_DFS遍历_连通分量个数 {
	private static class Graph {
		int V;
		int E;
		TreeSet<Integer> treeSet[];

		public Graph(Scanner sc) {
			this.V = sc.nextInt();
			this.E = sc.nextInt();
			treeSet = new TreeSet[V];
			for (int i = 0; i < V; i++) {
				treeSet[i] = new TreeSet<Integer>();
			}
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				treeSet[a].add(b);
				treeSet[b].add(a);
			}
		}
		public TreeSet<Integer> adj(int i) {
			return treeSet[i];
		}
	}

	static Graph g;
	static int[] vis;
	static int cccount=-1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		g = new Graph(sc);
		vis = new int[g.V];
		Arrays.fill(vis, -1);
		for (int i = 0; i < vis.length; i++) {
			if(vis[i]==-1)
				dfs(i,++cccount);
		}
		System.out.println(cccount+1);
	}

	private static void dfs(int start,int cccount) {
		vis[start] = cccount;
		for (Integer e : g.adj(start)) {
			if(vis[e]==-1)
				dfs(e,cccount);
		}
	}

}
