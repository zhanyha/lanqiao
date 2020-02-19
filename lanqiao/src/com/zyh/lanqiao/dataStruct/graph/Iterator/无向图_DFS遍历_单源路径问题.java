package com.zyh.lanqiao.dataStruct.graph.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

//7 6
//0 1
//0 2
//1 3
//1 4
//2 3
//2 6
public class 无向图_DFS遍历_单源路径问题 {
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
	static int[] pre;
	static ArrayList<Integer> res= new ArrayList();;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		g = new Graph(sc);
		vis = new int[g.V];
		pre = new int[g.V];
		int s = sc.nextInt();
		Arrays.fill(pre, -1);
		dfs(s, s);
		for (int v = 0; v < g.V; v++) {
			res.clear();
			path(s, v);
			System.out.println(res);
		}
	}

	private static List<Integer> path(int s, int v) {
		if(pre[v]==-1) return res;
		while (v != s) {
			res.add(v);
			v = pre[v];
		}
		res.add(v);
		Collections.reverse(res);
		return res;
	}

	private static void dfs(int s, int parent) {
		vis[s] = 1;
		pre[s] = parent;
		for (Integer e : g.adj(s)) {
			if (vis[e] == 0)
				dfs(e, s);
		}
	}

}
