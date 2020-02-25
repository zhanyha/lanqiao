package com.zyh.lanqiao.dataStruct.graph.Hamilton;

import java.util.Scanner;
import java.util.Stack;

import com.zyh.lanqiao.dataStruct.graph.store.Graph;

/**
 * 有欧拉回路的前提是只有1个连通分量 Hierholzer算法 ——使用两个栈，算法思想就是把证明欧拉回路的存在 条件的过程实现一遍
 * 
 * @author zhanyuhao
 * @version 创建时间：2020年2月24日 下午8:54:03 类说明
 */
public class 无向图_欧拉回路 {
	private int V;
	private int E;
	private Graph g;
	private Stack<Integer> curPath = new Stack<Integer>();
	private Stack<Integer> res = new Stack<Integer>();
	private boolean hasEulerLoop = false;

	public 无向图_欧拉回路(Graph g){
		this.V = g.V();
		this.E = g.E();
		this.g = (Graph) g.clone();
		int cur = 0;
		curPath.push(cur);
		while (!curPath.isEmpty()) {
			if(g.degree(cur)!=0) {
				curPath.push(cur);
				int w = g.adj(cur).iterator().next();
				g.removeEdge(w, cur);
				cur = w;
			}else {
				res.add(cur);
				cur = curPath.pop();
			}
		}
	}
	public boolean hasEulerLoop() {
		for (int v = 0; v < V; v++) {
			if(g.degree(v)%2!=0)
				return false;
		}
		return true;
	}
	public Stack<Integer> result() {
		return res;
	}

	public static void main(String[] args) {
		Graph g = new Graph(new Scanner(System.in));
		无向图_欧拉回路 o = new 无向图_欧拉回路(g);
		System.out.println(o.hasEulerLoop());
		System.out.println(o.result());
	}
}
