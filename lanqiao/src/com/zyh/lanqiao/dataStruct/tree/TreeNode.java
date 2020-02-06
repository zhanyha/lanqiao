package com.zyh.lanqiao.dataStruct.tree;

import java.util.List;

public class TreeNode<E> {
	public E key;
	public TreeNode<E> parent;
	public List<TreeNode<E>> children;
	
	public TreeNode(E key, TreeNode<E> parent) {
		this.key = key;
		this.parent = parent;
	}
	public TreeNode() {
	}
	public TreeNode(E key){
		this.key = key;
	}

	@Override
	public String toString() {
		return "TreeNode [key=" + key + "]";
	}
}
