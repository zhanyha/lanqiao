package com.zyh.lanqiao.dataStruct.tree.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description ��������7_�������Ĳ����������
 * @Author zhanyuhao
 * @Date 2020/7/3 21:20
 **/
public class ��������7_�������Ĳ������ {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if(root==null) return res;
            Queue<TreeNode> que = new LinkedList<TreeNode>();
            que.add(root);
            TreeNode last = root;
            TreeNode nextLine = null;
            List<Integer> line = new ArrayList<Integer>();
            while(!que.isEmpty()){
                TreeNode run = que.poll();
                line.add(run.val);
                if(run.left!=null){
                    que.add(run.left);
                    nextLine = run.left;
                }
                if(run.right!=null){
                    que.add(run.right);
                    nextLine = run.right;
                }
                if(run == last){
                    res.add(line);
                    line = new ArrayList<Integer>();
                    last=  nextLine;
                }
            }
            return res;
        }

}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
}
