package test.bst;

import java.util.List;

import com.zyh.lanqiao.dataStruct.tree.bst.BSTNode;
import com.zyh.lanqiao.dataStruct.tree.bst.MyBinSearchTree;

public class myBSTest {
	public static void main(String[] args) {
		MyBinSearchTree<Integer, String> stree = new MyBinSearchTree<Integer, String>();
		stree.insert(23, "a");
		stree.insert(21, "a");
		stree.insert(18, "a");
		stree.insert(5, "afg");
		stree.insert(31, "a");
		stree.insert(20, "a");
		stree.insert(7, "a");
		stree.insert(24, "a");
		stree.inorder(k ->{
			System.out.print(k+" ");
		});
		System.out.println();
		System.out.println(stree.lookupValue(5));
		System.out.println(stree.min());
		System.out.println(stree.max());
		System.out.println("----------------------");
//		stree.remove(21);
//		stree.remove(24);
		stree.inorder(k ->{
			System.out.print(k+" ");
		});
		System.out.println();
		System.out.println("h == "+stree.getHeight());
		System.out.println("=============levelOrder START================");
		List<List<BSTNode<Integer, String>>> res = stree.levelOrder();
		for (List<BSTNode<Integer, String>> list : res) {
			for (BSTNode<Integer, String> e : list) {
				System.out.print(e.toString()+" ");
			}
			System.out.println();
		}
		System.out.println("=============levelOrder END================");
		System.out.println("=============successor start================");
//		stree.remove(31);
//		stree.remove(24);
		System.out.println(stree.successor(31));		
		System.out.println("=============successor END================");
		System.out.println("=============precessor start================");
		System.out.println(stree.precessor(5));
		System.out.println("=============precessor END================");
		System.out.println("=============size START================");
		stree.inorder(k ->{
			System.out.print(k+" ");
		});
		System.out.println();
		System.out.println(stree.getSize());
		System.out.println("=============size END================");
		System.out.println("=============isBanance END================");
		System.out.println(stree.isBanance());
		System.out.println("=============isBanance END================");
	}
	
}
