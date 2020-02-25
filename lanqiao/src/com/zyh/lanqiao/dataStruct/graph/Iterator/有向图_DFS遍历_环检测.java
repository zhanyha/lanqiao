package com.zyh.lanqiao.dataStruct.graph.Iterator;

import java.util.Scanner;
import java.util.TreeSet;

public class 有向图_DFS遍历_环检测 {
	
	private static class DirectedGraph {
		private boolean hasCycle;
		private TreeSet<Integer>[] treeSet;
		boolean[] visited;
		boolean[] onPath;
		int V;
		int E;
		public DirectedGraph(Scanner sc) {
			V = sc.nextInt();
			E = sc.nextInt();
			treeSet = new TreeSet[V];
			visited = new boolean[V];
			onPath = new boolean[V];
			for (int i = 0; i < V; i++) 
				treeSet[i] = new TreeSet<Integer>();
			for (int i = 0; i < E; i++)
				treeSet[sc.nextInt()].add( sc.nextInt());
			dfs(0,0);
		}
		private boolean dfs(int v,int parent) {
			visited[v] = true;
			onPath[v] = true;
			for(int w : adj(v)) {
				if(!visited[w]) {
					visited[w] = true;
					onPath[v] = true;
					if(dfs(w,v))
						return true;
					onPath[v] = false;
				}else if(onPath[w]) {
					hasCycle = true;
					return true;
				}
			}
			return false;
		}
		private Iterable<Integer> adj(int v){
			return treeSet[v];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DirectedGraph directedGraph = new DirectedGraph(sc);
		System.out.println(directedGraph.hasCycle);
	}
	
	
}
