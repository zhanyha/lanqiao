package com.zyh.lanqiao.dataStruct.tree.PTA;

import java.util.Scanner;

public class Q6_完全二叉搜索树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();
    }
}
