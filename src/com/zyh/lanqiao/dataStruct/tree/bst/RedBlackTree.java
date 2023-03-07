package com.zyh.lanqiao.dataStruct.tree.bst;
/**
 * 红黑树：实际上并不是一个平衡二叉树。
 * @author zhanyuhao
 *
 * @param <K>
 * @param <V>
 * 维护删除和插入操作
 */
public class RedBlackTree<K, V> extends MyBinSearchTree<K, V>{

	@Override
	public BSTNode<K, V> insert(K key, V value) {
		// TODO Auto-generated method stub
		return super.insert(key, value);
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		super.remove(key);
	}
	
}
