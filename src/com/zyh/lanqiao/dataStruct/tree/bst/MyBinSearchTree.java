package com.zyh.lanqiao.dataStruct.tree.bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class MyBinSearchTree<K, V> implements IBinarySearchTree<K, V> {
	private BSTNode<K, V> root;
	private int size = 0;
	private Comparator<K> comparator;

	public MyBinSearchTree() {
	}

	public MyBinSearchTree(Comparator<K> comparator) {
		this.comparator = comparator;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private int compare(K key1, K key2) {
		if (null == comparator) {
			return ((Comparable) key1).compareTo((Comparable) key2);
		} else {
			return comparator.compare(key1, key2);
		}
	}

	@Override
	public BSTNode<K, V> insert(K key, V value) {
		if (!(key instanceof Comparable)) {
			throw new ClassCastException();
		}
		BSTNode<K, V> parent = null;//
		BSTNode<K, V> cur = root;//
		if (root == null) {
			root = new BSTNode<K, V>(key, value, null, null, null);
			root.isLeftChild = false;
			root.isRightChild = false;
			return root;
		} else {
			while (cur != null) {
				parent = cur;
				if (compare(key, cur.key) < 0) {
					cur = cur.left;
				} else if (compare(key, cur.key) > 0) {
					cur = cur.right;
				} else {
					cur.value = value;
					return cur;
				}
			}
			cur = new BSTNode<K, V>(key, value, null, null, null);// 插入节点
			cur.parent = parent;
			// 判断是parent的左孩子还是右孩子
			if (compare(key, parent.key) < 0) {
				parent.left = cur;
				cur.isLeftChild = true;
				cur.isRightChild = false;
			} else {
				parent.right = cur;
				cur.isLeftChild = false;
				cur.isRightChild = true;
			}
		}
		size++;
		return cur;
	}

	@Override
	public void inorder(Consumer<K> con) {
		if (root != null)
			inorder(root, con);
	}

	private void inorder(BSTNode<K, V> p, Consumer<K> con) {
		if (p == null) {
			return;
		}
		inorder(p.left, con);
		con.accept(p.key);
		inorder(p.right, con);
	}

	@Override
	public BSTNode<K, V> lookupValue(K key) {
		if (root == null) {
			new Exception("树为空");
		}
		BSTNode<K, V> p = root;
		while (p != null) {
			if (compare(key, p.key) == 0) {
				return p;
			} else if (compare(key, p.key) < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return null;
	}

	@Override
	public K min() {
		if (this.root != null)
			return BSTmin(this.root).key;
		else {
			new Exception("树为空，无最值");
			return null;
		}
	}

	private BSTNode<K, V> BSTmin(BSTNode<K, V> p) {
		if (p.left == null) {
			return p;
		}
		return BSTmin(p.left);
	}

	@Override
	public K max() {
		if (this.root != null)
			return BSTmax(this.root).key;
		else {
			new Exception("树为空，无最值");
			return null;
		}
	}

	private BSTNode<K, V> BSTmax(BSTNode<K, V> p) {
		if (p.right == null) {
			return p;
		}
		return BSTmax(p.right);
	}

	@Override
	public void remove(K key) {
		if (root == null)
			return;
		BSTNode<K, V> p = root;
		while (p != null) {
			if (compare(key, p.key) == 0) {
				break;
			} else if (compare(key, p.key) < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		// 如果是叶子节点，直接删除
		if (p.left == null && p.right == null) {
			if (p.parent != null) {
				if (p.isLeft()) {
					p.parent.left = null;
				} else {
					p.parent.right = null;
				}
				p.parent = null;
			} else {//说明只有一个根节点
				root = null;
			}
			p = null;
		} else if (p.right == null) { // 有左单分支
			if(p.key == root.key) {//删的还是根节点
				p.key = p.left.key;
				p = p.left;
			}
			if (p.isLeft()) {
				p.parent.left = p.left;
			} else {
				p.parent.right = p.left;
				p.left.isLeftChild = false;
			}
			p.left.parent = p.parent;
		} else if (p.left == null) { // 有右单分支
			if(p.key == root.key) {//删的还是根节点
				BSTNode<K, V> tmin = BSTmin(p.right);
				p.key = tmin.key;
				if (tmin.isLeftChild) {
					tmin.parent.left = null;
				} else {
					tmin.parent.right = null;
				}
				tmin.parent = null;
				tmin = null;
			}
			else if (p.isRight()) {
				p.parent.right = p.right;
			} else {
				p.parent.left = p.right;
				p.right.isLeftChild = true;
			}
			p.right.parent = p.parent;
		} else {
			// 该节点有双分支，直接在右子树找到最小值替换该节点
			BSTNode<K, V> tmin = BSTmin(p.right);
			p.key = tmin.key;
			if (tmin.isLeftChild) {
				tmin.parent.left = null;
			} else {
				tmin.parent.right = null;
			}
			tmin.parent = null;
			tmin = null;
		}
		size--;
	}

	@Override
	public K successor(K x) {//后继
		BSTNode<K,V> node = this.lookupValue(x);
		if(node == null) return null;
		if(node.key == this.root.key && root.right == null) {
			return null;//排除父节点为空的情况
		}			
		//如果有有右子树
		if(node.right != null) {
			//则返回右子树的最小值
			return this.BSTmin(node.right).key;
		}
		//能执行到这里说明没有右子树
		BSTNode<K, V> p = node;
		while(p!=null && !p.isLeft()) {//没有找到第一个是左孩子的节点
			p = p.parent;
		}
		if(p == null) {
			return null;
		}
		//执行到这里说明找到了第一个是左孩子的节点 返回节点的parent
		return p.parent.key;
	}

	@Override
	public K precessor(K x) {//前驱
		BSTNode<K,V> node = this.lookupValue(x);
		if(node == null) return null;
		if(node.key == this.root.key && root.left == null)
			return null;//排除父节点为空的情况
		//如果有有左子树
		if(node.left != null) {
			//则返回左子树的最大值
			return this.BSTmax(node.left).key;
		}
		//能执行到这里说明没有右子树
		BSTNode<K, V> p = node;
		while(p!=null && !p.isRight()) {//没有找到第一个是左孩子的节点
			p = p.parent;
		}
		if(p==null) return null;
		//执行到这里说明找到了第一个是左孩子的节点 返回节点的parent
		return p.parent.key;
	}

	@Override
	public boolean isBanance() {
		return !unBanance(this.root);
	}
	private boolean unBanance(BSTNode<K,V> x) {
		if(x == null) return false;
		int left = 0,right = 0;
		left = getHeightHelp(x.left);
		right = getHeightHelp(x.right);
		return Math.abs(left-right)>=2 ||
				unBanance(x.left)||
				unBanance(x.right);
	}
	@Override
	public int getSize() {
		return this.size+1;
	}

	@Override
	public int getHeight() {
		return getHeightHelp(this.root);
	}
	private int getHeightHelp(BSTNode<K, V> p) {
		if(p==null) return 0;
		if(p.left==null&&p.right==null) {
			return 1;
		}
		int lh = 0;
		if(p.left != null) {
			lh = 1+getHeightHelp(p.left);
		}
		if(p.left==null&&p.right==null) {
			p = p.parent;//回溯
		}
		int rh = 0;
		if(p.right != null) {
			rh = 1 + getHeightHelp(p.right);
		}
		return Math.max(lh, rh);
	}
	
	@Override
	public List<List<BSTNode<K, V>>> levelOrder() {
		if(root == null) return null;
		List<List<BSTNode<K, V>>> res = new ArrayList<List<BSTNode<K,V>>>();
		BSTNode<K, V> last=null,run=null,nextLine = null;//哨兵，游兵，换行标识
		Queue<BSTNode<K, V>> q = new LinkedList<BSTNode<K, V>>();//队列，用于存放数据
		List<BSTNode<K, V>> eline = new ArrayList<BSTNode<K,V>>();
		//初始化操作
		last = this.root;//指向某一层的最后一个元素
		q.add(root);
		while(!q.isEmpty()) {
			run = q.poll();//出队列
			eline.add(run);
			if(run.left!=null) {//出队就要加
				q.add(run.left);
				nextLine = run.left;
			}
			if(run.right!=null) {
				q.add(run.right);
				nextLine = run.right;
			}
			if(run == last) {
				res.add(eline);
				eline = new ArrayList<BSTNode<K,V>>();
				last = nextLine;//每一次当run=last的时候，nextLine都刚好指向了下一层的最后一个元素
			}
			
		}
		return res;
	}

}
