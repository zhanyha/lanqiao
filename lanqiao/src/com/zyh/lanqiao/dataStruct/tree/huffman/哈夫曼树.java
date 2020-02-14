package com.zyh.lanqiao.dataStruct.tree.huffman;

import java.util.Scanner;

//1.初始化HT[1...2n-1]:lch=rch=parent=0
//2.输入初始n个叶子节点：置HT[1....n]的weight值；
//3.进行以下n-1次合并，依次产生n-1个节点HT[i]，i=n+1........n+2;
//     a).在HT[1...i-1]中选两个未被选过的weight最小的两个节点
//	   b).产生新的节点n+1.。。2n
//	   c).在修改新产生的HT[i]的weight 和children
public class 哈夫曼树 {
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
		HTNode[] huffTree = new HTNode[2*n];//0号不用
		for (int i = 1; i <= n; i++) {
			huffTree[i] = new HTNode();
			huffTree[i].weight = sc.nextInt();
		}
		//3.进行以下n-1次合并，依次产生n-1个节点HT[i]，i=n+1........n+2;
		for (int i = n+1; i < huffTree.length; i++) {
			//a).在HT[1...i-1]中选两个未被选过的weight最小的两个节点
			int[] s = Select(huffTree,i);
			//b).产生新的节点n+1.。。2n
			huffTree[i] = new HTNode();
			huffTree[i].weight = huffTree[s[0]].weight+huffTree[s[1]].weight;
			//c).在修改新产生的HT[i]的weight 和children
			huffTree[i].lch = s[0];
			huffTree[i].rch = s[1];
			huffTree[s[0]].parent = i;
			huffTree[s[1]].parent = i;
		}
		//得到huffman编码
		
		sc.close();
	}
//8
//7 19 2 6 32 3 21 10
	/**
	 * 
	 * @param huffTree
	 * @return 返回两个最小值的下标
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
