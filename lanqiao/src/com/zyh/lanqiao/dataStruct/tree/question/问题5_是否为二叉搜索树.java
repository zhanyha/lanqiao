package com.zyh.lanqiao.dataStruct.tree.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * https://pintia.cn/problem-sets/988034414048743424/problems/988040258131861504
 * 
 * @author zhanyuhao
 * @version 创建时间：2020年2月9日 上午12:30:30 类说明
 */
public class 问题5_是否为二叉搜索树 {
	private static class Node {
		int data;
		Node left;
		Node right;
	}
	static Integer[] pre = null;
	static int cur = -1;
	static boolean flag=true;
	static boolean mayMirror =false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		pre = new Integer[n];
		for (int i = 0; i < pre.length; i++) {
			pre[i] = sc.nextInt();
		}
		if(n==1) {
			System.out.println("YES");
			System.out.println(pre[0]);
			return;
		}
		Integer[] in = pre.clone();
		if(pre[0]>pre[1]) {
			Arrays.sort(in);
		}else {
			mayMirror = true;
			Arrays.sort(in, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
		}
		boolean ok = false;
		Node root = null;
		if(mayMirror) {
			root = createMirror(pre,in,0,n-1);
			ok = isMirrorBST(root);
		}else {
			root = create(pre,in,0,n-1);
			ok = isBST(root);
		}
		if(ok && flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
			return;
		}
		cur=0;
		postOrder(root);
		sc.close();
	}
	private static void postOrder(Node root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		cur++;
		if(cur!=pre.length)
			System.out.print(root.data+" ");
		else
			System.out.print(root.data);
	}
	private static boolean isMirrorBST(Node root) {
		if(root==null) return true;
		if(root.left!=null) {
			if(root.left.data < root.data) {
				return false;
			}
			isMirrorBST(root.left);
		}
		if(root.right!=null) {
			if(root.right.data >= root.data) {
				return false;
			}
			isMirrorBST(root.right);
		}
		return true;
	}
	private static boolean isBST(Node root) {
		if(root==null) return true;
		if(root.left!=null) {
			if(root.left.data >= root.data) {
				return false;
			}
			isBST(root.left);
		}
		if(root.right!=null) {
			if(root.right.data < root.data) {
				return false;
			}
			isBST(root.right);
		}
		return true;
	}
	private static Node create(Integer[] pre2, Integer[] in,int start,int end) {
		if(flag == true) {
			if(start > end) {
				return null;
			}
			Node p = new Node();
			p.data = pre2[++cur];
			int rootIndex = 0;
			for (int i = start; i <= end; i++) {
				if(in[i] == p.data) {
					rootIndex = i;
					break;
				}
			}
			if(start!=0 && rootIndex==0) {
				flag = false;
			}
			p.left = create(pre2,in,start,rootIndex-1);
			p.right = create(pre2,in,rootIndex+1,end);
			return p;
		}else {
			return null;
		}
	}
	private static Node createMirror(Integer[] pre2, Integer[] in,int start,int end) {
		if(flag == true) {
			if(start > end) {
				return null;
			}
			Node p = new Node();
			p.data = pre2[++cur];
			int rootIndex = 0;
			for (int i = end; i >=start; i--) {
				if(in[i] == p.data) {
					rootIndex = i;
					break;
				}
			}
			if(start!=0 && rootIndex==0) {
				flag = false;
			}
			p.left = create(pre2,in,start,rootIndex-1);
			p.right = create(pre2,in,rootIndex+1,end);
			return p;
		}else {
			return null;
		}
	}
}
