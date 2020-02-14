package com.zyh.lanqiao.dataStruct.tree.huffman;

import java.util.Scanner;

public class 哈夫曼编码 {
	static HTNode[] huffTree=null;
	static int n;
	public static class HTNode{
		String data;
		int weight;
		int parent;
		int lch;
		int rch;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();sc.nextLine();
		huffTree = new HTNode[2*n-1];
		String[] data = sc.nextLine().split(" ");
		for (int i = 0; i < data.length; i+=2) {
			huffTree[i/2] = new HTNode();
			huffTree[i/2].data = data[i];
			huffTree[i/2].weight = Integer.parseInt(data[i+1]);
		}
		buildHT();
		String[] codes = getCode();
		for (String string : codes) {
			System.out.println(string);
		}
		sc.close();
	}
	private static String[] getCode() {
		int parent=0;
		int child =0;
		String[] cd = new String[n];
		for (int i = 0; i < n; i++) {//对于每一个叶子节点求编码
			StringBuilder sb = new StringBuilder();
			child = i;///////////////////////////////这里是大坑
			//需要用一个变量来存当前的孩子节点编号
			parent = huffTree[i].parent;
			while(parent!=0) {
				if(huffTree[parent].lch==child) {//说明是左孩子
					sb.append(0);
				}else {
					sb.append(1);
				}
				child = parent;
				parent = huffTree[parent].parent;
			}
			cd[i] = sb.reverse().toString();
		}
		return cd;
	}
	private static void buildHT() {
		int[] s=null;
		for (int i = n; i < huffTree.length; i++) {
			s = selectTwoMin(huffTree,i);
			huffTree[i] = new HTNode();
			huffTree[i].weight = huffTree[s[0]].weight+huffTree[s[1]].weight;
			huffTree[i].lch = s[0];
			huffTree[i].rch = s[1];
			huffTree[s[0]].parent = i;
			huffTree[s[1]].parent = i;
		}
	}
	private static int[] selectTwoMin(HTNode[] huffTree, int len) {
		int m1=9999,m2=9999;
		int i1 = -1,i2 = -1;
		int v;
		for (int i = 0; i < len; i++) {
			v = huffTree[i].weight;
			if(huffTree[i].parent==0) {
				if(m1>v) {
					m2 = m1;
					m1 = v;
					i2=i1;
					i1=i;
				}else if(m2>v) {
					m2=v;
					i2=i;
				}
			}
		}
		return new int[] {i1,i2};
	}

}
