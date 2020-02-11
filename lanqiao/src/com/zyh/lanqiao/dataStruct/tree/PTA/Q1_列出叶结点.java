package com.zyh.lanqiao.dataStruct.tree.PTA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://pintia.cn/problem-sets/988034414048743424/problems/988039773131907072
 * 
 * @author zhanyuhao
 * @version ����ʱ�䣺2020��2��11�� ����3:40:14 ��˵��
 */
//8
//1 -
//- -
//0 -
//2 7
//- -
//- -
//5 -
//4 6

//�����
//4 1 5
public class Q1_�г�Ҷ��� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] tree = new int[1024];
		String[][] data = new String[n][2];
		int[] flag = new int[n];
		String d = null;
		Integer id = 0;
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < 2; k++) {
				d = sc.next();
				if (!d.equals("-")) {
					id = Integer.parseInt(d);
					flag[id] = -1;// ��ǳ���
				}
				data[i][k] = d;
			}
		}
		int root = -1;
		// �ҵ����ڵ�
		for (int i = 0; i < flag.length; i++) {
			if (flag[i] == 0) {
				root = i;
			}
		}
		Arrays.fill(tree, -1);
		List<Integer> res = new ArrayList<Integer>();
		// ����˳��洢������
		tree[1] = root;
		boolean isleaf = false;
		for (int i = 1; i < tree.length; i++) {
			isleaf = true;
			if (tree[i] == -1)
				continue;
			if (!data[tree[i]][0].equals("-")) {
				tree[2 * i] = Integer.parseInt(data[tree[i]][0]);
				isleaf = false;
			}
			if (!data[tree[i]][1].equals("-")) {
				tree[2 * i + 1] = Integer.parseInt(data[tree[i]][1]);
				isleaf = false;
			}
			if(isleaf){
				//Ҷ�ӽڵ�
				res.add(tree[i]);
			}
		}
		for (int i = 0; i < res.size(); i++) {
			if(i!=res.size()-1) {
				System.out.print(res.get(i)+" ");
			}else {
				System.out.println(res.get(i));
			}
		}
		sc.close();
	}

}
