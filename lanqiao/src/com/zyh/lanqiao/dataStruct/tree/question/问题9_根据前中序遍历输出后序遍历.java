package com.zyh.lanqiao.dataStruct.tree.question;

import java.util.Scanner;

/**
 *重点 ********
* @author zhanyuhao
* @version 创建时间：2020年2月10日 下午5:19:24
* 类说明
 */
public class 问题9_根据前中序遍历输出后序遍历 {
	static int[] pre = null;
	static int[] in = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		pre = new int[n];
		in = new int[n];
		for (int i = 0; i < n; i++)
			pre[i] = sc.nextInt();
		for (int i = 0; i < n; i++) 
			in[i] = sc.nextInt();
		postOrder(pre,in,0,0,n-1);
		sc.close();
	}
//7
//8 6 5 7 9 10 8 11
//5 6 7 8 8 9 10 11
	private static void postOrder(int[] pre, int[] in,int cur,int start,int end) {
		if(start>end)return;//节点为空的情况
		if(start==end) {
			System.out.print(in[start]+" ");
			return;
		}
		int root = pre[cur];
		int rootIndex=0;
		for (int i = start; i < end; i++) {
			if(in[i] == root) {
				rootIndex = i;
				break;
			}
		}
		postOrder(pre,in,++cur,start,rootIndex-1);
		cur+=rootIndex-1-start;
		postOrder(pre,in,++cur,rootIndex+1,end);
		System.out.println(root);
		
	}

}
