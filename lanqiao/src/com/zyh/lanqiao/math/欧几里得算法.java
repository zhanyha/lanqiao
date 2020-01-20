package com.zyh.lanqiao.math;

import java.util.Scanner;

public class 欧几里得算法 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int gcd = gcd(n,m);
		System.out.println(gcd);
		sc.close();
	}

	private static int gcd(int n, int m) {
		if(n == 0) {
			return m;
		}else {
			return gcd(m%n,n);
		}
	}

}
