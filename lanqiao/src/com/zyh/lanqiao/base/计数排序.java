package com.zyh.lanqiao.base;

import com.zyh.lanqiao.utils.Utils;

public class ¼ÆÊýÅÅÐò {

	public static void main(String[] args) {
		int[] arr = Utils.randomArray(10);
		Utils.print(arr);
		countSort(arr);
	}

	private static void countSort(int[] arr) {
		int max = getMax(arr);
		int[] res = new int[max+1];
		for (int i = 0; i < arr.length; i++) {
			res[arr[i]]++;
		}
		for (int i = 0; i < max+1; i++) {
			while(res[i]-- > 0) {
				System.out.print(i+" ");
			}
		}
	}
	private static int getMax(int[] arr) {
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[max]) {
				max = i;
			}
		}
		return arr[max];
	}

}
