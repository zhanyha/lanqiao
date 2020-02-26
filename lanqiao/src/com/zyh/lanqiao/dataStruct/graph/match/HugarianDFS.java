package com.zyh.lanqiao.dataStruct.graph.match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.zyh.lanqiao.dataStruct.graph.store.Graph;
/**
 * 匈牙利算法实现二分图的最大匹配问题
 * 
 * @author zhanyuhao
 * @version 创建时间：2020年2月25日 下午10:21:38 类说明
 */

public class HugarianDFS {
	private Graph g;
	private int maxMaching = 0;
	private int[] match;// match[v]代表与顶点v的匹配的那个顶点
	private boolean[] visited;
	public HugarianDFS(Graph g) {
		this.g = g;
		match = new int[g.V()];
		visited = new boolean[g.V()];
		Arrays.fill(match, -1);
		Bipartite bipartite = new Bipartite(g);
		if(!bipartite.isBipratite()) {
			System.out.println("不是二分图");
			System.exit(0);
		}
		int[] colors = bipartite.colors();
		for(int v=0;v<g.V();v++) {
			if(match[v]==-1 && colors[v]==0) {
				if(dfs(v)) {//去找到增广路径
					Arrays.fill(visited, false);
					maxMaching++;
				}
			}
		}
		
	}

	private boolean dfs(int v) {
		visited[v] = true;
		for(int w: g.adj(v))
			if(visited[w] == false) {
				visited[w] = true;
				if(match[w] == -1 || dfs(match[w])) {
					match[w] = v;
					match[v] = w;
					return true;
				}
			}
		
		return false;
	}
	private ArrayList<Integer> getAugmentingPath(int[] pre,int v,int next) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int cur = next;
		while(cur != v) {
			res.add(cur);
			cur = pre[cur];
		}
		res.add(cur);
		return res;
	}

	public int result() {
		return maxMaching;
	}
	public static void main(String[] args) {
		Graph g = new Graph(new Scanner(System.in));
		HugarianDFS hugarian = new HugarianDFS(g);
		System.out.println(hugarian.result());
	}
}
