package com.zyh.lanqiao.dataStruct.graph.sp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import com.zyh.lanqiao.dataStruct.graph.store.Graph;
/**
 * 使用一个pre数组来记录最短路径，并打印这个路径
* @author zhanyuhao
* @version 创建时间：2020年2月21日 下午11:09:53
* 类说明
 */
public class Dijkstra03 {
	private int s;// 源,Dijkstra是一种单源最短路径算法
	private int[] dis;
	private boolean[] visited;// 记录从源s出发到某个顶点的最小值已经确定了。
	private int[] pre;
	private class Node implements Comparable<Node>{
		int v;//从v顶点出发的最小权
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
		// 1.初始化
//		把到源的路径值更新为0，到其他顶点的距离设置成无穷大
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[s] = 0;
		// 下面就是算法本质思想
		Queue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s,0));
		while (!pq.isEmpty()) {
//		2.找到从s出发到没有访问节点的最小值
			int cur = pq.remove().v;
			if(visited[cur]) continue;
//			3.那么从源点到这个点的最小值就已经确定了。
			visited[cur] = true;
//			4.根据这个节点的最短路径去更新其他节点的长度
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
