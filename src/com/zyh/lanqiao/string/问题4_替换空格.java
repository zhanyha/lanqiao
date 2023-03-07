package com.zyh.lanqiao.string;

public class Œ Ã‚4_ÃÊªªø’∏Ò {

	public static void main(String[] args) {
		String str = "https://baidu.com?s=hello world";
		str = solution(str);
		System.out.println(str);
	}

	private static String solution(String str) {
		str  = str.replaceAll("\\s", "%20");
		return str;
	}
	
}