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
			cur = new BSTNode<K, V>(key, value, null, null, null);// ����ڵ�
			cur.parent = parent;
			// �ж���parent�����ӻ����Һ���
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
			new Exception("��Ϊ��");
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
			new Exception("��Ϊ�գ�����ֵ");
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
			new Exception("��Ϊ�գ�����ֵ");
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
		// �����Ҷ�ӽڵ㣬ֱ��ɾ��
		if (p.left == null && p.right == null) {
			if (p.parent != null) {
				if (p.isLeft()) {
					p.parent.left = null;
				} else {
					p.parent.right = null;
				}
				p.parent = null;
			} else {//˵��ֻ��һ�����ڵ�
				root = null;
			}
			p = null;
		} else if (p.right == null) { // ���󵥷�֧
			if(p.key == root.key) {//ɾ�Ļ��Ǹ��ڵ�
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
		} else if (p.left == null) { // ���ҵ���֧
			if(p.key == root.key) {//ɾ�Ļ��Ǹ��ڵ�
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
			// �ýڵ���˫��֧��ֱ�����������ҵ���Сֵ�滻�ýڵ�
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
	public K successor(K x) {//���
		BSTNode<K,V> node = this.lookupValue(x);
		if(node == null) return null;
		if(node.key == this.root.key && root.right == null) {
			return null;//�ų����ڵ�Ϊ�յ����
		}			
		//�������������
		if(node.right != null) {
			//�򷵻�����������Сֵ
			return this.BSTmin(node.right).key;
		}
		//��ִ�е�����˵��û��������
		BSTNode<K, V> p = node;
		while(p!=null && !p.isLeft()) {//û���ҵ���һ�������ӵĽڵ�
			p = p.parent;
		}
		if(p == null) {
			return null;
		}
		//ִ�е�����˵���ҵ��˵�һ�������ӵĽڵ� ���ؽڵ��parent
		return p.parent.key;
	}

	@Override
	public K precessor(K x) {//ǰ��
		BSTNode<K,V> node = this.lookupValue(x);
		if(node == null) return null;
		if(node.key == this.root.key && root.left == null)
			return null;//�ų����ڵ�Ϊ�յ����
		//�������������
		if(node.left != null) {
			//�򷵻������������ֵ
			return this.BSTmax(node.left).key;
		}
		//��ִ�е�����˵��û��������
		BSTNode<K, V> p = node;
		while(p!=null && !p.isRight()) {//û���ҵ���һ�������ӵĽڵ�
			p = p.parent;
		}
		if(p==null) return null;
		//ִ�е�����˵���ҵ��˵�һ�������ӵĽڵ� ���ؽڵ��parent
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
			p = p.parent;//����
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
		BSTNode<K, V> last=null,run=null,nextLine = null;//�ڱ����α������б�ʶ
		Queue<BSTNode<K, V>> q = new LinkedList<BSTNode<K, V>>();//���У����ڴ������
		List<BSTNode<K, V>> eline = new ArrayList<BSTNode<K,V>>();
		//��ʼ������
		last = this.root;//ָ��ĳһ������һ��Ԫ��
		q.add(root);
		while(!q.isEmpty()) {
			run = q.poll();//������
			eline.add(run);
			if(run.left!=null) {//���Ӿ�Ҫ��
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
				last = nextLine;//ÿһ�ε�run=last��ʱ��nextLine���պ�ָ������һ������һ��Ԫ��
			}
			
		}
		return res;
	}

}
