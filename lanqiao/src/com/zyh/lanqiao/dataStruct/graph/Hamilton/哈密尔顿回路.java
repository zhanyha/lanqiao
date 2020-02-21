package com.zyh.lanqiao.dataStruct.graph.Hamilton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 本质就是一个暴力搜索加回溯的过程
* @author zhanyuhao
* @version 创建时间：2020年2月20日 下午7:52:28
* 类说明
 */
public class 哈密尔顿回路 {
	private TreeSet<Integer>[] treeSet;//图的邻接表的存储结构
	private boolean[] visited;
	private int[] pre;
	private int end = -1;
	public 哈密尔顿回路(Scanner sc) {
		int V = sc.nextInt();
		int E = sc.nextInt();
		treeSet = new TreeSet[V];
		visited = new boolean[V];
		pre = new int[V];
		for (int i = 0; i < V; i++)
			treeSet[i] = new TreeSet<Integer>();
			
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			treeSet[a].add(b);
			treeSet[b].add(a);
		}
		boolean b = dfs(0,0,V);//从起始点0开始出发寻找哈密尔顿回路
		System.out.println(b);
	}
	/**
	 * @param v 当前节点
	 * @param parent 记录每个节点的上一个节点
	 * @param left 剩余多少个顶点没有被访问
	 */
	private boolean dfs(int v,int parent,int left) {
		visited[v] = true;
		pre[v] = parent;
		left--;
		for(int w : adj(v)) 
			if(!visited[w]) {
				visited[w] = true;
				if(dfs(w,v,left))
					return true;
				visited[w] = false;//一定要回溯
			}
			else if(w==0 && left== 0) {
				end = v;//记录最后一步到出发点的那个顶点
				return true;
			}
		
		return false;
	}
	public ArrayList<Integer> result(){
		ArrayList<Integer>  res = new ArrayList<Integer>();
		if(end==-1) return res;
		int cur = end;
		while(cur!=0) {
			res.add(cur);
			cur = pre[cur];
		}
		res.add(cur);
		Collections.reverse(res);
		return res;
	}
	public Iterable<Integer> adj(int v){
		return treeSet[v];
	}
	public static void main(String[] args) {
		哈密尔顿回路  a = new 哈密尔顿回路(new Scanner(System.in));
		System.out.println(a.result());
	}
}
