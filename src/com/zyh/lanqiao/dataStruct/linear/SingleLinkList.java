package com.zyh.lanqiao.dataStruct.linear;

/**
 * 1-->2-->4-->3-->5
 * @author zhanyuhao
 *
 */
public class SingleLinkList {
	private Node first;
	private Node last;
	private int size = 0;
	public Node getFirst() {
		return first;
	}
	public void setFirst(Node first) {
		this.first = first;
	}
	public Node getLast() {
		return last;
	}
	public void setLast(Node last) {
		this.last = last;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public SingleLinkList(){
		
	}
	public void add(int data) {
		if(first == null) {
			first = new Node(data);
			last = first;
		}else {
			Node newNode = new Node(data);
			last.next = newNode;
			last = newNode;
		}
		size++;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node p = new Node();
		p = first;
		while(p.next !=null) {
			sb.append(p.data);
			p = p.next;
		}
		sb.append(p.data);
		return sb.toString();
	}
}
