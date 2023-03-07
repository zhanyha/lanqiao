package com.zyh.lanqiao.dataStruct.tree.PTA;

import java.util.Scanner;

/**
*https://pintia.cn/problem-sets/988034414048743424/problems/988041149056557056
* @author zhanyuhao
* @version 创建时间：2020年2月13日 上午1:02:30
* 类说明
 */
//6
//8 27 5 1
//9 40 -1 -1
//10 20 0 3
//12 21 -1 4
//15 22 -1 -1
//5 35 -1 -1
public class Q7_笛卡尔树 {
	private static class Node{
		int k1;
		int k2;
		int num;
		Node left;
		Node right;
	}
	static Node[] nodes = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] flag = new int[n];
        nodes = new Node[n];
        int r,l;
        for (int i = 0; i < n; i++) {
        	nodes[i] = new Node();
			nodes[i].num = i;
			nodes[i].k1 = sc.nextInt();
			nodes[i].k2 = sc.nextInt();
			l = sc.nextInt();
			r = sc.nextInt();
			if(l!=-1) {
				nodes[i].left = new Node();
				nodes[i].left.num = l;
				flag[l]=-1;
			}
			if(r!=-1) {
				nodes[i].right = new Node();
				nodes[i].right.num = r;
				flag[r]=-1;
			}
		}
        for (int i = 0; i < nodes.length; i++) {
        	if(nodes[i].left!=null) {
        		nodes[i].left = nodes[nodes[i].left.num];
        	}
        	if(nodes[i].right!=null) {
        		nodes[i].right = nodes[nodes[i].right.num];
        	}
		}
        //root
        int rootIndex = -1;
        for (int i = 0; i < flag.length; i++) {
			if(flag[i]==0) {
				rootIndex = i;
				break;
			}
		}
        Node root = nodes[rootIndex];
//        System.out.println(isBST(root));
        System.out.println(isMinHeap(root));
//        if(isBST(root)&&isMinHeap(root)) {
//        	System.out.println("YES");
//        }else {
//        	System.out.println("NO");
//        }
        sc.close();
    }
    /**
     * 用一个值取记录中序的遍历的最后一个值也就是最大值，然后，与下一个值进行比较
     * @param root
     * @return
     */
    static int preValue=-999;
    private static boolean isBST(Node root) {
    	if(root==null) return true;
    	boolean leftIsBST = isBST(root.left);
    	if(!leftIsBST)
    		return false;
    	if(preValue > root.k1)
    		return false;
    	preValue = root.k1;
    	return isBST(root.right);
    }
    /**
     * 
     * @param root
     * @return
     */
    private static boolean isMinHeap(Node root) {
    	if(root==null) return true;
    	if(root.right==null&&root.left==null) return true;
    	if(root.right==null&&root.left!=null) {
    		if(root.left.k2<root.k2) return false;
    	}
    	if(root.right!=null&&root.left==null) {
    		if(root.right.k2<root.k2) return false;
    	}
    	if(root.k2 <= root.left.k2 && root.k2 <= root.right.k2) {
    		return isMinHeap(root.left)||
    				isMinHeap(root.right);
    	}else {
    		return false;
    	}
    }
}
