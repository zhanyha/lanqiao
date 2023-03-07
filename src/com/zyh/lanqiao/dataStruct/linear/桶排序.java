package com.zyh.lanqiao.dataStruct.linear;

import java.util.Scanner;
//10
//1 3 5 2 7 13 16 15 49 10
public class 桶排序 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		BucketSort(arr);
		sc.close();
	}

	public static void BucketSort(int[] arr) {
		//1.得到每个元素应该再几号桶里  e*len/(max+1)
		int len = arr.length;
		Node[] buckets = new Node[len];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		//2.入桶
		for (int i = 0; i < arr.length; i++) {
			int index = arr[i]*len/(max+1);
			if(buckets[index] == null) {//如果该桶中还没有元素
				buckets[index] = new Node(arr[i]);
			}else {//该桶有多个元素，应该按序插入
				insertTo(buckets[index],arr[i]);//把头指针和要插入的元素传入参数
			}
			
		}
		//3.出桶
		for (int i = 0; i < buckets.length; i++) {
			if(buckets[i] != null) {
				Node p = buckets[i];
				while(p.next!=null) {
					System.out.print(p.data+" ");
					p = p.next;
				}
				System.out.print(p.data+" ");
			}
		}
	}

	private static void insertTo(Node first, int e) {
		Node p = first.next;
		Node pre = first;
		Node newNode = new Node(e);
		while(p!=null) {
			if(p.data > e) {//找到第一个大于e的元素的位置
				pre.next = newNode;
				newNode.next = p;
				return ;
			}
			pre=p;
			p=p.next;
		}
		//如果一直到最后一个元素也没有大于当前元素
		if(p == null) {
			if(pre.data > e) {
				int tmp = newNode.data;
				newNode.data = pre.data;
				pre.data = tmp;
				pre.next = newNode;
				newNode.next = p;
			}else {
				pre.next = newNode;
			}
		}
	}

}
