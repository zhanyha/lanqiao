package com.zyh.lanqiao.dataStruct.stack;

import java.util.Stack;

/**
 * 对栈的元素进行排序，每次只能访问栈顶元素，最多开辟一个辅助栈空间。
 * 使得栈的元素从大到小排序（从栈顶元素往下）
 * @author zhanyuhao
 * 思路：先揭锅盖（把栈顶元素取出），和另一个栈的所有元素进行比较，比它大的
 * 就压回到栈中，直到碰到一个元素比它小就压入到辅助栈中。
 */
public class 问题4_对栈的元素进行排序 {

	public static void main(String[] args) {
		Stack<Integer> src = new Stack<Integer>();
		src.add(1);
		src.add(4);
		src.add(2);
		src.add(5);
		src.add(3);
		Stack<Integer> res = stkSort(src);
		while(!res.isEmpty()) {
			System.out.println(res.pop());
		}
	}

	private static Stack<Integer> stkSort(Stack<Integer> src) {
		Stack<Integer> help = new Stack<Integer>();
		Integer tmp;
		while(!src.isEmpty()) {
			tmp = src.pop();//揭锅盖
			if(help.isEmpty()) {//辅助栈为空的话，直接压栈
				help.push(tmp);
			}else {//help一直出栈到src中，直到找到一个值小于了‘锅盖’
				while(!help.isEmpty() &&help.peek() > tmp) {
					src.push(help.pop());
				}
				help.push(tmp);
			}
		}
		return help;
	}

}
