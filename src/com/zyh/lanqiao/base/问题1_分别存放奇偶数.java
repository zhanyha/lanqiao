package com.zyh.lanqiao.base;

import com.zyh.lanqiao.utils.Utils;

/**
 * 将一个数组的前半部分存放奇数，后半部分存放偶数
 * @author zhanyuhao
 */
public class 问题1_分别存放奇偶数 {

	public static void main(String[] args) {
		int[] arr = Utils.randomArray(10);
		Utils.print(arr);
		solution(arr,arr.length);
		Utils.print(arr);
	}
	public static void solution(int[] arr,int len) {
		int left = 0;
		int right = len - 1;
		int[] res = new int[len];
		int q = 0;
		int r = len - 1;
		while(left <= right) {
			if(arr[left] % 2 != 0) {
				res[q] = arr[left];
				q++;
			}else {
				res[r] = arr[left];
				r--;
			}
			if(arr[right] % 2 == 0) {
				res[r] = arr[right];
				r--;
			}else {
				res[q] = arr[right];
				q++;
			}
			left++;
			right--;
		}
		Utils.copyArray(arr, res);
	}

}
