package com.zyh.lanqiao.dataStruct.graph.networkFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.zyh.lanqiao.dataStruct.graph.store.DirectedWeightedGraph;

/**
 * 基于Ford Fulkerson思想的Edmonds-Karp算法最大流算法
 * 
 * @author zhanyuhao
 * @version 创建时间：2020年2月25日 下午4:43:24 类说明 1.根据有向有权图求出残量图 2.不断地循环去找增广路径上所有权值的最小值
 *          3.更新参量图的容量
 */

public class MaxFlow {
	private DirectedWeightedGraph rg;
	private int maxFlow;
	private int s, t;

	public MaxFlow(DirectedWeightedGraph g, int s, int t) {
		this.t = t;
		this.s = s;
		buildrg(g);// 初始化，构建残量图
		while(true) {
			ArrayList<Integer> path = getAugmentingPath();// 找到增广路径
			if(path.size()==0) break;
			int f = Integer.MAX_VALUE;
			// TODO:找到路径权值的最小值
			for(int i=1;i<path.size();i++) {
				int v = path.get(i - 1);
				int w = path.get(i);
				f = Math.min(f, rg.getWeight(v, w));
			}
			maxFlow += f;
			// TODO:更新残量图
			for(int i=1;i<path.size();i++) {
				int v = path.get(i - 1);
				int w = path.get(i);
				rg.setWeight(v, w, rg.getWeight(v, w) - f);
				rg.setWeight(w, v, rg.getWeight(w, v) + f);
			}
		}
	}

	private ArrayList<Integer> getAugmentingPath() {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Queue<Integer> que = new LinkedList<Integer>();
		int[] pre = new int[rg.V()];
		boolean[] visited = new boolean[rg.V()];
		Arrays.fill(pre, -1);
		que.add(s);
		pre[s] = s;
		visited[s] = true;
		while (!que.isEmpty()) {
			int v = que.remove();
			if(v==t) break;
			for (int w : rg.adj(v)) {
				if (!visited[w] && rg.getWeight(v, w) != 0) {
					que.add(w);
					visited[w] = true;
					pre[w] =v;
				}
			}
		}
		if(pre[t] == -1) return res;
		int cur = t;
		while(cur!=s) {
			res.add(cur);
			cur = pre[cur];
		}
		res.add(cur);
		Collections.reverse(res);
		return res;
	}

	private void buildrg(DirectedWeightedGraph g) {
		rg = new DirectedWeightedGraph(g.V());
		for (int v = 0; v < g.V(); v++) {
			for (int w : g.adj(v)) {
				rg.addEdge(v, w, g.getWeight(v, w));
				rg.addEdge(w, v, 0);
			}
		}
	}
	public int result() {
		return maxFlow;
	}
	public int flow(int v,int w) {
		return rg.getWeight(w, v);
	}
	public static void main(String[] args) {
		DirectedWeightedGraph g = new DirectedWeightedGraph(new Scanner(System.in));
		int s =0;
		int t= 10;
		MaxFlow flow = new MaxFlow(g, s, t);
		System.out.println(flow.result());
		for(int v=0;v<g.V();v++) {
			for(int w: g.adj(v)) {
				System.out.println(String.format("%d-%d: %d/%d", v,w,flow.flow(v, w),g.getWeight(v, w)));
			}
		}
	}
}
