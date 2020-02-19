package com.zyh.lanqiao.dataStruct.graph.Iterator;

import java.util.Scanner;
import java.util.TreeSet;
/**
* @author zhanyuhao
* @version ����ʱ�䣺2020��2��18�� ����8:30:46
* ��˵��
 */
public class ����ͼ_DFS����_����ͼ {
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
	static int[] colors;
	static boolean bipartite = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		g = new Graph(sc);
		vis = new int[g.V];
		colors = new int[g.V];
		for (int i = 0; i < vis.length; i++) {
			if(vis[i]==0)
				bipartite = dfs(i,1);
		}
		System.out.println(bipartite);
	}

	private static boolean dfs(int start,int color) {
		vis[start] = 1;
		colors[start] = color;
		for (Integer e : g.adj(start)) {
			if(vis[e]==0)
				if(!dfs(e,1-color)) return false;
			else if(colors[e] == color)
				return false;
		}
		return true;
	}

}
