package com.zyh.lanqiao.dataStruct.graph.store;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class 有向有权图 {
	static WeightedGraph g;
	static int[] vis;
	private static class WeightedGraph {
		int V;
		int E;
		TreeMap<Integer,Integer> treeMap[];

		public WeightedGraph(Scanner sc) {
			this.V = sc.nextInt();
			this.E = sc.nextInt();
			treeMap = new TreeMap[V];
			for (int i = 0; i < V; i++) {
				treeMap[i] = new TreeMap<Integer,Integer>();
			}
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int weight = sc.nextInt();
				treeMap[a].put(b, weight);
//				treeMap[b].put(a, weight);
			}
		}
		public Integer getWeight(int v,int w) {
			return treeMap[v].get(w);
		}
		public Iterable<Integer> adj(int i) {
			return treeMap[i].keySet();
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("V: %d,E :%d\n",V,E));
			for (int i = 0; i < V; i++) {
				sb.append(String.format("v = %d: ", i));
				for (Entry<Integer, Integer> entry : treeMap[i].entrySet()) {
					sb.append(String.format("(%d : %d) ", entry.getKey(),entry.getValue()));
				}
				sb.append("\n");
			}
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		g = new WeightedGraph(sc);
		System.out.println(g);
		System.out.println(g.adj(0));
	}
}
