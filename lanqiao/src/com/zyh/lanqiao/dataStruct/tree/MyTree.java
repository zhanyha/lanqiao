package com.zyh.lanqiao.dataStruct.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyTree<E> implements ITree<E> {
	private TreeNode<E> root;
	private int size = 0;
	public void setRoot(TreeNode<E> root) {
		this.root = root;
	}
	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public TreeNode<E> getRoot() {
		return this.root;
	}

	@Override
	public TreeNode<E> getParent(TreeNode<E> x) {
		return x.parent;
	}

	@Override
	public TreeNode<E> getFristChild(TreeNode<E> x) {
		return x.children.get(0);
	}

	@Override
	public TreeNode<E> getNextSibling(TreeNode<E> x) {
		List<TreeNode<E>> children = x.parent.children;
		int i = children.indexOf(x);
		if(i == children.size()-1) {
			return null;
		}
		return children.get(i+1);
	}

	@Override
	public int getHeight(TreeNode<E> x) {
		if(x.children==null) 
			return 0;
		int[] heights = new int[x.children.size()];
		
		for (int i = 0; i < x.children.size(); i++) {
			heights[i] = 1 + getHeight(x.children.get(i));
		}
		int max=-1;
		for (int i = 0; i < heights.length; i++) {
			if(max < heights[i]) max = heights[i];
		}
		return max;
	}

	@Override
	public void insertChild(TreeNode<E> x, TreeNode<E> child) {
		if(x.children == null) {
			x.children = new ArrayList<TreeNode<E>>();
		}
		x.children.add(child); 
		child.parent = x;
		size++;
	}

	@Override
	public void deleteChild(TreeNode<E> x, int i) {
		if(x==null) {
			new Exception("传入的参数为空指针");
			return;
		}
		if(x.children ==null) {
			return;
		}
		x.children.remove(i);
		size--;
	}

	@Override
	public List<List<TreeNode<E>>> levelOrder(TreeNode<E> x) {
		/*方法一：
		 * if(x==null) return null;
		Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
		List<TreeNode<E>> res = new LinkedList<TreeNode<E>>();
		if(x.children==null) {
			res.add(x);
			return res;
		}
		q.add(x);//先加入到队列中
		while(!q.isEmpty()) {
			TreeNode<E> out = q.poll();
			res.add(out);
			List<TreeNode<E>> children = out.children;
			if(children!=null) {
				q.addAll(children);
			}
		}
		return res;*/
		/**
		 * 方法二：在每一行结束后都能打印一个换行。
		 */
		//初始化
		List<List<TreeNode<E>>> res = new ArrayList<List<TreeNode<E>>>();
		TreeNode<E> last = x;//哨兵
		TreeNode<E> run = x;//游标
		TreeNode<E> nextLine = null;
		Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
		q.add(x);
		List<TreeNode<E>> row  = new ArrayList<TreeNode<E>>();
		while(!q.isEmpty()) {
			run = q.poll();
			row.add(run);
			List<TreeNode<E>> children= run.children;
			if(children!=null) {
				q.addAll(children);
				nextLine = run.children.get(children.size()-1); 
			}
			if(run == last) {//换行
				res.add(row);
				row = new ArrayList<TreeNode<E>>();
				last = nextLine;
			}
		}
		return res;
	}
	
	@Override
	public List<TreeNode<E>> preOrder(TreeNode<E> x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TreeNode<E>> postOrder(TreeNode<E> x) {
		// TODO Auto-generated method stub
		return null;
	}



}
