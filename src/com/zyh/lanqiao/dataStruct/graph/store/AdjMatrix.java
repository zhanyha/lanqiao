package com.zyh.lanqiao.dataStruct.graph.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjMatrix {
	private int V;
	private int E;
	private int[][] adjMatrix;
	public AdjMatrix(String filename) {
		File file = new File(filename);
		try {
			Scanner sc = new Scanner(file);
			this.V = sc.nextInt();
			this.E = sc.nextInt();
			adjMatrix = new int[V][V];
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adjMatrix[a][b] = 1; 
				adjMatrix[b][a] = 1; 
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
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				sb.append(adjMatrix[i][j]+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		AdjMatrix adj = new AdjMatrix("g.txt");
		System.out.println(adj);
	}
}
