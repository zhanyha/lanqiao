package com.zyh.lanqiao.dataStruct.tree.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
//ABD##EH###CF#I##G##
public class 基础操作2_第k层的节点个数 {
	private static class Node<T>{
		T data;
		int num; // 编号
		Node<T> left;
		Node<T> right;
		public Node(T data) {
			this.data = data;
		}
	}
	static char[] chs;
	static int cur = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chs = sc.nextLine().toCharArray();
		Node<Character> root = create();
		int k = sc.nextInt();
		List<Node<Character>> res = bfs(root, k);
		for (Node<Character> node : res) {
			System.out.print(node.data+" ");
		}
		sc.close();
	}
	private static Node<Character> create() {
		++cur;
		if(chs[cur] == '#') {
			return null;
		}
		Node<Character> root = new Node<Character>(chs[cur]);
		root.left = create();
		root.right = create();
		return root;
	}
	public static List<Node<Character>> bfs(Node<Character> root,int k){
		if(root == null) return null;
		Queue<Node<Character>> q = new LinkedList<Node<Character>>();
		q.add(root);
		int num=1;
		root.num = num;
		int l =(int) Math.pow(2, k-1); 
		int r =(int) Math.pow(2, k); 
		while(!q.isEmpty()&&num<=Math.pow(2, k-1)-1) { //精髓所在
			Node<Character> run = q.poll();
			if(run.left!=null) {
				q.add(run.left);
				run.left.num = 2*num;
			}
			if(run.right!=null) {
				q.add(run.right);
				run.right.num = 2*num+1;
			}
			num+=1;
		}
		List<Node<Character>> res = new ArrayList<Node<Character>>();
		while(!q.isEmpty()) {
			Node<Character> poll = q.poll();
			if(poll.num >= l && poll.num < r) {
				res.add(poll);
			}
		}
		return res;
		
	}
//	private static Node<Character> create() {
//		char ch = sc.next().charAt(0);
//		if(ch=='#'){
//			return null;
//		}
//		Node<Character> p = new Node<Character>(ch);
//		p.left = create();
//		p.right = create();
//		return p;
//	}
}
