package com.zyh.lanqiao.dataStruct.graph.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class ����ͼ_DFS����_ǿ��ͨ���� {
	private DirectedGraph g;
	private int[] visited;// ����Ƿ񱻷��ʣ����Ҵ洢ǿ��ͨ������id
	private int V;
	private int E;
	private int scccount = 0;// ǿ��ͨ�����ĸ���
	ArrayList<Integer>[] res;
	public ����ͼ_DFS����_ǿ��ͨ����(DirectedGraph g) {
		this.V = g.V();
		this.E = g.E();
		this.g = g;
		visited = new int[V];
		res = new ArrayList[V];
		for(int i=0;i<V;i++)
			res[i] = new ArrayList<Integer>();
		Arrays.fill(visited, -1);
		g.reverseGraph();// ��ͼ
		ArrayList<Integer> post = g.post();// �����������
		Collections.reverse(post);// ����
		// ��������������ͼ����ͨ������˼��
		g.reverseGraph();// ��ͼ
		for (int v: post) {
			if (visited[v] == -1) {
				dfs(v, scccount);
				++scccount;
			}
		}
	}

	private void dfs(int v, int scc) {
		visited[v] = scc;
		res[scc].add(v);
		for (int w : g.adj(v)) {
			if (visited[w] == -1)
				dfs(w, scc);
		}
	}

	public int scccount() {
		return scccount;
	}
	
	public Iterable<Integer> scc(int v){
		return res[v];
	}
	public static void main(String[] args) {
		DirectedGraph g = new DirectedGraph(new Scanner(System.in));
		����ͼ_DFS����_ǿ��ͨ���� a = new ����ͼ_DFS����_ǿ��ͨ����(g);
		System.out.println(a.scccount());
		for(int v=0;v<a.scccount();v++) {
			System.out.print(v+": ");
			for(int w:a.scc(v)) {
				System.out.print(w+" ");
			}
			System.out.println();
		}
	}

	static class DirectedGraph {
		int V;
		int E;
		TreeSet<Integer> treeSet[];
		boolean[] visited;
		ArrayList<Integer> res = new ArrayList<Integer>();

		public DirectedGraph(Scanner sc) {
			this.V = sc.nextInt();
			this.E = sc.nextInt();
			treeSet = new TreeSet[V];
			visited = new boolean[V];
			for (int i = 0; i < V; i++) {
				treeSet[i] = new TreeSet<Integer>();
			}
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				treeSet[a].add(b);
			}
		}

		public ArrayList<Integer> post() {
			for (int v = 0; v < V; v++) {
				if (!visited[v])
					dfs(v);
			}
			return res;
		}
		public void dfs(int v) {
			visited[v] = true;
			for (int w : adj(v)) {
				if (!visited[w]) {
					dfs(w);
				}
			}
			res.add(v);
		}

		public Iterable<Integer> adj(int v) {
			return treeSet[v];
		}

		public void reverseGraph() {
			TreeSet<Integer>[] rtreeSet = new TreeSet[V];
			for (int i = 0; i < V; i++) {
				rtreeSet[i] = new TreeSet<Integer>();
			}
			for (int v = 0; v < V; v++) {
				for (int w : adj(v)) {
					rtreeSet[w].add(v);
				}
			}
			treeSet = rtreeSet;
		}

		public int V() {
			return V;
		}

		public int E() {
			return E;
		}
	}
}
