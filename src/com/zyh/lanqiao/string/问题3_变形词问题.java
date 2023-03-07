package com.zyh.lanqiao.string;

import java.util.Arrays;

public class 问题3_变形词问题 {

	public static void main(String[] args) {
		String ss = "abbba";
		String sp = "aabbbb";
		boolean b = solution1(ss,sp);
		boolean b2 = solution2(ss,sp);
		System.out.println(b);
		System.out.println(b2);
	}

	private static boolean solution2(String ss, String sp) {
		int[] help = new int[128];
		for (int i = 0; i < ss.length(); i++) {
			help[ss.charAt(i)]++;
		}
		for (int i = 0; i < sp.length(); i++) {
			if(help[sp.charAt(i)] <= 0 ) {
				return false;
			}
			help[sp.charAt(i)]--;
		}
		return true;
	}

	private static boolean solution1(String ss, String sp) {
		char[] cs1 = ss.toCharArray();
		Arrays.sort(cs1);
		char[] cs2 = sp.toCharArray();
		Arrays.sort(cs2);
		if(Arrays.equals(cs1, cs2)) {
			return true;
		}
		return false;
	}

}
