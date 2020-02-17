package com.zyh.lanqiao.dataStruct.graph.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://vjudge.net/problem/POJ-1287
* @author zhanyuhao
* @version 创建时间：2020年2月17日 下午12:46:00
* 类说明
 */
public class POJ1287_Networking {
	static Map<Integer,	UFNode> map = new HashMap<Integer, UFNode>();
	static List<Edge>T = new ArrayList<Edge>();
	static int total=0;
	private static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		while(v!=0) {
			T.clear();
			map.clear();
			total=0;
			int e = sc.nextInt();
			Edge[] edges = new Edge[e];
			for (int i = 0; i < e; i++) {
				edges[i] = new Edge();
				edges[i].start = sc.nextInt();
				edges[i].end = sc.nextInt();
				edges[i].weight = sc.nextInt();
			}
			kruskal(edges,v);
			v = sc.nextInt();
		}
		sc.close();
	}
	private static void kruskal(Edge[] edges,int v) {
		if(edges.length==0) {
			System.out.println(total);
			return;
		}
		Arrays.sort(edges);
		int start;
		int end;
		for (int i = 0; i < edges.length; i++) {
			start = edges[i].start;
			end = edges[i].end;
			if(map.get(start)==null)
				map.put(start, new UFNode());
			if(map.get(end)==null)
				map.put(end, new UFNode());
			if(UnionFind.find(map.get(start)) != UnionFind.find(map.get(end))) {
				UnionFind.union(map.get(start), map.get(end));
				T.add(edges[i]);
				total+=edges[i].weight;
				if(T.size() == v-1) {
					System.out.println(total);
					return;
				}
			}
		}
	}
	private static class UFNode {
		UFNode parent;
		public UFNode() {
			this.parent = this;
		}
	}
	private static class UnionFind {
		public static void union(UFNode x,UFNode y) {
			find(y).parent = find(x);
		}
		public static UFNode find(UFNode x) {
			UFNode p =x;
			while(p!=p.parent) {
				p = p.parent;
			}
			return p;
		}
	}
}
