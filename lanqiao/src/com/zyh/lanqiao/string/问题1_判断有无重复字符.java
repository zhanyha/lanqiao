package com.zyh.lanqiao.string;

public class 问题1_判断有无重复字符 {

	public static void main(String[] args) {
		String str = "abchegf";
		if(solution(str)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

	private static boolean solution(String str) {
		int[] help = new int[128];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(help[c] == 0)
				help[c]++;
			else
				return false;
		}
		return true;
	}

}
