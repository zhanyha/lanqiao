package com.zyh.lanqiao.base;

import java.util.Arrays;

import com.zyh.lanqiao.utils.Utils;

public class 问题9_输出一组的数据的前K大的数 {

	public static void main(String[] args) {
		int[] arr = Utils.randomArray(10);
		Utils.print(arr);
		int K = 4;
		int pos = solution(arr,K);
		pos+=1;
		while(--pos >= 0 ) {
			System.out.print(arr[pos]+" ");
		}
		System.out.println();
		Arrays.sort(arr);
		Utils.print(arr);
	}

	private static int solution(int[] arr, int k) {
		return selectK(arr,0,arr.length-1,k-1);
	}
	private static int selectK(int[] arr,int start,int end,int k) {
	
			int pos = partition(arr,start,end);
			if(pos == k)
				return pos;
			else if(pos < k) {
				return selectK(arr, pos+1, end,k);
			}else {
				return selectK(arr, start, pos-1,k);
			}
	
	}
	private static int partition(int[] arr,int start,int end) {
		int left = start + 1;
		int right = end;
		int base = start;
		while(left <= right) {
			while(left <= right && arr[left] <= arr[base]) {
				left++;
			}
			while(left <= right && arr[right] > arr[base]) {
				right--;
			}
			if(left < right) {
				Utils.swap(arr, right,left);
			}
		}
		Utils.swap(arr, right, base);
		return right;
	}

}
