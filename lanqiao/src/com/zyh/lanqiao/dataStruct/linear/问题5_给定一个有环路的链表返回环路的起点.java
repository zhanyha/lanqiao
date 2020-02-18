package com.zyh.lanqiao.dataStruct.linear;

import java.util.*;

/**
 * 前提：每个节点的data都不一样
 * 思路1：用hashSet去保存节点的value，如果下一次hashset.contain(value)
 * 返回true。那么环路的起点就找到了
 * @author zhanyuhao
 * 没有前提
 *思路2：快慢指针，快指针每次移动2步，慢指针每次移动1步，如果有环的话，
 *快指针一定会和慢指针相遇
 */

public class 问题5_给定一个有环路的链表返回环路的起点 {

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
	 * 利用快慢指针
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
	 * 对数据有很高的要求，要求的是每一个节点的数据都不一样才可以这样做
	 * 比如 1-2-3-4-5-6-7-8
	 * 			   |     |
	 * 			   2-3-4-6	
	 * 对形如这样的环就无法判断
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
