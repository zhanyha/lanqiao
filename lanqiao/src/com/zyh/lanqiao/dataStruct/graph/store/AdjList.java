package com.zyh.lanqiao.dataStruct.graph.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjList {
	private int V;
	private int E;
	private LinkedList<Integer>[] adjList;
	public AdjList(String filename) {
		File file = new File(filename);
		try {
			Scanner sc = new Scanner(file);
			this.V = sc.nextInt();
			this.E = sc.nextInt();
			adjList = new LinkedList[V];
			for (int i = 0; i < V; i++) 
				adjList[i] = new LinkedList<Integer>();
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adjList[a].add(b); 
				adjList[b].add(a); 
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
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("V = %d,E = %d\n",V,E));
		for (int v = 0; v < V; v++) {
			sb.append(String.format("%d: ", v));
			for (Integer e : adjList[v]) {
				sb.append(String.format("%d ", e));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		AdjList adj = new AdjList("g.txt");
		System.out.println(adj);
	}
}
