package com.zyh.lanqiao.dataStruct.graph.mst;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Prim {
	private int V;
	private int E;
	private TreeMap<Integer, Integer>[] treeMap;
	private ArrayList<WeightedEdge> res = new ArrayList<WeightedEdge>();
	private boolean[] visited;

	public Prim(Scanner sc) {
		this.V = sc.nextInt();
		this.E = sc.nextInt();
		visited = new boolean[V];
		treeMap = new TreeMap[V];
		for (int v = 0; v < V; v++)
			treeMap[v] = new TreeMap<Integer, Integer>();
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int weight = sc.nextInt();
			treeMap[a].put(b, weight);
			treeMap[b].put(a, weight);
		}
		// 下面的逻辑是Prim算法的思想
//		visited[0] = true;
//		for (int i = 1; i < V; i++) {
//			WeightedEdge min = new WeightedEdge(-1, -1, Integer.MAX_VALUE);
//			for (int v = 0; v < V; v++) {// 对于每一个顶点v,找到最短的横切边
//				if (visited[v]) {
//					for (int w : adj(v)) {
//						if (!visited[w]) {
//							if (min.weight > getWeight(v, w)) {
//								min.v = v;
//								min.w = w;
//								min.weight = getWeight(v, w);
//							}
//						}
//					}
//				}
//			}
//			res.add(min);
//			visited[min.v] = true;
//			visited[min.w] = true;
//		}
		//使用优先队列来维护最小横切边
		visited[0] = true;
		Queue<WeightedEdge> pq = new PriorityQueue<WeightedEdge>();
		for(int w:adj(0))
			pq.add(new WeightedEdge(0, w, getWeight(0, w)));
		while(!pq.isEmpty()) {
			WeightedEdge minEdge = pq.remove();
			if(visited[minEdge.w] && visited[minEdge.v]) {
				continue;
			}
			res.add(minEdge);
			int newv = visited[minEdge.w] ? minEdge.v:minEdge.w;
			visited[newv] = true;
			for(int w: adj(newv)) {
				if(!visited[w])
					pq.add(new WeightedEdge(newv, w, getWeight(newv, w)));
			}
		}
	}

	public Iterable<Integer> adj(int v) {
		return treeMap[v].keySet();
	}

	public int getWeight(int v, int w) {
		return treeMap[v].get(w);
	}

	public Iterable<WeightedEdge> result() {
		return res;
	}

	public static void main(String[] args) {
		Prim prim = new Prim(new Scanner(System.in));
		for (WeightedEdge e : prim.result()) {
			System.out.print(e.v + "-->" + e.w + ": " + e.weight + "\n");
		}
	}
}
