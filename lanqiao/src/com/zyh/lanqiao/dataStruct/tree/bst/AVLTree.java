package com.zyh.lanqiao.dataStruct.tree.bst;
/**
 * AVLTree��һ�������BST,������ʲôʱ�򶼻ᱣ��ƽ��
 * ��α��ֵķ�������ÿ���ڲ������ɾ����ʱ�򶼱���ƽ��
 * @author zhanyuhao
 *
 * @param <K>
 * @param <V>
 */
public class AVLTree<K, V> extends MyBinSearchTree<K, V>{

	@Override
	public BSTNode<K, V> insert(K key, V value) {
		BSTNode<K, V> cur = super.insert(key, value);//�Ȳ��룬�����Ƿ�ƽ��
		//�ҵ���һ����ƽ��ĵ��pqs��p�����һ����ƽ��ĵ㵽������������µ������ڵ�
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
