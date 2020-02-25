package com.zyh.lanqiao.dataStruct.graph.store;


import java.util.Scanner;
import java.util.TreeSet;

public class 有向无权图 {
	private static class DirectedGraph {
		int V;
		int E;
		TreeSet<Integer> treeSet[];
		int[] indegree;
		int[] outdegree;
		public DirectedGraph(Scanner sc) {
			this.V = sc.nextInt();
			this.E = sc.nextInt();
			treeSet = new TreeSet[V];
			indegree = new int[V];
			outdegree = new int[V];
			for (int i = 0; i < V; i++) {
				treeSet[i] = new TreeSet<Integer>();
			}
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				treeSet[a].add(b);
				indegree[b]++;
				outdegree[a]++;
			}
		}
		public Iterable<Integer> adj(int v) {
			return treeSet[v];
		}
		public int indegree(int v) {
			return indegree[v];
		}
		public int outdegree(int v) {
			return outdegree[v];
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("V: %d,E :%d\n",V,E));
			for (int v = 0; v < V; v++) {
				sb.append(String.format("v = %d: ", v));
				for(int w:adj(v)) {
					sb.append(String.format("%d ", w));
				}
				sb.append("\n");
			}
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DirectedGraph directedGraph = new DirectedGraph(sc);
		System.out.println(directedGraph);
		System.out.println(directedGraph.indegree[2]);
		System.out.println(directedGraph.outdegree[3]);
	}
}
