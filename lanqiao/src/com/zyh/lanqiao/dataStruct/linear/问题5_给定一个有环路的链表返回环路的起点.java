package com.zyh.lanqiao.dataStruct.linear;

import java.util.*;

/**
 * ǰ�᣺ÿ���ڵ��data����һ��
 * ˼·1����hashSetȥ����ڵ��value�������һ��hashset.contain(value)
 * ����true����ô��·�������ҵ���
 * @author zhanyuhao
 * û��ǰ��
 *˼·2������ָ�룬��ָ��ÿ���ƶ�2������ָ��ÿ���ƶ�1��������л��Ļ���
 *��ָ��һ�������ָ������
 */

public class ����5_����һ���л�·�������ػ�·����� {

	public static void main(String[] args) {
		SingleLinkList list = new SingleLinkList();
		list.add(1);list.add(2);list.add(3);list.add(4);
		Node p = list.getFirst();
		list.add(5);
		p = p.next.next.next.next;
		list.add(6);list.add(7);list.add(8);
		list.add(6);
		list.add(4);
		list.add(3);
		list.add(2);
		Node last = list.getLast();
		last.next = p;
		Node first = list.getFirst();
//		int start = solution1(first);
//		System.out.println(start);
		int start2 = solution2(first);
		System.out.println(start2);
	}
	/**
	 * ���ÿ���ָ��
	 * @param first
	 * @return
	 */
	private static int solution2(Node first) {
		Node fast,slow;
		Node cnt = first;
		fast = first.next.next;slow = first.next;
		while(fast != slow) {
			fast = fast.next.next;
			slow = slow.next;
		}
		while(slow != cnt) {
			slow = slow.next;
			cnt = cnt.next;
		}
		return slow.data;
	}

	/**
	 * �������кܸߵ�Ҫ��Ҫ�����ÿһ���ڵ�����ݶ���һ���ſ���������
	 * ���� 1-2-3-4-5-6-7-8
	 * 			   |     |
	 * 			   2-3-4-6	
	 * �����������Ļ����޷��ж�
	 * @param first
	 * @return
	 */
	private static int solution1(Node first) {
		Node p  = first;
		HashSet<Integer> set = new HashSet<Integer>();
		while(p.next!=null) {
			if(set.contains(p.data)) {
				return p.data;
			}else {
				set.add(p.data);
				p = p.next;
			}
		}
		return 0;
	}

}
