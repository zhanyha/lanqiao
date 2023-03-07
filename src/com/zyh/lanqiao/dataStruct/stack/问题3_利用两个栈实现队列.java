package com.zyh.lanqiao.dataStruct.stack;

import java.util.Stack;

public class ����3_��������ջʵ�ֶ��� {
	public static void main(String[] args) {
		DoubleStkToQueue stj = new DoubleStkToQueue();
		stj.enqueue(1);
		stj.enqueue(2);
		stj.enqueue(3);
		stj.enqueue(4);
		while(stj.size!=0) {
			System.out.println(stj.dequeue());
		}
	}
}
class DoubleStkToQueue{
	Stack<Integer> save = new Stack<Integer>();
	Stack<Integer> tmp = new Stack<Integer>();
	int size = 0;
	public void enqueue(int data){
		save.add(data);
		size++;
	}
	/**
	 * �����е�ʱ������Ż���
	 * @return
	 */
	public Integer dequeue() {
		while(!save.isEmpty()) {
			tmp.push(save.pop());
		}
		if(!tmp.isEmpty()) {
			size--;
			return tmp.pop();
		}
		else
			return null;
	}
	
}