package com.zyh.lanqiao.dataStruct.tree.bst;

public class BSTNode<K, V> {
	 K key;
	 V value;
	 BSTNode<K, V> left;
	 BSTNode<K, V> right;
	 BSTNode<K, V> parent;
	 Boolean isLeftChild;
	 Boolean isRightChild;
	 int height;
	/**
	 * ±àºÅ
	 */
	public int num;

	public BSTNode() {
	}
	public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right, BSTNode<K, V> parent) {
		super();
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	public Boolean isLeft() {
		return isLeftChild;
	}
	public Boolean isRight() {
		return isRightChild;
	}

	@Override
	public String toString() {
		return ""+key;
	}

}
