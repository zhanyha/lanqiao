package com.zyh.lanqiao.base;

import java.util.Arrays;

import com.zyh.lanqiao.utils.Utils;

public class 问题5_求逆序数的个数 {
	static int NUM = 0;
	public static void main(String[] args) {
		int[] arr = Utils.randomArray(8);
		Utils.print(arr);
		solution(arr,0,arr.length - 1);
		Utils.print(arr);
		System.out.println(NUM);
		
	}
	private static void solution(int[] arr,int start,int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			solution(arr,start,mid);
			solution(arr,mid+1,end);
			merge(arr,start,mid,end);
		}
	}
	private static void merge(int[] arr,int start,int mid,int end) {
		int left = start;
		int right = mid + 1;
		int current = start;
		int[] copyArr = Arrays.copyOf(arr, arr.length);
		
		while(left <= mid && right <= end) {
			if(copyArr[left] <= copyArr[right]) {
				arr[current] = copyArr[left];
				current++;
				left++;
			}else {
				arr[current] = copyArr[right];
				current++;
				right++;
				NUM += mid - left + 1;
			}
		}
		while(left <= mid) {
			arr[current] = copyArr[left];
			current++;
			left++;
		}
	}

}
