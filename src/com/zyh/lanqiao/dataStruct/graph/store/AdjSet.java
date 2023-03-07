package com.zyh.lanqiao.dataStruct.graph.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * 基于红黑树的图存储结构
* @author zhanyuhao
* @version 创建时间：2020年2月18日 上午12:21:12
* 类说明
 */
public class AdjSet {
	private int V;
	private int E;
	private TreeSet<Integer>[] adjSet;
	public AdjSet(String filename) {
		File file = new File(filename);
		try {
			Scanner sc = new Scanner(file);
			this.V = sc.nextInt();
			this.E = sc.nextInt();
			adjSet = new TreeSet[V];
			for (int i = 0; i < V; i++) 
				adjSet[i] = new TreeSet<Integer>();
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adjSet[a].add(b); 
				adjSet[b].add(a); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public boolean hasEdge(int v1,int v2) {
		return adjSet[v1].contains(v2);
	}
	/**
	 * @param v
	 * @return 返回节点的所有孩子
	 */
	public Iterable adj(int v) {
		return adjSet[v];
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("V = %d,E = %d\n",V,E));
		for (int v = 0; v < V; v++) {
			sb.append(String.format("%d: ", v));
			for (Integer e : adjSet[v]) {
				sb.append(String.format("%d ", e));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		AdjSet adj = new AdjSet("g.txt");
		System.out.println(adj);
	}
}
