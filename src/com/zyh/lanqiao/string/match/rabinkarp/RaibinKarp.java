package com.zyh.lanqiao.string.match.rabinkarp;
/**
 * 字符串匹配方式二，计算字符串的滚动hash数组
 * @author zhanyuhao
 *
 */
public class RaibinKarp {
	final static long seed = 31;//31进制
	
	public static void main(String[] args) {
		String s = "abcdeabcab";
		String p = "bcab";
		long check = hash(p);
		long[] hashs = toHashArray(s,p.length());
		for (int i = 0; i < hashs.length; i++) {
			if(hashs[i] == check) {
				System.out.println(i);
				return ;
			}
		}
		System.out.println("未找到");
	}
	/**
	 * 滚动hash:先乘以seed
	 * 用来计算一个字符串的哈希数组，后面将用于匹配
	 * @param s
	 * @param plen 模式串的长度
	 * @return 字符串的哈希数组
	 */
	private static long[] toHashArray(String s,int plen) {
		char[] cs = s.toCharArray();
		int slen = s.length();
		long[] v = new long[slen - plen + 1];
		v[0] = hash(s.substring(0, plen));
		char remChar ='0';
		char curChar = '0';
		for (int i = plen; i < v.length + plen - 1; i++) {
			//滚动hash的精髓所在
			remChar = cs[i-plen];
			curChar = cs[i];
			v[i-plen+1] = (long) (v[i-plen] * seed + curChar - Math.pow(seed, plen)*remChar) % Long.MAX_VALUE;
		}
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i]+" ");
		}
		System.out.println();
		return v;
	}

	/**
	 * 计算方法为：类似进制转换
	 * @param p
	 * @return 返回一个long类型的hash值
	 */
	private static long hash(String p) {
		char[] cs = p.toCharArray();
		long value = cs[0];
		for (int i = 1; i < cs.length; i++) {
			value = value * seed +cs[i];
		}
		return value;
	}

}
