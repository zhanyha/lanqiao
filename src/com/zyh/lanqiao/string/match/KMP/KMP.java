package com.zyh.lanqiao.string.match.KMP;

import com.zyh.lanqiao.utils.Utils;

public class KMP {

	public static void main(String[] args) {
		String s = "abcdabcde";
		String p = "cda";
		System.out.println(solution(s,p));
	}

	private static int solution(String s, String p) {
		int[] next = next(p);
		char[] sch = s.toCharArray();
		char[] pch = p.toCharArray();
		int r=0;
		int sc = 0;
		while(sc<s.length()) {
			if(r==-1||sch[sc] == pch[r]) {
				sc++;
				r++;
			}else {
				r = next[r];
			}
			if(r == p.length()) {
				return sc - r + 1;
			}
			
		}
		return -1;
	}
	private static int[] next(String p) {
		int[] next = new int[p.length()];
		char[] chs = p.toCharArray();
		int k = -1;
		next[0] = k;
		int sc = 0;
		while(sc<p.length() - 1) {
			if(k == -1 || chs[sc] == chs[k]) {
				k++;
				sc++;
				next[sc] = k;
			}else {
				k = next[k];
			}
		}
		return next;
	}

}
