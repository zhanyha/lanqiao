package com.zyh.lanqiao.dataStruct.tree.PTA;

import java.util.Arrays;
import java.util.Scanner;
/**
 * ������Ȼ������������������ڶ�����α���
 * ��Ϊ����Ҫ������������Կ��Բ�������ķ�ʽ�����������������������ʱ��ֱ�Ӱ�˳���������
* @author zhanyuhao
* @version ����ʱ�䣺2020��2��13�� ����12:10:04
* ��˵��
 */
public class Q6_��ȫ���������� {
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
     * ������������Ĺ���
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
