package com.zyh.lanqiao.math;

import java.util.Scanner;

public class ���������� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int res = quickExp(n,m);
		System.out.println(res);
		sc.close();
	}
	public static int quickExp(int n,int m) {
		int res = 1;
		while(m > 0) {
			if((m&1)==1) {
				res *= n;
			}
			n =  n*n;
			m = m>>1;
		}
		return res;
	}
//	private static  int quickExp(int n, int m) {
//		if(m == 1)
//			return n;
//		int tmp = n;
//		int e = 1;
//		while( (e<<1) <m) {
//			tmp = tmp * tmp;
//			e = e << 1;
//		}
//		return tmp * quickExp(n, m-e);
//	}

}
