package com.zyh.lanqiao.string.match.rabinkarp;
/**
 * 字符串匹配方式一，计算hash值
 * @author zhanyuhao
 *
 */
public class 计算hash值匹配字符串 {
	final static long seed = 31;
	
	public static void main(String[] args) {
		String s = "abcdeabcab";//
		String p = "de";
		int res = solution(p,s);
		System.out.println(res);
	}

	private static int solution(String p, String str) {
		int plen = p.length();
		int slen = str.length();
		long target = hash(p);
		long cal = 0;
		for (int i = 0; i < slen-plen; i++) {
			cal = hash(str.substring(i, i+plen));
			if(cal == target) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 计算方法为：类似进制转换
	 * @param p
	 * @return 返回一个long类型的hash值
	 */
	private static long hash(String p) {
		char[] cs = p.toCharArray();
		long value = cs[0];
		for (int i =1; i < cs.length; i++) {
			value = value * seed +cs[i];
		}
		return value;
	}

}
