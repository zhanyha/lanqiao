package com.zyh.lanqiao.dataStruct.graph.Iterator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
public class 无向图_DFS遍历_无向图的环检测 {
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
	static boolean cycleGraph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		g = new Graph(sc);
		vis = new int[g.V];
		pre = new int[g.V];
		for (int v = 0; v < vis.length; v++) {
			if(vis[v]==0) {
				if(dfs(v,v)) {
					cycleGraph = true;
					break;
				}
			}
		}
		System.out.println(cycleGraph);
		
	}

	private static boolean dfs(int v,int parent) {
		vis[v] = 1;
		pre[v] = parent;
		for (Integer e : g.adj(v)) {
			if(vis[e]==0) {
				if(dfs(e,v)) return true;
			}else {
				if(pre[v]!= e) 
					return true;
			}
		}
		return false;
	}

}
