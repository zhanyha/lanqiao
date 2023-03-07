package com.zyh.lanqiao.math;

import java.util.*;
/**
 * 问题地址：https://vjudge.net/problem/POJ-1704
 * @author zhanyuhao
 *
 */
public class 阶梯nim问题 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if(n>0) {
				int[] arr = new int[n];
				for (int j = 0; j < n; j++) {
					arr[j] = sc.nextInt();
				}
				Arrays.sort(arr);
				int[] group = getGroup(arr);
				int nim = nim(group);
				if(nim == 0) {
					System.out.println("Bob will win");
				}else {
					System.out.println("Georgia will win");
				}
			}
		}
		
		sc.close();
	}

	private static int[] getGroup(int[] arr) {
		int len = arr.length;
		int[] res;
		int k = -1;
		if(len %2 == 0 ) {
			res = new int[len/2];
			for (int i = 0; i+1 < arr.length; i+=2) {
				res[++k] = arr[i+1] - arr[i];
			}
			k=-1;
		}else {
			res = new int[len - 1];
			for (int i = 0; i < arr.length - 1; i++) {
				res[i] = arr[i+1] - arr[i];
			}
		}
		return res;
	}

	private static int nim(int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res = res ^ arr[i];
		}
		return res;
	}

}
