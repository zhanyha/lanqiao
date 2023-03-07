package com.zyh.lanqiao.string;

import java.util.*;

public class 问题6_判断两个字符串字符集是否相同 {

	public static void main(String[] args) {
		String s1 = "here are you";
		String s2 = "herayou";
		System.out.println(solution1(s1,s2));
		System.out.println(solution2(s1,s2));
	}

	private static boolean solution2(String s1, String s2) {
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		char c='0';
		for (int i = 0; i < s1.length(); i++) {
			c = s1.charAt(i);
			if(map.get(c) == null) {
				map.put(c, 1);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			c = s2.charAt(i);
			if(map.get(c) == null)
				return false;
		}
		return true;
	}

	private static boolean solution1(String s1, String s2) {
		int[] help = new int[128];
		int tmp = 0;
		for (int i = 0; i < s1.length(); i++) {
			tmp = s1.charAt(i);
			if(help[tmp] <=0) {
				help[tmp]++;
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			tmp = s2.charAt(i);
			help[tmp]--;
			if(help[tmp] < 0)
				return false;
		}
		return true;
	}
	

}
