package com.zyh.lanqiao.string.match.KMP;

public class ±©¡¶∆•≈‰ {

	public static void main(String[] args) {
		String s = "nbjkscbfbgaabbg";
		String p = "bg";
		System.out.println(solution(s,p));
	}

	private static int solution(String s, String p) {
		char[] sch = s.toCharArray();
		char[] pch = p.toCharArray();
		int q = 0, r=0;
		int sc = q;
		while(sc<s.length()) {
			if(sch[sc] == pch[r]) {
				sc++;
				r++;
				
			}else {
				sc = ++q;
				r = 0;
			}
			if((sc - q) == p.length()) {
				return q;
			}
			
		}
		return -1;
	}

}
