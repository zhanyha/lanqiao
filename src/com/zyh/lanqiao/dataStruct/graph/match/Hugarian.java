package com.zyh.lanqiao.dataStruct.graph.match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.zyh.lanqiao.dataStruct.graph.store.Graph;

/**
 * �������㷨ʵ�ֶ���ͼ�����ƥ������
 * 
 * @author zhanyuhao
 * @version ����ʱ�䣺2020��2��25�� ����8:21:38 ��˵��
 */

public class Hugarian {
	private Graph g;
	private int maxMaching = 0;
	private int[] match;// match[v]�����붥��v��ƥ����Ǹ�����

	public Hugarian(Graph g) {
		this.g = g;
		match = new int[g.V()];
		Arrays.fill(match, -1);
		Bipartite bipartite = new Bipartite(g);
		if(!bipartite.isBipratite()) {
			System.out.println("���Ƕ���ͼ");
			System.exit(0);
		}
		int[] colors = bipartite.colors();
		for(int v=0;v<g.V();v++) {
			if(match[v]==-1 && colors[v]==0) {
				if(bfs(v)) {//ȥ�ҵ�����·��
					maxMaching++;
				}
			}
		}
		
	}

	private boolean bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] pre = new int[g.V()];
		Arrays.fill(pre, -1);
		queue.add(v);
		for(int next:g.adj(v)) {
			int cur = queue.remove();
			if(pre[next]==-1) {//û�з���
				if(match[next] != -1) {
					pre[next] = cur;
					pre[match[next]] = next;
					queue.add(match[next]);
				}else {
					//˵���ҵ���һ������·��
					pre[next] = cur;
					ArrayList<Integer> path = getAugmentingPath(pre,v,next);
					for(int i=0; i < path.size();i+=2) {
						match[path.get(i)] = path.get(i+1);
						match[path.get(i+1)] = path.get(i);
					}
					return true;
				}
			}
		}
		return false;
	}
	private ArrayList<Integer> getAugmentingPath(int[] pre,int v,int next) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int cur = next;
		while(cur != v) {
			res.add(cur);
			cur = pre[cur];
		}
		res.add(cur);
		return res;
	}

	public int result() {
		return maxMaching;
	}
	public static void main(String[] args) {
		Graph g = new Graph(new Scanner(System.in));
		Hugarian hugarian = new Hugarian(g);
		System.out.println(hugarian.result());
	}
}
