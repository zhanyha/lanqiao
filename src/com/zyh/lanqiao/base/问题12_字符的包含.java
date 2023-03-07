package com.zyh.lanqiao.base;

import java.util.Arrays;

public class 问题12_字符的包含 {

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "gfdsbcad";
		if(solution(str1,str2)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}

	private static boolean solution(String str1, String str2) {
		char[] cs = str2.toCharArray();
		Arrays.sort(cs);
		for (int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			if(Arrays.binarySearch(cs, ch) < 0) {
				return false;
			}
		}
		return true;
	}

}
