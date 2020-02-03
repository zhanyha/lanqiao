package com.zyh.lanqiao.dataStruct.stack;

import java.util.Stack;

/**
 * ��ջ��Ԫ�ؽ�������ÿ��ֻ�ܷ���ջ��Ԫ�أ���࿪��һ������ջ�ռ䡣
 * ʹ��ջ��Ԫ�شӴ�С���򣨴�ջ��Ԫ�����£�
 * @author zhanyuhao
 * ˼·���Ƚҹ��ǣ���ջ��Ԫ��ȡ����������һ��ջ������Ԫ�ؽ��бȽϣ��������
 * ��ѹ�ص�ջ�У�ֱ������һ��Ԫ�ر���С��ѹ�뵽����ջ�С�
 */
public class ����4_��ջ��Ԫ�ؽ������� {

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
			tmp = src.pop();//�ҹ���
			if(help.isEmpty()) {//����ջΪ�յĻ���ֱ��ѹջ
				help.push(tmp);
			}else {//helpһֱ��ջ��src�У�ֱ���ҵ�һ��ֵС���ˡ����ǡ�
				while(!help.isEmpty() &&help.peek() > tmp) {
					src.push(help.pop());
				}
				help.push(tmp);
			}
		}
		return help;
	}

}
