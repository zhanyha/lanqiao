package com.zyh.lanqiao.dataStruct.stack;

import java.util.ArrayList;

/**
 * 问题2_如果栈超过了size个，新建一个栈，但是所有进栈和出栈不受任何限制
 * @author zhanyuhao
 *利用Stack<Stack<T>>结构
 */
public class 问题2_解决栈很高的问题 {
	
	public static void main(String[] args) {
//		ArrayList<ArrayList<Integer>> stk = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
