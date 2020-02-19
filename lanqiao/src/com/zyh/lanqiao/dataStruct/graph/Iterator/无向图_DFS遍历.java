package com.zyh.lanqiao.dataStruct.graph.Iterator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class ÎÞÏòÍ¼_DFS±éÀú {
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
	static ArrayList<Integer> res = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		g = new Graph(sc);
		vis = new int[g.V];
		dfs(0);
		for (Integer e : res) {
			System.out.print(e+" ");
		}
	}

	private static void dfs(int start) {
		vis[start] = 1;
		res.add(start);
		for (Integer e : g.adj(start)) {
			if(vis[e]==0)
				dfs(e);
		}
	}

}
