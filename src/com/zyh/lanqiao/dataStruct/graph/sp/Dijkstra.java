package com.zyh.lanqiao.dataStruct.graph.sp;
import java.util.Arrays;
import java.util.Scanner;

import com.zyh.lanqiao.dataStruct.graph.store.WeightedGraph;


public class Dijkstra {
	private int s;// Դ,Dijkstra��һ�ֵ�Դ���·���㷨
	private int[] dis;
	private boolean[] visited;// ��¼��Դs������ĳ���������Сֵ�Ѿ�ȷ���ˡ�

	public Dijkstra(WeightedGraph g, int s) {
		int V = g.V();
		int E = g.E();
		dis = new int[V];
		visited = new boolean[V];
		// 1.��ʼ��
//		�ѵ�Դ��·��ֵ����Ϊ0������������ľ������ó������
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[s] = 0;
		// ��������㷨����˼��
		while (true) {
//		2.�ҵ���s������û�з��ʽڵ����Сֵ
			int min = Integer.MAX_VALUE, cur = -1;
			;
			for (int v = 0; v < V; v++) {
				if (!visited[v] && min > dis[v]) {
					min = dis[v];
					cur = v;
				}
			}
			if (cur == -1)
				break;
//			3.��ô��Դ�㵽��������Сֵ���Ѿ�ȷ���ˡ�
			visited[cur] = true;
			dis[cur] = min;
//			4.��������ڵ�����·��ȥ���������ڵ�ĳ���
			for (int v : g.adj(cur))
				if (dis[cur] + g.getWeight(v, cur) < dis[v]) {
					dis[v] = dis[cur] + g.getWeight(v, cur);
				}

		}
	}
	public int[] pathTo() {
		return dis;
	}
	public static void main(String[] args) {
		WeightedGraph g = new WeightedGraph(new Scanner(System.in));
		Dijkstra dijkstra = new Dijkstra(g, 0);
		int[] pathTo = dijkstra.pathTo();
		for(int i=0;i<g.V();i++) {
			System.out.print(pathTo[i]+" ");
		}
		System.out.println();
	}
}
