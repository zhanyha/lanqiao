package com.zyh.lanqiao.dataStruct.stack;

import java.util.ArrayList;

/**
 * ����2_���ջ������size�����½�һ��ջ���������н�ջ�ͳ�ջ�����κ�����
 * @author zhanyuhao
 *����Stack<Stack<T>>�ṹ
 */
public class ����2_���ջ�ܸߵ����� {
	
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
