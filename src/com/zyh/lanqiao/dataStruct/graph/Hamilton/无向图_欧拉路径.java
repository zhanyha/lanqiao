package com.zyh.lanqiao.dataStruct.graph.Hamilton;

import java.util.Scanner;
import java.util.Stack;

import com.zyh.lanqiao.dataStruct.graph.store.Graph;

/**
 * ��ŷ����·��ǰ����ֻ��1����ͨ���� Hierholzer�㷨 ����ʹ������ջ��
 * �㷨˼����ǰ�֤��ŷ����·�Ĵ��� �����Ĺ���ʵ��һ��
 * 
 * @author zhanyuhao
 * @version ����ʱ�䣺2020��2��24�� ����8:54:03 ��˵��
 */
public class ����ͼ_ŷ��·�� {
	private int V;
	private int E;
	private Graph g;
	private Stack<Integer> curPath = new Stack<Integer>();
	private Stack<Integer> res = new Stack<Integer>();

	public ����ͼ_ŷ��·��(Graph g,int start) {
		this.V = g.V();
		this.E = g.E();
		this.g = g;
		int cur = start;
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

	public Stack<Integer> result() {
		return res;
	}

	public static void main(String[] args) {
		Graph g = new Graph(new Scanner(System.in));
		����ͼ_ŷ��·�� o = new ����ͼ_ŷ��·��(g,0);
		System.out.println(o.result());
	}
}
