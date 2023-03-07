package com.zyh.lanqiao.string.match.rabinkarp;
/**
 * �ַ���ƥ�䷽ʽ���������ַ����Ĺ���hash����
 * @author zhanyuhao
 *
 */
public class RaibinKarp {
	final static long seed = 31;//31����
	
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
		System.out.println("δ�ҵ�");
	}
	/**
	 * ����hash:�ȳ���seed
	 * ��������һ���ַ����Ĺ�ϣ���飬���潫����ƥ��
	 * @param s
	 * @param plen ģʽ���ĳ���
	 * @return �ַ����Ĺ�ϣ����
	 */
	private static long[] toHashArray(String s,int plen) {
		char[] cs = s.toCharArray();
		int slen = s.length();
		long[] v = new long[slen - plen + 1];
		v[0] = hash(s.substring(0, plen));
		char remChar ='0';
		char curChar = '0';
		for (int i = plen; i < v.length + plen - 1; i++) {
			//����hash�ľ�������
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
	 * ���㷽��Ϊ�����ƽ���ת��
	 * @param p
	 * @return ����һ��long���͵�hashֵ
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
