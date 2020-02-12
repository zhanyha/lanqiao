package com.zyh.lanqiao.dataStruct.tree.PTA;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 先排序，然后中序遍历生成树。在对树层次遍历
* @author zhanyuhao
* @version 创建时间：2020年2月13日 上午12:10:04
* 类说明
 */
public class Q6_完全二叉搜索树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("idea");
        sc.close();
    }
}
