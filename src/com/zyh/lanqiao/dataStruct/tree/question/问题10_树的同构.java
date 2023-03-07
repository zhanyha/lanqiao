package com.zyh.lanqiao.dataStruct.tree.question;

import java.util.Scanner;

/**
 * https://pintia.cn/problem-sets/988034414048743424/problems/988039710297038848
 * 
 * @author zhanyuhao
 * @version ����ʱ�䣺2020��2��10�� ����11:58:47 ��˵�� ����������T1��T2�����T1����ͨ�����ɴ����Һ��ӻ����ͱ��T2��
 *          �����ǳ��������ǡ�ͬ�����ġ�����ͼ1����������������ͬ���ģ� ��Ϊ���ǰ�����һ�����Ľ��A��B��G�����Һ��ӻ����󣬾͵õ�
 *          ����һ��������ͼ2�Ͳ���ͬ���ġ� 1.������ 1.1
 */
public class ����10_����ͬ�� {
	private static class Node implements Cloneable {
		String data;
		int num;
		Node left;
		Node right;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node root1 = read(sc);
		Node root2 = read(sc);
		if(isSameBuild(root1,root2)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		sc.close();
	}

	private static boolean isSameBuild(Node root1, Node root2) {
		if(root1==null&&root2==null)return true;
		if(root1==null||root2==null)return false;
		if(!root1.data.equals(root2.data)) {
			return false;
		}else if(isSameBuild(root1.left,root2.left)&&isSameBuild(root1.right,root2.right)) {
			return true;
		}else if(isSameBuild(root1.right,root2.left)&&isSameBuild(root1.left,root2.right)) {
			return true;
		}
//		if(!(root1.left.data==root2.left.data&&root1.right.data==root2.right.data)) {
//			return false;
//		}else if(!(root1.left.data==root2.right.data&&root1.right.data==root2.left.data)) {
//			return false;
//		}
		return false;
	}

	private static Node read(Scanner sc) {
		int n = sc.nextInt();sc.nextLine();
		Node[] nodes = new Node[n];
		int[] flag = new int[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node();
			nodes[i].num = i;
			String[] row = sc.nextLine().split(" ");
			nodes[i].data = row[0];
			if (!row[1].equals("-")) {
				nodes[i].left = new Node();
				nodes[i].left.num = Integer.parseInt(row[1]);
				flag[nodes[i].left.num] = 1;//��ǳ��ֹ��ĺ���
			}
			if (!row[2].equals("-")) {
				nodes[i].right = new Node();
				nodes[i].right.num = Integer.parseInt(row[2]);
				flag[nodes[i].right.num] = 1;//��ǳ��ֹ��ĺ���
			}
		}
		// ������
		for (int j = 0; j < n; j++) {
			if (nodes[j].left != null) {
				nodes[j].left = nodes[nodes[j].left.num];
			}
			if (nodes[j].right != null) {
				nodes[j].right = nodes[nodes[j].right.num];
			}
		}
		//Ѱ�Ҹ��ڵ㣬���ڵ㲻���κνڵ�ĺ���
		//����ֻ��Ҫ�ҵ�δ���ֵĺ��Ӽ���
		for (int i = 0; i < flag.length; i++) {
			if(flag[i]==0) {
				return nodes[i];
			}
		}
		return null;
	}
}
