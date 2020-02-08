package com.zyh.lanqiao.dataStruct.tree.base;

import java.util.Scanner;


public class 基础操作5_翻转二叉树 {
	private static class Node<T>{
		T data;
		Node<T> left;
		Node<T> right;
	}
	static char[] chs;
	static int cur = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chs = sc.nextLine().toCharArray();
		Node<Character> root = create();
		inOrder(root);System.out.println();
		turnOver(root);
		inOrder(root);System.out.println();
		sc.close();
	}
	private static void turnOver(Node<Character> root) {
		if(root.left == null && root.right == null) return ;
		char tmp = 0;
		tmp = root.left.data;
		root.left.data = root.right.data;
		root.right.data = tmp;
		turnOver(root.left);
		turnOver(root.right);
	}
	private static Node<Character> create() {
		++cur;
		Node<Character> root = new Node<Character>();
		root.data = chs[cur];
		if(chs[cur] == '#') {
			return root;
		}
		root.left = create();
		root.right = create();
		return root;
	}
	private static void inOrder(Node<Character> root) {
		if(root==null) return;
		System.out.print(root.data+" ");
		inOrder(root.left);
		inOrder(root.right);
	}

}
