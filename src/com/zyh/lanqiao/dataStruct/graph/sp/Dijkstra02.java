package com.zyh.lanqiao.dataStruct.graph.sp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import com.zyh.lanqiao.dataStruct.graph.store.WeightedGraph;

/**
 * ����Dijkstra�㷨�����Ż��ĵط�����ÿ������СȨ��·�������ʹ��
 * һ�����ȶ�����ά���Ļ������ή������СȨ·���ĸ��Ӷȣ�����㷨����
* @author zhanyuhao
* @version ����ʱ�䣺2020��2��21�� ����9:48:38
* ��˵��
 */
public class Dijkstra02 {
	private int s;// Դ,Dijkstra��һ�ֵ�Դ���·���㷨
	private int[] dis;
	private boolean[] visited;// ��¼��Դs������ĳ���������Сֵ�Ѿ�ȷ���ˡ�
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
	public Dijkstra02(WeightedGraph g, int s) {
		int V = g.V();
		int E = g.E();
		dis = new int[V];
		visited = new boolean[V];
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
					}
				}

		}
	}
	public int[] pathTo() {
		return dis;
	}
	public static void main(String[] args) {
		WeightedGraph g = new WeightedGraph(new Scanner(System.in));
		Dijkstra02 dijkstra = new Dijkstra02(g, 0);
		int[] pathTo = dijkstra.pathTo();
		for(int i=0;i<g.V();i++) {
			System.out.print(pathTo[i]+" ");
		}
		System.out.println();
	}
}
