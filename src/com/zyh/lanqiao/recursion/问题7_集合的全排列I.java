package com.zyh.lanqiao.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用括号的插入方式，比如A 下一个字符是B，B可以插入到A的左边和右边 所以生成AB 和 BA 现插入C,C可以插入到 AB的左中右三个位置，依次类推
 * 
 * @author zhanyuhao
 *
 */
public class 问题7_集合的全排列I {
	static int[] arr;
	static int n;

	public static void main(String[] args) {
		arr = new int[] { 1, 2, 3 };
		n = arr.length;
//		recursion(arr[0]+"",1);
		List<String> list = iteration();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	/**
	 * 迭代的方式求解
	 * @return
	 */
	private static List<String> iteration() {
		List<String> oldList = new ArrayList<String>();
		oldList.add(arr[0] + "");
		for (int i = 1; i < n; i++) {// 对于每一个元素都要插入到最后的结果当中
			List<String> newList = new ArrayList<String>();
			for (int j = 0; j < oldList.size(); j++) {//对上一个集合(比如{AB,BA})中的每个元素来说
				for (int k = 0; k <= oldList.get(j).length(); k++) {//都要在每个字符的两边插入新的字符比如A 要插入B 可以是AB和BA
					newList.add(oldList.get(j).substring(0, k) + arr[i] + oldList.get(j).substring(k));
				}
			}
			oldList = newList;//跟新oldList用于下一次继续迭代
		}
		return oldList;//最后一轮迭代结果
	}

	/**
	 * 递归方式求解
	 * 
	 * @param before
	 * @param cur
	 */
	private static void recursion(String before, int cur) {
		if (cur == n) {
			System.out.println(before);
			return;
		}
		for (int i = 0; i <= before.length(); i++) {
			String newBefore = before.substring(0, i) + arr[cur] + before.substring(i);
			recursion(newBefore, cur + 1);
		}
	}

}
