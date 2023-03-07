package com.zyh.lanqiao.dataStruct.tree.bst;

import java.util.List;
import java.util.function.Consumer;

public interface IBinarySearchTree<K,V> {
	
	BSTNode<K, V> insert(K key, V value);
	void inorder(Consumer<K> key);
	/**
	 * 根据key在树中查询对应的值。
	 * @param key
	 * @return
	 */
	BSTNode<K, V> lookupValue(K key);
	
	K min();
	
	K max();
	
	void remove(K key);
	
	K successor(K x);
	
	K precessor(K x);
	
	boolean isBanance();
	
	int getSize();
	
	int getHeight();
	
	List<List<BSTNode<K,V>>> levelOrder();
}
