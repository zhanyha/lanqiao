package com.zyh.lanqiao.base;

import com.zyh.lanqiao.utils.Utils;

/**
 * ��һ�������ǰ�벿�ִ����������벿�ִ��ż��
 * @author zhanyuhao
 */
public class ����1_�ֱ�����ż�� {

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
