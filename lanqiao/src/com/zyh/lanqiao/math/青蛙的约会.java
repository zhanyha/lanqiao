package com.zyh.lanqiao.math;

import java.util.*;

public class 青蛙的约会 {
	static long t = 0;
	static long r = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long y = sc.nextLong();
		long m = sc.nextLong();
		long n = sc.nextLong();
		long L = sc.nextLong();
		long gcd = linearEquation(n-m,L,x-y);
		if(m % gcd != 0) {
			System.out.println("Impossible");
		}else {
			long b = L/gcd;
			b = Math.abs(b);
			t= (t%b+b)%b;
	        System.out.println(t);
		}
		sc.close();
	}
	private static long linearEquation(long a,long b,long m) {
		long gcd = gcd(a,b);
		t *= m/gcd;
		r *= m/gcd;
		return gcd;
	}
	private static long gcd(long a,long b) {
		if(b == 0) {
			t=1;
			r=0;
			return a;
		}
		long res = gcd(b,a%b);
		long t1 = t;
		t = r;
		r = t1 - (a/b) * r;
		return res;
	}
}
