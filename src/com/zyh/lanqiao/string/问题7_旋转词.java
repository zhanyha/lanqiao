package com.zyh.lanqiao.string;
/**
 * ���룺s1:ABCCD,s2:BCCD
 *�����YES
 *˼·������s1ƴ��һ������s2
 * @author zhanyuhao
 *
 */
public class ����7_��ת�� {

	public static void main(String[] args) {
		String s1 = "ABCCD";
		String s2 = "BCCD";
		System.out.println(solution(s1,s2));
	}

	private static boolean solution(String s1, String s2) {
		s1.concat(s1);
		return s1.contains(s2);
	}

}
