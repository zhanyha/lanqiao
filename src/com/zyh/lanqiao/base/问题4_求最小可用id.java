package com.zyh.lanqiao.base;

import com.zyh.lanqiao.utils.Utils;

/**
 * 例如：[1,8,3,4,6,7,2,9,9,9];
 * 输出： 最小可用id为：5；
 * @author zhanyuhao
 *
 */
public class 问题4_求最小可用id {
	public static void main(String[] args) {
		int[] arr = {1,3,2,6,5,4,8,9,10,11,12,14,13,15,17};
		Utils.print(arr);
		int solution = solution(arr,0,arr.length - 1);
		System.out.println(solution);
	}
	private static int solution(int[] arr,int q,int r) {
		int mid = (q+r)/2;
		int midValue = selectK(arr,q,r,mid);//中间值
		int e = mid + 1; //期望值
		if(q > r) {
			return q+1;
		}else {
			if(midValue > e) {
				return solution(arr,q,mid-1);
			}else {
				return solution(arr,mid+1,r);
			}
		}
	}
	private static int selectK(int[] arr, int q, int r,int k) {
		int pos = partition(arr,q,r);
		if(pos == k) {
			return arr[pos];
		}else {
			if(pos > k)
				return selectK(arr, q,pos-1,k);
			else
				return selectK(arr, pos+1, r,k);
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
