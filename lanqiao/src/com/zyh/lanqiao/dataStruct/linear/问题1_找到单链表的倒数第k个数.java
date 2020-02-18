package com.zyh.lanqiao.dataStruct.linear;


public class 问题1_找到单链表的倒数第k个数 {

	public static void main(String[] args) {
		SingleLinkList sList = new SingleLinkList();
		sList.add(1);
		sList.add(2);
		sList.add(3);
		sList.add(4);
		sList.add(5);
		sList.add(6);
		sList.add(7);
		sList.add(8);
		int k = 2;
		System.out.println(findLK(sList,k));
	}

	private static int findLK(SingleLinkList sList,int k) {	
		Node fast,slow;
		fast = sList.getFirst();
		Node first = sList.getFirst();
		while(fast.next!=null && k-->0) {
			fast = fast.next;
		}
		slow = first;
		while(fast.next!=null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.data;
	}

}
