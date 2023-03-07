package com.zyh.lanqiao.recursion;

import java.util.ArrayList;
import java.util.List;

public class 问题6_子集生成之二进制法 {
	static String[] arr;
	static int n;
	public static void main(String[] args) {
		arr = new String[] {"A","B","C"};
		n = arr.length;
		List<String> list1 = solution1();
		System.out.println(list1.toString());
		List<List<String>> list = solution();
		System.out.println(list.toString());
	}
	private static List<List<String>> solution() {
		List<List<String>> res = new ArrayList<List<String>>();
		for (int i = (int) Math.pow(2, n)-1; i >= 1; i--) {
			List<String> list = new ArrayList<String>();
			for (int j = n-1; j >=0; j--) {
				if((i>>j & 1) == 1) { //判断第k位是不是1
					list.add(arr[j]+"");
				}
			}
			res.add(list);
		}
		return res;
	}
	private static List<String> solution1() {
		List<String> res = new ArrayList<String>(); 
		for (int i = (int) Math.pow(2, n)-1; i >= 1; i--) {
			StringBuilder sb = new StringBuilder();
			String binary = Integer.toString(i, 2);
			if(binary.length() < n) {
				while(binary.length() < n) {
					binary="0"+binary;
				}
			}
			for (int j = 0; j <= binary.length()-1; j++) {
				if(binary.charAt(j)-48 == 1) {
					sb.append(arr[n-1-j]);
				}
			}
			res.add(sb.toString());
		}
		return res;
	}

}
