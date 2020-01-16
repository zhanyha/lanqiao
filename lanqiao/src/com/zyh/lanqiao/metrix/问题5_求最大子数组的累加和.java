package com.zyh.lanqiao.metrix;

public class 问题5_求最大子数组的累加和 {

	public static void main(String[] args) {
		int[] arr = {2,-1,4,-3,5,-6};
		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		int p = 1;
		int len = arr.length - 1;
		int max = arr[0];
		int tmp = arr[0];
		while(p<=len) {
			if(tmp > 0) {
				tmp+=arr[p];
			}else {
				tmp = arr[p];
			}
			if(tmp > max) {
				max = tmp;
				System.out.println(max);
			}
			p++;
		}
		return max;
	}
}
