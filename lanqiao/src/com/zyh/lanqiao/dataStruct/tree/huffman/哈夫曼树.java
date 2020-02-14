package com.zyh.lanqiao.dataStruct.tree.huffman;

import java.util.Scanner;

//1.��ʼ��HT[1...2n-1]:lch=rch=parent=0
//2.�����ʼn��Ҷ�ӽڵ㣺��HT[1....n]��weightֵ��
//3.��������n-1�κϲ������β���n-1���ڵ�HT[i]��i=n+1........n+2;
//     a).��HT[1...i-1]��ѡ����δ��ѡ����weight��С�������ڵ�
//	   b).�����µĽڵ�n+1.����2n
//	   c).���޸��²�����HT[i]��weight ��children
public class �������� {
	static HTNode[] huffTree = null;
	private static class HTNode{
		int weight;
		int parent;
		int lch;
		int rch;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HTNode[] huffTree = new HTNode[2*n];//0�Ų���
		for (int i = 1; i <= n; i++) {
			huffTree[i] = new HTNode();
			huffTree[i].weight = sc.nextInt();
		}
		//3.��������n-1�κϲ������β���n-1���ڵ�HT[i]��i=n+1........n+2;
		for (int i = n+1; i < huffTree.length; i++) {
			//a).��HT[1...i-1]��ѡ����δ��ѡ����weight��С�������ڵ�
			int[] s = Select(huffTree,i);
			//b).�����µĽڵ�n+1.����2n
			huffTree[i] = new HTNode();
			huffTree[i].weight = huffTree[s[0]].weight+huffTree[s[1]].weight;
			//c).���޸��²�����HT[i]��weight ��children
			huffTree[i].lch = s[0];
			huffTree[i].rch = s[1];
			huffTree[s[0]].parent = i;
			huffTree[s[1]].parent = i;
		}
		//�õ�huffman����
		
		sc.close();
	}
//8
//7 19 2 6 32 3 21 10
	/**
	 * 
	 * @param huffTree
	 * @return ����������Сֵ���±�
	 */
	private static int[] Select(HTNode[] huffTree,int len) {
		int m1=9999,m2=9999;
		int i1=0,i2=0;
		int v=0;
		for (int i = 1; i < len; i++) {
			v = huffTree[i].weight;
			if(huffTree[i].parent==0){
				if (m1 > v) {
					m2 = m1;
					i2 = i1;
					m1 = v;
					i1 = i;
				} else if (m2 > v) {
					m2 = v;
					i2 = i;
				}
			}
		}
		return new int[]{i1,i2};
	}

}
