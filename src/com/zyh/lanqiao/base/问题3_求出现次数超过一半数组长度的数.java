package com.zyh.lanqiao.base;


import com.zyh.lanqiao.utils.Utils;

/**
 * @author zhanyuhao
 */
public class 问题3_求出现次数超过一半数组长度的数 {
	
	public static void main(String[] args) {
		int[] arr = {8,2,8,4,1,6,8,8,8};
		solution(arr, 0, arr.length - 1, arr.length/2);
	}
	private static void solution(int[] arr, int q, int r,int k) {
		int pos = partition(arr,q,r);
		if(pos == k) {
			System.out.println(arr[pos]);
			return ;
		}else {
			if(pos > k)
				solution(arr, q,pos-1,k);
			else
				solution(arr, pos+1, r,k);
		}
	}
	public static int partition(int[] arr,int q,int r) {
		int left = q+1;
		int right = r;
		int base = q;
		while(left <= right) {
			while(left<=right && arr[left] <= arr[base]) {
				left++;	
			}
			while(left<=right && arr[right] > arr[base]) {
				right--;
			}
			if(left < right)
				Utils.swap(arr, right, left);
		}
		Utils.swap(arr, base, right);
		return right;
	}
	
}
