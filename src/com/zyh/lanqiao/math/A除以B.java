package com.zyh.lanqiao.math;

import java.util.Scanner;

public class A除以B {
	static long x;
	static long y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			long n = sc.nextLong();
			long B = sc.nextLong();
			linearEquation(B,9973,n);
			while(x>0) x-=9973;
			while(x<0) x+=9973;
			System.out.println(x);
		}
		sc.close();
	}
	private static long linearEquation(long a,long b,long m) {
		long gcd = gcd(a,b);
		if(m%gcd == 0 ) {
			x *= m/gcd ;
			y *= m/gcd ;
		}else {
			System.out.println("无解");
		}
		return gcd;
	}

	private static long gcd(long a,long b) {
		if(b == 0) {
			x = 1;
			y = 0;
			return a;
		}
		long res = gcd(b,a%b); // 这里就是欧几里得算法
		long x1 = x;
		x = y;
		y = x1 - a/b * y;
		return res;
	}
}
