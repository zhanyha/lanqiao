package com.zyh.lanqiao.dataStruct.tree.PTA;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 先排序，然后中序遍历生成树。在对树层次遍历
 * 因为考虑要层序遍历，所以可以查用数组的方式来构建搜索树。层序遍历的时候直接按顺序输出数组
* @author zhanyuhao
* @version 创建时间：2020年2月13日 上午12:10:04
* 类说明
 */
public class Q6_完全二叉搜索树 {
    static int[] tree = null;
    static  int n=0;
    static int cur=-1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr= new int[n];
        tree = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        build(arr,0);
        print(tree);
        sc.close();
    }

    private static void print(int[] tree) {
        for (int i = 0; i < tree.length; i++) {
            if(i!=tree.length)
                System.out.print(tree[i]+" ");
            else
                System.out.print(tree[i]);
        }
    }

    /**
     * 采用中序遍历的构建
     * @param arr
     * @param root
     */
    private static void build(int[] arr,int root) {
        if(root>=n) return;
        build(arr,root*2+1);
        tree[root] = arr[++cur];
        build(arr,root*2+2);
    }
}
