package com.zyh.lanqiao.math;

import java.util.Scanner;


public class 求第十万零二个素数 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long start = System.currentTimeMillis();
		int len = 2;
		while(len/Math.log(len) < n) {
			len++;
		}
		int[] arr = new int[len+2];
		arr[0] = -1;
		arr[1] = -1;
		int x = 2;
		int k = 2;
		while(x < n) {
			if(arr[x] < 0) {
				x++;
				continue;
			}
			while(x *k <len) {
				arr[x * k] = -1;
				k++;
			}
			k = 2;
			x++;
		}
		int i = findPrime(n,arr);
		System.out.println(i);
		long end = System.currentTimeMillis();
		System.out.println(end - start+"ms");
		sc.close();
	}

	private static int findPrime(int n,int[] arr) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				cnt++;
			}
			if(cnt == n) {
				return i;
			}
		}
		return -1;
	}

}
