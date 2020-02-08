package com.zyh.lanqiao.dataStruct.tree.base;
import java.util.Scanner;

/**
 * ����һ����������Ҷ�ӽڵ���� DFS(��һ���Ƕ�����)
 * @author zhanyuhao
 *
 */
 //ABD##EH###CF#I##G##
public class ��������1_Ҷ�ӽڵ���� {
	private static class Node<E>{
		E data;
		Node<E> left;
		Node<E> right;
		public Node(){
		}
		public Node(E data) {
			this.data = data;
		}
	}
	static int cur = -1;
	static char[] chs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chs = sc.next().toCharArray();
		Node<String> root = create();
		int res = leaf(root);
		System.out.println(res);
		sc.close();
	}
	private static int leaf(Node<String> root) {
		if(root== null) return 0;
		if(root.left==null && root.right == null) return 1;
		return leaf(root.left) + leaf(root.right);
	}
	/**
	 * ��������ķ�ʽ����һ���� #�����
	 * @param cur 
	 * @param chs 
	 * @return
	 */
	public static Node<String> create(){
		++cur;
		if(chs[cur]=='#') {
			return null;
		}
		Node<String> p = new Node<String>(chs[cur]+"");
		p.left = create();
		p.right = create();
		return p;
	}
	public static void preOrder(Node<String> root) {
		if(root == null) return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
}
