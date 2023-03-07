package com.zyh.lanqiao.dataStruct.graph.networkFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.zyh.lanqiao.dataStruct.graph.store.DirectedWeightedGraph;

/**
 * ����Ford Fulkerson˼���Edmonds-Karp�㷨������㷨
 * 
 * @author zhanyuhao
 * @version ����ʱ�䣺2020��2��25�� ����4:43:24 ��˵�� 1.����������Ȩͼ�������ͼ 2.���ϵ�ѭ��ȥ������·��������Ȩֵ����Сֵ
 *          3.���²���ͼ������
 */

public class MaxFlow {
	private DirectedWeightedGraph rg;
	private int maxFlow;
	private int s, t;

	public MaxFlow(DirectedWeightedGraph g, int s, int t) {
		this.t = t;
		this.s = s;
		buildrg(g);// ��ʼ������������ͼ
		while(true) {
			ArrayList<Integer> path = getAugmentingPath();// �ҵ�����·��
			if(path.size()==0) break;
			int f = Integer.MAX_VALUE;
			// TODO:�ҵ�·��Ȩֵ����Сֵ
			for(int i=1;i<path.size();i++) {
				int v = path.get(i - 1);
				int w = path.get(i);
				f = Math.min(f, rg.getWeight(v, w));
			}
			maxFlow += f;
			// TODO:���²���ͼ
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
