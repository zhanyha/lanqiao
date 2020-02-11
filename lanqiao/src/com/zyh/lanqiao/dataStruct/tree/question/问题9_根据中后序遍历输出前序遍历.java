package com.zyh.lanqiao.dataStruct.tree.question;

import java.util.Scanner;

/**
 * https://pintia.cn/problem-sets/434/problems/6101
* @author zhanyuhao
* @version ����ʱ�䣺2020��2��10�� ����3:41:23
* ��˵��
* ��������:
*7
*2 3 1 5 7 6 4  -----�������
*1 2 3 4 5 6 7 ------�������
*�������:
*Preorder: 4 1 3 2 6 5 7
 */
public class ����9_�����к���������ǰ����� {
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
	 * ��Ϊ��������һ�����Ǹ���㣬��i���������ҵ��ø���㣬
	 * ��i�������Ϊ�����֣���������������ұ�������������Ϊ
	 * ��������򣨸����ң��� �����ȴ�ӡ����ǰ����㣬Ȼ���
	 * ӡ���������ٴ�ӡ�������� �������ں����еĸ����Ϊroot �C (end �C i + 1)��
	 * ��Ϊ��ǰ�����-�������ĸ������������������е� ��ʼ��start
	 * Ϊstart��ĩβend��Ϊi �C 1.�������ĸ����Ϊ��ǰ
	 * ������ǰһ�����root �C 1������������ʼ��startΪi+1��
	 * ĩβend��Ϊend��
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
	 * �Ƚ������������ڽ������������㷨
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
				in[i] = -1;//���Ϊ��ʹ�õĽڵ�
				break;
			}
		}
		if(rootIndex+1<=end && in[rootIndex+1]!=-1) {
			//˵����������
			root.right = preOrder(post, in, --cur, rootIndex + 1, end);
		}
		// ˵��������Ϊ�գ�����������
		if(end!=rootIndex)
			cur-=end-rootIndex-1;
		if(rootIndex-1>=start && in[rootIndex-1]!=-1) {
			root.left = preOrder(post,in,--cur,start,rootIndex-1);
		}
		return root;
	}

}
