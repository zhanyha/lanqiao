package com.zyh.lanqiao.dataStruct.graph.sp;
import java.util.Arrays;
import java.util.Scanner;

import com.zyh.lanqiao.dataStruct.graph.store.WeightedGraph;


public class Dijkstra {
	private int s;// 源,Dijkstra是一种单源最短路径算法
	private int[] dis;
	private boolean[] visited;// 记录从源s出发到某个顶点的最小值已经确定了。

	public Dijkstra(WeightedGraph g, int s) {
		int V = g.V();
		int E = g.E();
		dis = new int[V];
		visited = new boolean[V];
		// 1.初始化
//		把到源的路径值更新为0，到其他顶点的距离设置成无穷大
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[s] = 0;
		// 下面就是算法本质思想
		while (true) {
//		2.找到从s出发到没有访问节点的最小值
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
//			3.那么从源点到这个点的最小值就已经确定了。
			visited[cur] = true;
			dis[cur] = min;
//			4.根据这个节点的最短路径去更新其他节点的长度
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
