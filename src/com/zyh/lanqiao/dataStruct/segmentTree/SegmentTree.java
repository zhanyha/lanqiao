package com.zyh.lanqiao.dataStruct.segmentTree;

/**
 * �߶�������������
 * 
 * @author zhanyuhao
 * @version ����ʱ�䣺2020��3��3�� ����7:55:54 ��˵��
 */
public class SegmentTree<E> {
	private E[] data;
	private E[] tree;
	private Merger<E> merger;

	public SegmentTree(E[] arr, Merger<E> merger) {
		this.merger = merger;
		data = (E[]) new Object[arr.length];
		tree = (E[]) new Object[4 * arr.length];
		for (int i = 0; i < arr.length; i++)
			data[i] = arr[i];
		buildTree(0, 0, data.length - 1);
	}

	private void buildTree(int treeIndex, int l, int r) {
		if (l == r) {
			tree[treeIndex] = data[l];
			return;
		}
		int mid = l + (r - l) / 2;
		int leftIndex = leftChild(treeIndex);
		int rightIndex = rightChild(treeIndex);

		buildTree(leftIndex, l, mid);
		buildTree(rightIndex, mid + 1, r);

		tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
	}

	public E query(int queryL, int queryR) {
		if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length) {
			throw new IllegalArgumentException("not exist");
		}
		return queryHelp(0, 0, data.length - 1, queryL, queryR);
	}

	private E queryHelp(int treeIndex, int l, int r, int queryL, int queryR) {
		if (queryL == l && queryR == r) {
			return tree[treeIndex];
		}
		int mid = l + (r - l) / 2;
		int leftIndex = leftChild(treeIndex);
		int rightIndex = rightChild(treeIndex);
		if (queryR <= mid) {// �����������
			return queryHelp(leftIndex, l, mid, queryL, queryR);
		} else if (queryL > mid) {
			return queryHelp(rightIndex, mid + 1, r, queryL, queryR);
		}
		// ����ֲ�������
		E leftResult = queryHelp(leftIndex, l, mid, queryL, mid);
		E rightResult = queryHelp(rightIndex, mid + 1, r, mid + 1, queryR);
		return merger.merge(leftResult, rightResult);
	}

	public void set(int index, E val) {
		if (index < 0 || index >= data.length) {
			new IllegalArgumentException("error");
		}
		set(0, 0, data.length-1, index, val);
	}

	private void set(int treeIndex, int l, int r, int index, E val) {
		if (r == l) {
			tree[treeIndex] = val;
			return;
		}
		int mid = l + (r - l) / 2;
		int leftIndex = leftChild(treeIndex);
		int rightIndex = rightChild(treeIndex);
		if(index <= mid) {
			set(leftIndex,l,mid,index,val);
		}else 
			set(rightIndex,mid+1,r,index,val);
		//��Ϊ�ı���Ҷ�ӽڵ�����ݣ�����һ��Ҫ�����丸�ڵ�����ݣ�����һ��������Ч��
		tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
	}

	private int leftChild(int index) {
		return 2 * index + 1;
	}

	private int rightChild(int index) {
		return 2 * index + 2;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null)
				sb.append(tree[i] + " ");
			else {
				sb.append("null ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}