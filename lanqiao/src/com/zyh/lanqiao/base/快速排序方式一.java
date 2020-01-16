package com.zyh.lanqiao.base;

import java.util.*;
import com.zyh.lanqiao.utils.*;

class 快速排序方式一{
	/**
	 * 快速排序（单向扫描法）
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Utils.randomArray(10);
		Utils.print(arr);
		quickSort(arr,0,arr.length-1);
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]+" ");
		}
		sc.close();
	}

	private static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = partition(arr,left,right);
			quickSort(arr, left, mid-1);
			quickSort(arr, mid+1, right);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int base = start;
		int left = start + 1;
		int right = end;
		while(left <= right) {
			if(arr[left]<=arr[base]) {
				left++;
			}else {
				Utils.swap(arr, left, right);
				right--;
			}
		}
		Utils.swap(arr, right, base);
		return right;
	}
	
}
