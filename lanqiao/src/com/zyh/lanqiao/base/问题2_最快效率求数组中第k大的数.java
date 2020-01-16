package com.zyh.lanqiao.base;
import java.util.Arrays;

import com.zyh.lanqiao.utils.Utils;

/**
 * 以最快效率求数组中第k大的数
 * @author zhanyuhao
 */
public class 问题2_最快效率求数组中第k大的数 {

	public static void main(String[] args) {
		int k = 3;
		
		int[] arr = Utils.randomArray(10);
		Utils.print(arr);
		solution(arr,0,arr.length - 1,k - 1);
		Arrays.sort(arr);
		Utils.print(arr);
	
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
