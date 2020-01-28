package com.zyh.lanqiao.recursion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 问题4_合法括号 {
	static Set<String> set = new HashSet<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		recursion("", n, 0);
//		print(set);
		Set<String> set2 = solution(n);
		print(set2);
		sc.close();
	}
	/**
	 * 递推写法
	 * @param n
	 * @return
	 */
	private static Set<String> solution(int n) {
		Set<String> set = new HashSet<String>();
		
		String suff = "()";
		set.add(suff);
		if(n == 1) return set;
		for (int i = 2; i <= n; i++) {
			Set<String> newSet = new HashSet<String>();
			for (String s : set) {
				newSet.add("()"+s);
				newSet.add(s+"()");
				newSet.add("("+s+")");
			}
			set = newSet;
		}
		return set;
	}

	/**
	 * 递归写法
	 * @param suff
	 * @param n
	 * @param cur
	 */
	private static void recursion(String suff, int n, int cur) {
		if (n == cur) {
			set.add(suff);
			return;
		}
		recursion("()" + suff, n, cur + 1);
		recursion(suff + "()", n, cur + 1);
		recursion("(" + suff + ")", n, cur + 1);
	}

	private static void print(Set<String> set) {
		for (String s : set) {
			System.out.print(s + " ");
		}
	}
}
