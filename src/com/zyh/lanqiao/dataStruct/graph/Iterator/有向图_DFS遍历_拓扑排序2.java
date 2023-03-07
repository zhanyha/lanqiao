package com.zyh.lanqiao.dataStruct.graph.Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class ”–œÚÕº_DFS±È¿˙_Õÿ∆À≈≈–Ú2 {

	private static class DirectedGraph {
		private TreeSet<Integer>[] treeSet;
		int V;
		int E;
		boolean[] visited;
		private ArrayList<Integer> res = new ArrayList<Integer>();

		public DirectedGraph(Scanner sc) {
			V = sc.nextInt();
			E = sc.nextInt();
			treeSet = new TreeSet[V];
			visited = new boolean[V];
			for (int i = 0; i < V; i++)
				treeSet[i] = new TreeSet<Integer>();
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				treeSet[a].add(b);
			}
			dfs(0);
		}

		private void dfs(int v) {
			visited[v] = true;
			for (int w : adj(v)) {
				if (!visited[w]) {
					dfs(w);
				}
			}
			res.add(v);
		}

		private Iterable<Integer> adj(int v) {
			return treeSet[v];
		}

		public boolean hasCycle() {
			if (res.size() != V) {
				return true;
			} else
				return false;
		}

		public Iterable<Integer> result() {
			if (hasCycle())
				res.clear();
			Collections.reverse(res);
			return res;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DirectedGraph directedGraph = new DirectedGraph(sc);
		System.out.println(directedGraph.result());
	}

}
