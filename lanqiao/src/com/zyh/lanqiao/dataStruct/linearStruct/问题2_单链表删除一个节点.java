package com.zyh.lanqiao.dataStruct.linearStruct;
/**
 * 因为无法访问删除节点的前一个节点，
 * 所以没有办法用一个pre取指向要删除节点的上一个节点.
 * 不考虑删除尾节点
 * @author zhanyuhao
 *
 */
public class 问题2_单链表删除一个节点 {

	public static void main(String[] args) {
		SingleLinkList sList = new SingleLinkList();
		sList.add(1);
		sList.add(4);
		sList.add(5);
		sList.add(7);
		sList.add(8);
		delete(sList,8);
		System.out.println(sList.toString());
	}

	private static void delete(SingleLinkList sList,int data) {
		Node p = sList.getFirst();
		while(p.next!=null) {
			if(p.data == data) {
				//1.用当前节点去复制下一个节点的内容
				p.data = p.next.data;
				//2.让要删除的节点的next直接指向下下个节点
				p.next = p.next.next;
				break;
			}
			p = p.next;
		}
		//不考虑删除最后一个节点的情况
		if(p.next == null) {
			if(p.data == data) {
				p.data =  -1; //false;
			}
		}
	}

}
