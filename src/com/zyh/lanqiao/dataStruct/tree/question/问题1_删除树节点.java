package com.zyh.lanqiao.dataStruct.tree.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * https://vjudge.net/problem/HihoCoder-1694
 * 
 * @author zhanyuhao
 *
 */
//7 10
//5 1 51 4 5 1 1
//3 3 0 1 2 4 3
//1 10
//5
//0

public class 问题1_删除树节点 {
	private static class Node {
		int num;
		int weight;
		List<Node> children;
		Node parent;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int K = sc.nextInt();
		Node[] ns = new Node[n];
		int[] ws = new int[n];
		int[] ps = new int[n];
		for (int i = 0; i < n; i++)
			ws[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			ps[i] = sc.nextInt();
		for (int i = 0; i < n; i++) {
			ns[i] = new Node();
			ns[i].num = i + 1;
			ns[i].weight = ws[i];
		}
		for (int i = 0; i < n; i++) {
			Node parent = parent(ns, ps[i]);
			ns[i].parent = parent;
			if(parent!=null) {
				if (parent.children == null) {
					parent.children = new ArrayList<Node>();
				}
				parent.children.add(ns[i]);
			}
		}
		Node root = findRoot(ns);
		remove(root,K);
		for (int i = 0; i < ns.length; i++) {
			if(ns[i].parent==null) {
				System.out.print(0);
			}else if(ns[i].weight<K) {
				System.out.print(-1);
			}else {
				System.out.print(ns[i].parent.num);
			}
			if(i!=ns.length-1) {
				System.out.print(" ");
			}
		}
		sc.close();
	}
	

	private static void remove(Node p, int k) {
		if(p == null) {
			/*System.out.println("kong");*/
			return;
		}
		Node pp = p.parent;
		List<Node> pc = p.children;
		if(p.weight < k) {
			if(pp == null) {
				//说明删除的是跟节点。但是题目不会出现这种情况
			}else {
				if(pc == null) {
					//说明是叶子节点
					pp.children.remove(p);
				}else {
					pp.children.addAll(pc);
					for (int i = 0; i < pc.size(); i++) {
						pc.get(i).parent = pp;
					}
					pp.children.remove(p);
				}
			}
		}
		if(pc!=null) {
			for (int i = 0; i <pc.size(); i++) {
				remove(pc.get(i),k);
			}
		}
	}

	private static Node findRoot(Node[] ns) {
		for (int i = 0; i < ns.length; i++) {
			if(ns[i].parent == null) return ns[i];
		}
		return null;
	}

	private static Node parent(Node[] ns, int i) {
		if (i == 0)
			return null;
		return ns[i-1];
	}
}
