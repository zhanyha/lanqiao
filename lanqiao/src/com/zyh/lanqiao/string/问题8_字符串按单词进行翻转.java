package com.zyh.lanqiao.string;
/**
 * ���룺here are you
 * �����you are here
 * @author zhanyuhao
 *
 */
public class ����8_�ַ��������ʽ��з�ת {

	public static void main(String[] args) {
		String str = "here are you";
		System.out.println(str);
		str = solution(str);
		System.out.println(str);
	}

	private static String solution(String str) {
		str = reverseString(str);
		String[] strs = str.split("\\s");
		StringBuilder res  = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			res.append(reverseString(strs[i])+" " );
		}
		return res.toString();
	}
	private static String reverseString(String str) {
		StringBuilder sb = new StringBuilder(str);
		str = sb.reverse().toString();
		return str;
	}
}
