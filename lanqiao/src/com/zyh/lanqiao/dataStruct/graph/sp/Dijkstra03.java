package com.zyh.lanqiao.dataStruct.graph.sp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import com.zyh.lanqiao.dataStruct.graph.store.Graph;
/**
 * ʹ��һ��pre��������¼���·��������ӡ���·��
* @author zhanyuhao
* @version ����ʱ�䣺2020��2��21�� ����11:09:53
* ��˵��
 */
public class Dijkstra03 {
	private int s;// Դ,Dijkstra��һ�ֵ�Դ���·���㷨
	private int[] dis;
	private boolean[] visited;// ��¼��Դs������ĳ���������Сֵ�Ѿ�ȷ���ˡ�
	private int[] pre;
	private class Node implements Comparable<Node>{
		int v;//��v�����������СȨ
		int weight;
		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
		
	}
	public Dijkstra03(Graph g, int s) {
		int V = g.V();
		int E = g.E();
		dis = new int[V];
		visited = new boolean[V];
		pre = new int[V];
		// 1.��ʼ��
//		�ѵ�Դ��·��ֵ����Ϊ0������������ľ������ó������
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[s] = 0;
		// ��������㷨����˼��
		Queue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s,0));
		while (!pq.isEmpty()) {
//		2.�ҵ���s������û�з��ʽڵ����Сֵ
			int cur = pq.remove().v;
			if(visited[cur]) continue;
//			3.��ô��Դ�㵽��������Сֵ���Ѿ�ȷ���ˡ�
			visited[cur] = true;
//			4.��������ڵ�����·��ȥ���������ڵ�ĳ���
			for (int v : g.adj(cur))
				if(!visited[v]) {
					if (dis[cur] + g.getWeight(v, cur) < dis[v]) {
						dis[v] = dis[cur] + g.getWeight(v, cur);
						pq.add(new Node(v,g.getWeight(v, cur)));
						pre[v] = cur;
					}
				}

		}
	}
	public boolean isConnectedTo(int v) {
		return dis[v]!=Integer.MAX_VALUE;
	}
	public int[] pathTo() {
		return dis;
	}
	public Iterable<Integer> path(int end){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(!isConnectedTo(end)) return res;
		int cur = end;
		while(cur!=s) {
			res.add(cur);
			cur = pre[cur];
		}
		res.add(cur);
		Collections.reverse(res);
		return res;
	}
	public static void main(String[] args) {
		Graph g = new Graph(new Scanner(System.in));
		Dijkstra03 dijkstra = new Dijkstra03(g, 0);
		int[] pathTo = dijkstra.pathTo();
		for(int i=0;i<g.V();i++) {
			System.out.print(pathTo[i]+" ");
		}
		System.out.println();
		System.out.println(dijkstra.path(3));
	}
}
