package com.zyh.lanqiao.string;

public class 问题2_反转字符串 {

	public static void main(String[] args) {
		String str = "abcdefg";
		reverseString1(str);
		System.out.println();
		reverseString2(str);
	}

	private static void reverseString2(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		System.out.println(sb.toString());
	}

	private static void reverseString1(String str) {
		char[] chars = str.toCharArray();
		int q = 0;
		int r = str.length() - 1;
		char tmp='c';
		while(q<r) {
			tmp = chars[q];
			chars[q] = chars[r];
			chars[r] = tmp;
			q++;
			r--;
		}
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]+" ");
		}
	}

}
