package com.zyh.lanqiao.dataStruct.tree.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class 基础操作6_三种非递归遍历 {
	private static class Node<T>{
		T data;
		Node<T> left;
		Node<T> right;
	}
	static char[] chs = null;
	static int cur=-1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chs = sc.nextLine().toCharArray();
		Node<Character> root = create();
		List<Node<Character>> res1 = preOrder1(root);
		for (Node<Character> node : res1) {
			System.out.print(node.data+" ");
		}
		System.out.println();
		List<Node<Character>> res = inOrder1(root);
		for (Node<Character> node : res) {
			System.out.print(node.data+" ");
		}
		System.out.println();
		postOrder(root);
		sc.close();
	}

	private static void postOrder(Node<Character> root) {
		if(root==null) return;
		Node<Character> cur,pre = null;//当前访问的节点，和上一次访问的节点
		cur = root;
		Stack<Node<Character>> stk = new Stack<Node<Character>>();
		while(cur!=null) {
			stk.push(cur);
			cur = cur.left;
		}
		while(!stk.isEmpty()) {
			cur = stk.pop();
			if(cur.right==null || cur.right == pre) {
				System.out.print(cur.data+" ");
				pre = cur;//标记
			}else {
				//重新把根压栈
				stk.push(cur);
				cur = cur.right;
				while(cur!=null) {
					stk.push(cur);
					cur = cur.left;
				}
			}
		}
	}

	private static List<Node<Character>> preOrder1(Node<Character> root) {
		if(root==null) return null;
		Stack<Node<Character>> stk = new Stack<Node<Character>>();
		List<Node<Character>> res = new ArrayList<Node<Character>>();
		stk.add(root);
		res.add(root);
		Node<Character> p =root.left;
		while(!stk.isEmpty() || p!=null) {
			while(p!=null) {
				stk.add(p);
				res.add(p);
				p = p.left;
			}
			p = stk.pop();
			p = p.right;
		}
		return res;
	}

	private static List<Node<Character>> inOrder1(Node<Character> root) {
		if(root==null) return null;
		Stack<Node<Character>> stk = new Stack<Node<Character>>();
		List<Node<Character>> res = new ArrayList<Node<Character>>();
		stk.add(root);
		Node<Character> p =root.left;
		while(!stk.isEmpty()||p!=null) {
			while(p!=null) {
				stk.add(p);
				p = p.left;
			}
			p =  stk.pop();
			res.add(p);
			p = p.right;
		}
		return res;
	}

	private static Node<Character> create() {
		++cur;
		if(chs[cur]=='#') {
			return null;
		}
		Node<Character> p = new Node<Character>();
		p.data = chs[cur];
		p.left = create();
		p.right = create();
		return p;
	}
	private static void preOrder(Node<Character> root) {
		if(root == null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
}
