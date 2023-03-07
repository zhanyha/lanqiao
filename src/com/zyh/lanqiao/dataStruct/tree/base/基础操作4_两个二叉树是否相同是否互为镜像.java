package com.zyh.lanqiao.dataStruct.tree.base;

import java.util.Scanner;
//ACD##E##BF##G##
//ACD##E##BF##G##

//ACD##E##BF##G##
//ABG##F##CE##D##
public class 基础操作4_两个二叉树是否相同是否互为镜像 {
	private static class Node<T>{
		T data;
		int num;//编号
		Node<T> left;
		Node<T> right;
	}
	static char[] ch1;
	static char[] ch2;
	static int cur = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ch1 = sc.nextLine().toCharArray();
		ch2 = sc.nextLine().toCharArray();
		Node<Character> root1 = create(ch1);
		cur=-1;
		Node<Character> root2 = create(ch2);
		boolean isSame = isSame(root1,root2);
		boolean isMirror = isMirror(root1,root2);
		if(isSame) {
			System.out.println("same");
		}else {
			System.out.println("isn't same");
		}
		if(isMirror) {
			System.out.println("mirror");
		}else {
			System.out.println("isn't mirror");
		}
		sc.close();
	}
	
	private static boolean isMirror(Node<Character> root1, Node<Character> root2) {
		if(root1 == null&&root2==null) return true;
		if((root1==null &&root2!=null)||
				(root2==null&&root1!=null)) {
			return false;
		}
		if(root1.data !=root2.data) {
			return false;
		}
		return isMirror(root1.left,root2.right)&&isMirror(root1.right,root2.left);
	}

	private static boolean isSame(Node<Character> root1, Node<Character> root2) {
		if(root1 == null&&root2==null) return true;
		if((root1==null &&root2!=null)||
				(root2==null&&root1!=null)) {
			return false;
		}
		if(root1.data !=root2.data) {
			return false;
		}
		return isSame(root1.left,root2.left)&&isSame(root1.right,root2.right);
	}

	private static Node<Character> create(char[] ch) {
		++cur;
		if(ch[cur] == '#') {
			return null;
		}
		Node<Character> root = new Node<Character>();
		root.data = ch[cur];
		root.left = create(ch);
		root.right = create(ch);
		return root;
	}
}
