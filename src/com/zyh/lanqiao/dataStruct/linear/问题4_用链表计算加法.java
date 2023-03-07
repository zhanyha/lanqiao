package com.zyh.lanqiao.dataStruct.linear;
/**
 * {1,2,3}+{2,3,4} = {3,5,7}
 * {2,4,1,7,6}+{7,7,3,8,7} = {9,1,5,5,4,1}
 * @author zhanyuhao
 *
 */
public class 问题4_用链表计算加法 {

	public static void main(String[] args) {
		SingleLinkList l1 = new SingleLinkList();
		SingleLinkList l2 = new SingleLinkList();
		l1.add(2);l1.add(4);l1.add(1);l1.add(7);l1.add(6);
		l2.add(7);l2.add(7);l2.add(3);l2.add(8);l2.add(7);
		Node head = solution(l1.getFirst(),l2.getFirst(),0);
		while(head.next !=null) {
			System.out.println(head.data);
			head = head.next;
		}
		System.out.println(head.data);
	}

	private static Node solution(Node first, Node first2, int i) {
		if(first==null || first2 == null) {
			if(i>0) {
				return new Node(i);
			}
			else 
				return null;
		}
		int value = i;
		int jin = 0;
		value = (value+first.data+first2.data);
		jin = value / 10;
		value = value % 10;
		Node n = new Node(value);
		n.next = solution(first.next,first2.next,jin); 
		return n;
	}
}
