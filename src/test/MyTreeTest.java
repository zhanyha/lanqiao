package test;

import java.util.List;

import com.zyh.lanqiao.dataStruct.tree.MyTree;
import com.zyh.lanqiao.dataStruct.tree.TreeNode;

public class MyTreeTest {
	public static void main(String[] args) {
		MyTree<String> tree = new MyTree<String>();
		TreeNode<String> a = new TreeNode<String>("a");
		TreeNode<String> b = new TreeNode<String>("b");
		TreeNode<String> c = new TreeNode<String>("c");
		TreeNode<String> d = new TreeNode<String>("d");
		TreeNode<String> e = new TreeNode<String>("e");
		TreeNode<String> g = new TreeNode<String>("g");
		TreeNode<String> f = new TreeNode<String>("f");
		TreeNode<String> h = new TreeNode<String>("h");
		TreeNode<String> i = new TreeNode<String>("i");
		tree.setRoot(a);
		tree.insertChild(a, b);
		tree.insertChild(a, c);
		tree.insertChild(a, d);
		tree.insertChild(b, e);
		tree.insertChild(c, g);
		tree.insertChild(g, h);
		tree.insertChild(h, i);
		tree.insertChild(d, f);
		int height = tree.getHeight(a);
		System.out.println(height);
		List<List<TreeNode<String>>> levelOrder = tree.levelOrder(a);
		for (List<TreeNode<String>> list : levelOrder) {
			for (TreeNode<String> e1 : list) {
				System.out.print(e1.key+"   ");
			}
			System.out.println();
			System.out.println("-----------------");
		}
	}
}
