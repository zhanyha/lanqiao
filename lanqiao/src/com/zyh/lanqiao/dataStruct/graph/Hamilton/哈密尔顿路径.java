package com.zyh.lanqiao.dataStruct.graph.Hamilton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * ���ʾ���һ�����������ӻ��ݵĹ���
* @author zhanyuhao
* @version ����ʱ�䣺2020��2��20�� ����7:52:28
* ��˵��
 */
public class ���ܶ���·�� {
	private TreeSet<Integer>[] treeSet;//ͼ���ڽӱ�Ĵ洢�ṹ
	private boolean[] visited;
	private int[] pre;
	
	private int start = -1;
	private int end = -1;
	public ���ܶ���·��(Scanner sc) {
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
		start = sc.nextInt();
		end = sc.nextInt();
		boolean b = dfs(start,start,V);//����ʼ��0��ʼ����Ѱ�ҹ��ܶ��ٻ�·
		System.out.println(result(b));
	}
	/**
	 * @param v ��ǰ�ڵ�
	 * @param parent ��¼ÿ���ڵ����һ���ڵ�
	 * @param left ʣ����ٸ�����û�б�����
	 */
	private boolean dfs(int v,int parent,int left) {
		visited[v] = true;
		pre[v] = parent;
		left--;
		if(v==end && left== 0) {
			return true;
		}
		for(int w : adj(v)) 
			if(!visited[w]) {
				visited[w] = true;
				if(dfs(w,v,left))
					return true;
				visited[w] = false;//һ��Ҫ����
			}
		
		return false;
	}
	public ArrayList<Integer> result(boolean b){
		ArrayList<Integer>  res = new ArrayList<Integer>();
		if(!b) return res;
		int cur = end;
		while(cur!=start) {
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
		���ܶ���·��  a = new ���ܶ���·��(new Scanner(System.in));
	}
}
