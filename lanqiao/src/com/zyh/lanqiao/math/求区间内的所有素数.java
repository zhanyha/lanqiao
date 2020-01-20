package com.zyh.lanqiao.math;

import java.util.Scanner;

public class 求区间内的所有素数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = a; i < b; i++) {
			if(isPrime(i) && isReal(i)) {
				sb.append(","+i);
				cnt++;
			}
		}
		if(cnt == 0) {
			System.out.println("No");
		}else {
			System.out.println(sb.toString().substring(1));
		}
		sc.close();
	}

	private static boolean isReal(int n) {
		StringBuilder sb = new StringBuilder(n+"");
		sb.reverse();
		return isPrime(Integer.parseInt(sb.toString()));
	}

	private static boolean isPrime(int n) {
		if(n <= 1) return false;
		if(n == 2 ||n == 3 ) return true;
		if(n%6 != 1 && n%6 !=5) return false;
		for (int i = 5; i <= Math.sqrt(n); i+=6) {
			if(n % i== 0 || n % (i+2) == 0) 
				return false;
		}
		return true;
	}
}
