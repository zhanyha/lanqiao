package com.zyh.lanqiao.math;
/**
 * 有几堆石子，两个人拿，两个人都采用最优算法。最后拿完的那个人赢
 * 现在给你一个局面，让你判断能否一定赢
 * @author zhanyuhao
 *
 */
public class nim问题 {

	public static void main(String[] args) {
		int[] arr = new int[] {2,5,7};
		int res = nim(arr);
		if(res == 0) {
			System.out.println("一定输");
		}else {
			System.out.println("一定赢");
		}
	}

	private static int nim(int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res  = res ^ arr[i];
		}
		return res;
	}

}
