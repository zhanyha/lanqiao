package com.zyh.lanqiao.string;

public class 问题9_去掉k个连续的0 {

	public static void main(String[] args) {
		String str = "10001001";
		int k = 2;
		System.out.println(str);
		str = solution(str,k);
		System.out.println(str);
	}

	private static String solution(String str,int k) {
		String regex="0{"+k+"}";
		str = str.replaceAll(regex, "");
		return str;
	}

}
