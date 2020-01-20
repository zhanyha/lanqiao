package com.zyh.lanqiao.math;

public class 欧几里得算法扩展贝祖等式 {
	static long x = -999;
	static long y = -999;
	
	public static void main(String[] args) {
		long a = linearEquation(2,7,1);
		System.out.println(a);
		System.out.println(x);
		System.out.println(y);
	}

	private static long linearEquation(long a,long b,long m) {
		long gcd = gcd(a,b);
		if(gcd == m ) {
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
