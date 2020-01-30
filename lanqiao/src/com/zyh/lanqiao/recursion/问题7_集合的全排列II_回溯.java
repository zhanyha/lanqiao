package com.zyh.lanqiao.recursion;

import java.util.Arrays;

import com.zyh.lanqiao.utils.Utils;

/**
 * ��ÿһ��Ԫ�ض�����ͷ�����Գ���ͷ�����������Ԫ�ؽ���ȫ���е�˼��ģʽ
 * @author zhanyuhao
 *
 */
public class ����7_���ϵ�ȫ����II_���� {
	public static void main(String[] args) {
		 String[] arr = new String[] {"A","B","C"};
		 int n = arr.length;
		 recursion(arr,0,n);
	}
	private static void recursion(String[] arr,int start,int end) {
		if(start == end) {
			print(arr);
			return;
		}
		for (int i = start; i < end; i++) {
			Utils.swap(arr, i, start);
//			Arrays.sort(arr,start+1,end); 
			recursion(arr,start+1,end);
			Utils.swap(arr, start, i);
		}
	}
	private static void print(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

}
