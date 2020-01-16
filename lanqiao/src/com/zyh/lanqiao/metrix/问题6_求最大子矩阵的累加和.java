package com.zyh.lanqiao.metrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zyh.lanqiao.utils.Utils;

public class 问题6_求最大子矩阵的累加和 {

	public static void main(String[] args) {
		int[][] arr = {
				{1,2,-1,-1},
				{-1,-2,-2,4},
				{1,-1,3,4},
				{-1,-1,0,0}
		};
		int x = solution(arr);
		System.out.println(x);
	}
	private static int solution(int[][] arr) {
		int[] rec = new int[arr[0].length];
		int max = -1;
		Arrays.fill(rec, 0);
		int beginRow = 0;
		int n = arr.length;
		while(beginRow < n) {
			for (int j = beginRow; j < arr.length; j++) {
				//按列求和
				for (int k = 0; k < arr.length; k++) {
					rec[k] += arr[j][k];
				}
				max = Math.max(max,findArrayMax(rec));
			}
			Arrays.fill(rec, 0);
			beginRow++;
		}
		return max;
	}//2 -1 3 4 -5 -6
	private static int findArrayMax(int[] arr) {
		int p = 1;
		int len = arr.length;
		int tmp = arr[0];
		int max = arr[0];
		while(p<len) {
			if(arr[p] + tmp > 0) {
				tmp+=arr[p];
			}else {
				tmp = arr[p];
			}
			if(tmp > max) {
				max = tmp;
			}
			p++;
		}
		return max;
	}
	

}
