package com.zyh.lanqiao.dataStruct.tree.question;

import java.util.Scanner;

/**
 * https://pintia.cn/problem-sets/434/problems/6101
* @author zhanyuhao
* @version 创建时间：2020年2月10日 下午3:41:23
* 类说明
* 输入样例:
*7
*2 3 1 5 7 6 4  -----先序遍历
*1 2 3 4 5 6 7 ------中序遍历
*输出样例:
*Preorder: 4 1 3 2 6 5 7
 */
public class 问题9_根据中后序遍历输出前序遍历 {
	private static class Node{
		int data;
		Node left;
		Node right;
	}
	static int[] post = null;
	static int[] in = null;
	static int s=-1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		post = new int[n];
		in = new int[n];
		for (int i = 0; i < n; i++)
			post[i] = sc.nextInt();
		for (int i = 0; i < n; i++) 
			in[i] = sc.nextInt();
//		Node root = preOrder(post,in,n-1,0,n-1);
		System.out.print("Preorder: ");
		preOrder02(post,in,n-1,0,n-1);
//		print(root);
		sc.close();
	}
	private static void print(Node root) {
		if(root==null)return ;
		++s;
		if(s!=post.length-1) {
			System.out.print(root.data+" ");
		}else
			System.out.print(root.data);
		print(root.left);
		print(root.right);
	}
	/**
	 * 因为后序的最后一个总是根结点，令i在中序中找到该根结点，
	 * 则i把中序分为两部分，左边是左子树，右边是右子树。因为
	 * 是输出先序（根左右）， 所以先打印出当前根结点，然后打
	 * 印左子树，再打印右子树。 左子树在后序中的根结点为root – (end – i + 1)，
	 * 即为当前根结点-右子树的个数。左子树在中序中的 起始点start
	 * 为start，末尾end点为i – 1.右子树的根结点为当前
	 * 根结点的前一个结点root – 1，右子树的起始点start为i+1，
	 * 末尾end点为end。
	 * @param post
	 * @param in
	 * @param root
	 * @param start
	 * @param end
	 */
	private static void preOrder02(int[] post, int[] in, int root, int start, int end) {
		if(start>end) {
			return;
		}
		int i=0;
		while(post[root]!=in[i]) {
			i++;
		}
		System.out.print(in[i]+" ");
		preOrder02(post,in,root-(end-i+1)-1,start,i-1);
		preOrder02(post,in,root-1,i+1,end);
	}
	/**
	 * 先建立右子树，在建立左子树的算法
	 * @param post
	 * @param in
	 * @param cur
	 * @param start
	 * @param end
	 * @return
	 */
	private static Node preOrder(int[] post, int[] in, int cur, int start, int end) {
		Node root = null;
		int rootIndex = 0;
		for (int i = start; i <= end; i++) {
			if(post[cur] == in[i]) {
				root = new Node();
				root.data = in[i];
				rootIndex = i;
				in[i] = -1;//标记为已使用的节点
				break;
			}
		}
		if(rootIndex+1<=end && in[rootIndex+1]!=-1) {
			//说明有右子树
			root.right = preOrder(post, in, --cur, rootIndex + 1, end);
		}
		// 说明右子树为空，生成左子树
		if(end!=rootIndex)
			cur-=end-rootIndex-1;
		if(rootIndex-1>=start && in[rootIndex-1]!=-1) {
			root.left = preOrder(post,in,--cur,start,rootIndex-1);
		}
		return root;
	}

}
