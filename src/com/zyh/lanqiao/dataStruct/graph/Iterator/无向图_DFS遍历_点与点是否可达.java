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
public class 无向图_DFS遍历_点与点是否可达 {
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		g = new Graph(sc);
		vis = new int[g.V];
		int s = sc.nextInt();
		int t = sc.nextInt();
		boolean bool = dfs(s, t);
		System.out.println(bool);
	}

	private static boolean dfs(int s, int t) {
		if(s==t) return true;
		vis[s] = 1;
		for (Integer e : g.adj(s)) {
			if (vis[e] == 0) {
				if(dfs(e, t)) return true;
			}
		}
		return false;
	}

}
