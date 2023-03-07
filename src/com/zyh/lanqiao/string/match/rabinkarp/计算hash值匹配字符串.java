package com.zyh.lanqiao.string.match.rabinkarp;
/**
 * �ַ���ƥ�䷽ʽһ������hashֵ
 * @author zhanyuhao
 *
 */
public class ����hashֵƥ���ַ��� {
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
	 * ���㷽��Ϊ�����ƽ���ת��
	 * @param p
	 * @return ����һ��long���͵�hashֵ
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
