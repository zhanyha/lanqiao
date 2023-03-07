package com.zyh.lanqiao.string;
/**
 * 输入：s1:ABCCD,s2:BCCD
 *输出：YES
 *思路：两个s1拼接一定包含s2
 * @author zhanyuhao
 *
 */
public class 问题7_旋转词 {

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
