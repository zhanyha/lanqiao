package com.zyh.lanqiao.dataStruct.graph.Hamilton;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

import com.zyh.lanqiao.dataStruct.graph.store.DirectedWeightedGraph;
import com.zyh.lanqiao.dataStruct.graph.store.Graph;

/**
 * 有欧拉回路的前提是只有1个连通分量 Hierholzer算法 ——使用两个栈，
 * 算法思想就是把证明欧拉回路的存在 条件的过程实现一遍
 * 
 * @author zhanyuhao
 * @version 创建时间：2020年2月24日 下午8:54:03 类说明
 */
public class 有向图_欧拉路径 {
	private int V;
	private int E;
	private DirectedWeightedGraph g;
	private Stack<Integer> curPath = new Stack<Integer>();
	private Stack<Integer> res = new Stack<Integer>();
	private boolean hasEulerLoop = false;

	public 有向图_欧拉路径(DirectedWeightedGraph g,int start) {
		this.V = g.V();
		this.E = g.E();
		this.g = g;
		int cur = start;
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

	public Stack<Integer> result() {
		return res;
	}

	public static void main(String[] args) {
		DirectedWeightedGraph g = new DirectedWeightedGraph(new Scanner(System.in));
		有向图_欧拉路径 o = new 有向图_欧拉路径(g,2);
		System.out.println(o.result());
	}
}
