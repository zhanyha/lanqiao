package com.zyh.lanqiao.dataStruct.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Kruskal {
	private int V;
	private int E;
	private ArrayList<WeightedEdge> edges = new ArrayList<WeightedEdge>();
	private ArrayList<WeightedEdge> res = new ArrayList<WeightedEdge>();
	private HashMap<Integer, UFNode> map = new HashMap<Integer, UFNode>();

	public Kruskal(Scanner sc) {
		this.V = sc.nextInt();
		this.E = sc.nextInt();
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int weight = sc.nextInt();
			edges.add(new WeightedEdge(a, b, weight));
		}
		// 下面的逻辑是克鲁斯卡尔算法的思想
		Collections.sort(edges);
		UnionFind uf = new UnionFind();
		for (WeightedEdge e : edges) {// 让每个相同的字符对应一样的节点
			map.put(e.v,new UFNode());
			map.put(e.w, new UFNode());
		}
		for (int i = 0; i < E; i++) {
			WeightedEdge min = edges.remove(0);
			if (uf.find(map.get(min.v)) != uf.find(map.get(min.w))) {
				uf.union(map.get(min.v), map.get(min.w));
				res.add(min);
				if (res.size() == V - 1)
					break;
			}
		}
	}

	public Iterable<WeightedEdge> result() {
		return this.res;
	}

	public static void main(String[] args) {
		Kruskal kruskal = new Kruskal(new Scanner(System.in));
		for (WeightedEdge e : kruskal.result()) {
			System.out.print(e.v + "-->" + e.w + ": "+e.weight+"\n");
		}
	}
}
