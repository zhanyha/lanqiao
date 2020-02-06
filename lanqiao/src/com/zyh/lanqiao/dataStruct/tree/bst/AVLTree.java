package com.zyh.lanqiao.dataStruct.tree.bst;
/**
 * AVLTree是一种特殊的BST,它无论什么时候都会保持平衡
 * 如何保持的方法就是每次在插入或者删除的时候都保持平衡
 * @author zhanyuhao
 *
 * @param <K>
 * @param <V>
 */
public class AVLTree<K, V> extends MyBinSearchTree<K, V>{

	@Override
	public BSTNode<K, V> insert(K key, V value) {
		BSTNode<K, V> cur = super.insert(key, value);//先插入，不管是否平衡
		//找到第一个不平衡的点的pqs。p代表第一个不平衡的点到插入点依次往下的三个节点
		BSTNode<K, V>[] nodes = firstUnBalance(cur);
		
		return null;
	}

	private BSTNode<K, V>[] firstUnBalance(BSTNode<K, V> cur) {
		return null;
	}

	@Override
	public void remove(K key) {
		
	}
	
}
