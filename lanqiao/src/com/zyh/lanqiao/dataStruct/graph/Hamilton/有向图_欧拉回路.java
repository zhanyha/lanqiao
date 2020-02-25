package com.zyh.lanqiao.dataStruct.graph.Hamilton;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

import com.zyh.lanqiao.dataStruct.graph.store.DirectedWeightedGraph;


/**
 * 有欧拉回路的前提是只有1个连通分量 Hierholzer算法 ——使用两个栈，算法思想就是把证明欧拉回路的存在 条件的过程实现一遍
 * 
 * @author zhanyuhao
 * @version 创建时间：2020年2月24日 下午8:54:03 类说明
 */
public class 有向图_欧拉回路 {
	private int V;
	private int E;
	private DirectedWeightedGraph g;
	private Stack<Integer> curPath = new Stack<Integer>();
	private ArrayList<Integer> res = new ArrayList<Integer>();
	private boolean hasEulerLoop = false;

	public 有向图_欧拉回路(DirectedWeightedGraph g) {
		this.V = g.V();
		this.E = g.E();
		this.g = g;
		int cur = 0;
		curPath.push(cur);
		while (!curPath.isEmpty()) {
			if(g.outdegree(cur)!=0) {
				curPath.push(cur);
				int w = g.adj(cur).iterator().next();
				g.removeEdge(cur, w);
				cur = w;
			}else {
				res.add(cur);
				cur = curPath.pop();
			}
		}
		Collections.reverse(res);
	}
	public boolean hasEulerLoop() {
		for (int v = 0; v < V; v++) {
			if(g.indegree(v)!=g.outdegree(v))
				return false;
		}
		return true;
	}
	public ArrayList<Integer> result() {
		return res;
	}
	
	public static void main(String[] args) {
		DirectedWeightedGraph g = new DirectedWeightedGraph(new Scanner(System.in));
		有向图_欧拉回路 o = new 有向图_欧拉回路(g);
		System.out.println(o.result());
	}
}
