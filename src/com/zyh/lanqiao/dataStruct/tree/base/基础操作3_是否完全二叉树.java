package com.zyh.lanqiao.dataStruct.tree.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 基础操作3_是否完全二叉树 {
	private static class Node<T>{
		T data;
		int num;//编号
		Node<T> left;
		Node<T> right;
	}
	static char[] chs;
	static int cur = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chs = sc.nextLine().toCharArray();
		Node<Character> root = create();
		if(isCompleteTree2(root)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		sc.close();
	}
	//策略二：广度优先搜索BFS
	private static boolean isCompleteTree2(Node<Character> root) {
		if(root == null) return true;
		Queue<Node<Character>> q = new LinkedList<Node<Character>>();
		List<Node<Character>> list = new ArrayList<Node<Character>>();
		q.add(root);
		int num = 1;
		root.num = num;
		while(!q.isEmpty()) {
			Node<Character> run = q.poll();
			list.add(run);
			if(run.left!=null) {
				q.add(run.left);
				run.left.num = 2*num;
			}
			if(run.right!=null) {
				q.add(run.right);
				run.right.num = 2*num+1;
			}
			num++;
		}
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).num != i+1) {
				return false;
			}
		}
		return true;
	}
//	ABCD##E###GH##I## NO
//	ABCD###F##GH##I## YES
	//策略一：深度优先搜索DFS
	//检测每个节点是否存在单枝的情况————————这是错的,
	//因为完全二叉树的定义是1~n的节点编号都与满二叉树对应。
	//Time: 2020.02.07
	private static boolean isCompleteTree(Node<Character> root) {
		if(root==null) return true;
		if((root.left==null&&root.right!=null) 
			 || root.right == null &&root.left!=null) {
			return false;
		}
		return isCompleteTree(root.left)&&isCompleteTree(root.right);
	}
	private static Node<Character> create() {
		++cur;
		if(chs[cur] == '#') {
			return null;
		}
		Node<Character> root = new Node<Character>();
		root.data = chs[cur];
		root.left = create();
		root.right = create();
		return root;
	}

}
