package com.zyh.lanqiao.dataStruct.segmentTree;

/**
 * 线段树（区间树）
 * 
 * @author zhanyuhao
 * @version 创建时间：2020年3月3日 下午7:55:54 类说明
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
		if (queryR <= mid) {// 结果在左子树
			return queryHelp(leftIndex, l, mid, queryL, queryR);
		} else if (queryL > mid) {
			return queryHelp(rightIndex, mid + 1, r, queryL, queryR);
		}
		// 结果分布在两边
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
		//因为改变了叶子节点的内容，所以一定要更新其父节点的内容，这是一个联动的效果
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