package com.zyh.lanqiao.dataStruct.tree;

import java.util.List;

public interface ITree<E> {
	int getSize();
	
	TreeNode<E> getRoot();
	
	TreeNode<E> getParent(TreeNode<E> x);
	
	TreeNode<E> getFristChild(TreeNode<E> x);
	
	TreeNode<E> getNextSibling(TreeNode<E> x);
	
	int getHeight(TreeNode<E> x);
	/**
	 * 
	 * @param x 父节点
	 * @param child 要插入的节点
	 */
	void insertChild(TreeNode<E> x,TreeNode<E> child);
	/**
	 * 
	 * @param x 父节点
	 * @param i 删除第几个孩子节点
	 */
	void deleteChild(TreeNode<E> x,int i);
	
	List<TreeNode<E>> preOrder(TreeNode<E> x);
	
	List<TreeNode<E>> postOrder(TreeNode<E> x);
	
	List<List<TreeNode<E>>> levelOrder(TreeNode<E> x);
	
}
