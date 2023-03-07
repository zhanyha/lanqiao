package com.zyh.lanqiao.base;

import java.util.*;

import com.zyh.lanqiao.utils.Utils;

public class 问题11_数组能组成的最小数 {

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{3,32,321};
		int res = solution(arr);
		Utils.print(res);
	}

	private static Integer solution(Integer[] arr) {
		Arrays.sort(arr,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1+""+o2;
				String s2 = o2+""+o1;
				return s1.compareTo(s2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return Integer.parseInt(sb.toString());
	}

}
