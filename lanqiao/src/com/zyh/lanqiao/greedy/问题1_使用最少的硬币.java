package com.zyh.lanqiao.greedy;

import java.util.Scanner;

//https://vjudge.net/problem/CSU-1926
/**a、b、c、d、s，
 * 5元的、10元的、20元的和50元的
 * 1 2 3 4 35
   1 2 3 4 567
 * @author zhanyuhao
 *1 1 1 0 3
 -1
 */
public class 问题1_使用最少的硬币 {
	static int a,b,c,d,s;
	static int a1,b1,c1,d1,cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean next = sc.hasNext();
		while(next) {
			 a = sc.nextInt();
			 b = sc.nextInt();
			 c = sc.nextInt();
			 d = sc.nextInt();
			 s = sc.nextInt();
		}
		solution();
		sc.close();
		
	}
	private static void solution() {
		while(s>=50) {
			d1++;
			s-=50;
		}
		while(s>=20) {
			c1++;
			s-=20;
		}
		while(s>=10) {
			b1++;
			s-=10;
		}
		while(s>=5) {
			a1++;
			s-=5;
		}
		if(s == 0) {
			System.out.printf("%d %d %d %d %d\n",a1,b1,c1,d1,(a1+b1+c1+d1));
		}else {
			System.out.println("-1");
		}
	}

}
