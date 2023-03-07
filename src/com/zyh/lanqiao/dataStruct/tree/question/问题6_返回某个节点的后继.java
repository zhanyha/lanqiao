package com.zyh.lanqiao.dataStruct.tree.question;

import java.util.Scanner;

public class 问题6_返回某个节点的后继 {
	private static class Node{
		int data;
		Node left;
		Node right;
		Node parent;
		public Node(int data) {
			super();
			this.data = data;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node root = null;
		int[] arr= new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			root = createBST02(root,arr[i]);
		}
		int target = sc.nextInt();
		inOrder(root);System.out.println();
		successor02(root,target);
		sc.close();
	}
	/**
	 * 无parent指针的后继寻找方法。中序遍历方法
	 * @param root
	 * @param target
	 * @return
	 */
	static boolean flag = false;
	private static void successor02(Node root, int target) {
		if(root==null) return ;
		
		successor02(root.left,target);
		if(flag == true) {
			System.out.println(root.data);
			System.exit(0);
		}
		if(target == root.data) {
			flag = true;
		}
		successor02(root.right,target);
		
	}
	/**
	 * 有parent指针的后继节点寻找方法
	 * @param root
	 * @param target
	 * @return
	 */
	private static int successor(Node root, int target) {
		Node cur = root;
		//1.先定位
		while(cur!=null) {
			if(target < cur.data) {
				cur = cur.left;
			}else if(target > cur.data) {
				cur = cur.right;
			}else {
				//定位成功
				break;
			}
		}
		if(cur==null)//没找到，说明节点不存在
			return 0;//这里的0代表没找到
		if(cur.right!=null) {
			//2.如果有右子树 ，后继出现得右子树上，返回右子树得最小值
			cur = cur.right;
			while(cur!=null) {
				cur = cur.left;
			}
			return cur.data;
		}else {
			//3.否则，后继出现在左子树上，返回第一个不是右孩子节点的父节点
			Node parent = cur.parent;
			if(parent!=null&&parent.left!=cur) {
				cur = parent;
				parent = cur.parent;
			}
			return parent.data;
		}
	}
	/**
	 * 有parent指针得二搜索叉树生成算法
	 * @param root
	 * @param data
	 * @return
	 */
	private static Node createBST02(Node root, int data) {
		if(root==null) return new Node(data);
		Node parent = null;
		Node cur = root;
		boolean isLeft=true;
		while(cur!=null) {
			if(data < cur.data) {
				parent = cur;
				cur = cur.left;
				isLeft=true;
			}else{
				parent = cur;
				cur = cur.right;
				isLeft=false;
			}
		}
		cur = new Node(data);
		cur.parent = parent;
		if(isLeft) {
			parent.left = cur;
		}else {
			parent.right = cur;
		}
		return root;
	}
	/**
	 * 不需要parent指针的递归构造BST的算法
	 * @param root
	 * @param data
	 * @return 根节点
	 */
	private static Node createBST(Node root, int data) {
		if(root==null) return new Node(data);
		if(data < root.data) {
			createBST(root.left,data); 
		}else {
			createBST(root.right,data); 
		}
		return root;
	}
	private static void inOrder(Node root) {
		if(root==null) return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
}
