package com.zyh.lanqiao.base;

import com.zyh.lanqiao.utils.Utils;
/**
 * 题目默认升序，不考虑降序有序
 * @author zhanyuhao
 *
 */
public class 问题8_需要排序的子数组 {

	public static void main(String[] args) {
		int[] array = {2,4,3,4,6,8,8};
		Utils.print(array);
		int[] res = solution(array);
		Utils.print(res);
	}

	private static int[] solution(int[] array) {
		int len = array.length;
		int max = array[0];
		int min = array[len - 1];
		int left = 0;
		int right = len - 1;
		for (int i = 1; i < len; i++) {
			if(array[i] >= max) {
				max = array[i];
			}else {
				left = i;
			}
		}
		if(left == 0) {
			return new int[] {0,0};
		}
		for (int i = len - 1; i >= 0; i--) {
			if(array[i] <= min) {
				min = array[i];
			}else {
				right = i;
			}
		}
		return new int[] {right,left};
	}

}
