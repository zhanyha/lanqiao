package com.zyh.lanqiao.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 前缀法: 每次从头扫描集合（保证集合有序），
 * 如果扫到某个元素不在结果集里面就把该 元素加入到结果集，
 * 当结果集的长度和原集合的长度一样的话，说明有了一个结果
 * 
 * @author zhanyuhao
 *
 */
public class 问题7_集合的全排列III_前缀法 {

	public static void main(String[] args) {
		String[] arr = new String[] { "A", "B", "C" };
		int n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			List<String> suff = new ArrayList<String>();
			suff.add(arr[i]);
			recursion(arr, suff, n);
		}
	}

	private static void recursion(String[] arr, List<String> suff, int n) {
		if (suff.size() == n) {
			for (int i = 0; i < suff.size(); i++) {
				System.out.print(suff.get(i));
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {// 扫描每个元素
			if (check(arr, suff, i)) {
				suff.add(arr[i]);// 加入到结果集里面
				recursion(arr, suff, n);// 继续递归下去
				suff.remove(arr[i]);//回溯
			}
		}
	}

	private static boolean check(String[] arr, List<String> suff, int cur) {
		for (int i = 0; i < suff.size(); i++) {
			if(suff.get(i).equals(arr[cur])) {
				return false;
			}
		}
		return true;
	}

}
