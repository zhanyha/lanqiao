package com.zyh.lanqiao.dataStruct.linearStruct;
/**
 * ��Ϊ�޷�����ɾ���ڵ��ǰһ���ڵ㣬
 * ����û�а취��һ��preȡָ��Ҫɾ���ڵ����һ���ڵ�.
 * ������ɾ��β�ڵ�
 * @author zhanyuhao
 *
 */
public class ����2_������ɾ��һ���ڵ� {

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
				//1.�õ�ǰ�ڵ�ȥ������һ���ڵ������
				p.data = p.next.data;
				//2.��Ҫɾ���Ľڵ��nextֱ��ָ�����¸��ڵ�
				p.next = p.next.next;
				break;
			}
			p = p.next;
		}
		//������ɾ�����һ���ڵ�����
		if(p.next == null) {
			if(p.data == data) {
				p.data =  -1; //false;
			}
		}
	}

}
