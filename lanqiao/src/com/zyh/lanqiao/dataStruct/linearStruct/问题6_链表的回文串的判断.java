package com.zyh.lanqiao.dataStruct.linearStruct;
/**
 * 一串字符串用链表结果存储，试判断是否为回文串
 * @author zhanyuhao
 *思路：快慢指针，前一半一直压栈，后一半出栈
 */
public class 问题6_链表的回文串的判断 {

	public static void main(String[] args) {
		SingleLinkList list = new SingleLinkList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(2);
		list.add(1);
		boolean res = solution(list);
		System.out.println(res);
	}

	private static boolean solution(SingleLinkList list) {
		
		return false;
	}

}
