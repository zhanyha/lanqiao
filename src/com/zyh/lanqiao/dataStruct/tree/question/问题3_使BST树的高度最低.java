package com.zyh.lanqiao.dataStruct.tree.question;

import java.util.Scanner;

/**
 * ����һ���ź�������飬����һ�Ŷ�����������ʹ�����ĸ߶����
 * @author zhanyuhao
 * 7
 * 1 2 3 4 5 6 7
 * ��ô�߶���С�Ķ�����������������
 *      4
 *   2     6
 * 1   3 5   7
 * ˼·��ÿ��ȡ�м������Ȼ��ݹ����������������
 */
//7
//1 2 3 4 5 6 7
public class ����3_ʹBST���ĸ߶���� {
	private static class Node{
		int data;
		Node left;
		Node right;
		Node parent;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Node root = create(arr,0,n-1);
		inOrder(root);
		sc.close();
	}

	private static void inOrder(Node root) {
		if(root==null) {
			return ;
		}
		inOrder(root.left);
		System.out.print(root.data+"  ");
		inOrder(root.right);
	}

	private static Node create(int[] arr, int start, int end) {
		Node p = new Node();
		int mid = start+((end-start)>>1);
		p.data = arr[mid];
		if(start>=end) {
			return p;
		}
		p.left = create(arr,start,mid-1);
		p.right = create(arr,mid+1,end);
		return p;
	}
}
