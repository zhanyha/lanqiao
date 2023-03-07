package com.zyh.lanqiao.dataStruct.tree.question;
import java.util.Scanner;

public class 问题8_判断一个树是否为另一棵树的子树 {
	private static class Node<T>{
		T data;
		Node<T> left;
		Node<T> right;
		public Node(T data) {
			this.data = data;
		}
	}
	static char[] A;
	static char[] B;
	static int cur = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLine().toCharArray();
		B = sc.nextLine().toCharArray();
		Node<Character> root1 = create(A);
		cur=-1;
		Node<Character> root2 = create(B);
		if(isSonTree(root1,root2))//判断root2时尚芭莎root1的子树
		{
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		sc.close();
	}
	private static boolean isSonTree(Node<Character> root1, Node<Character> root2) {
		if(root1==null||root2==null) return true;
		if(root2.data!=root1.data) {
			return isSonTree(root1.left,root2)||isSonTree(root1.right,root2);
		}else {
			return isSonTree(root1.left,root2.left)
					&&isSonTree(root1.right,root2.right);
		}
	}
	private static Node<Character> create(char[] chs) {
		++cur;
		if(chs[cur] == '#') {
			return null;
		}
		Node<Character> root = new Node<Character>(chs[cur]);
		root.left = create(chs);
		root.right = create(chs);
		return root;
	}
}
