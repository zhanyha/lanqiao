package com.zyh.lanqiao.recursion;

import java.util.Arrays;

import com.zyh.lanqiao.utils.Utils;

/**
 * 把每一个元素都换到头部，对除了头部以外的所有元素进行全排列的思考模式
 * @author zhanyuhao
 *
 */
public class 问题7_集合的全排列II_回溯 {
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
