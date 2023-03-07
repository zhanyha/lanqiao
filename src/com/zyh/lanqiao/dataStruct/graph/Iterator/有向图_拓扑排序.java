package com.zyh.lanqiao.dataStruct.graph.Iterator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class ”–œÚÕº_Õÿ∆À≈≈–Ú {

	private static class DirectedGraph {
		private TreeSet<Integer>[] treeSet;
		int V;
		int E;
		boolean[] visited;
		int[] indegree;
		int[] outdegree;
		private ArrayList<Integer> res = new ArrayList<Integer>();

		public DirectedGraph(Scanner sc) {
			V = sc.nextInt();
			E = sc.nextInt();
			treeSet = new TreeSet[V];
			indegree = new int[V];
			outdegree = new int[V];
			visited = new boolean[V];
			for (int i = 0; i < V; i++)
				treeSet[i] = new TreeSet<Integer>();
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				treeSet[a].add(b);
				indegree[b]++;
				outdegree[a]++;
			}
			topoSort();
		}

		private Iterable<Integer> topoSort() {
			Queue<Integer> que = new LinkedList<Integer>();
			for (int v = 0; v < V; v++) {
				if (indegree[v] == 0) {
					que.add(v);
					break;
				}
			}
			while (!que.isEmpty()) {
				int v = que.remove();
				visited[v] = true;
				res.add(v);
				for (int w : adj(v))
					indegree[w]--;
				for (int w = 0; w < V; w++) {
					if (!visited[w] && indegree[w] == 0) {
						que.add(w);
						break;
					}
				}
			}
			return res;
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
			return res;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DirectedGraph directedGraph = new DirectedGraph(sc);
		System.out.println(directedGraph.result());
		System.out.println(directedGraph.hasCycle());
	}

}
