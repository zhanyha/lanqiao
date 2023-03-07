package com.zyh.lanqiao.dataStruct.tree.PTA;

import java.util.Scanner;
/**
 * https://pintia.cn/problem-sets/988034414048743424/problems/988040315455172608
* @author zhanyuhao
* @version ����ʱ�䣺2020��2��11�� ����8:13:57
* ��˵��
 */
public class Q2_���ڶѵ��ж� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}sc.nextLine();
		minHeap(arr);
		for (int i = 0; i < m; i++) {
			String[] line = sc.nextLine().split(" ");
			if(judge(line,arr)) {
				System.out.println("T");
			}else {
				System.out.println("F");
			}
		}
//9 4
//-1 -10 0 8 9 -7 1 5 6
//-10 is the root
//1 and 0 are siblings
//-1 is the parent of 5
//-1 is a child of 9
		sc.close();
	}

	private static boolean judge(String[] line, int[] arr) {
		boolean flag = false;
		int a,b;
		for (int i = 0; i < line.length; i++) {
			switch (line[i]) {
			case "root":
				a = Integer.parseInt(line[0]);
				flag = a==arr[0]?true:false;
				break;
			case "siblings":
				a = Integer.parseInt(line[0]);
				b = Integer.parseInt(line[2]);
				flag = Math.abs(getIndex(a,arr) - getIndex(b,arr))==1?true:false;
				break;
			case "parent":
				a = Integer.parseInt(line[0]);
				b = Integer.parseInt(line[5]);
				int r = getIndex(a,arr);
				int l = getIndex(b,arr);
				if(2*r+1==l||2*r+2==l) {
					flag = true;
				}else {
					flag = false;
				}
				break;
			case "child":
				a = Integer.parseInt(line[0]);
				b = Integer.parseInt(line[5]);
				int rr = getIndex(b,arr);
				int ll = getIndex(a,arr);
				if(2*rr+1==ll||2*rr+2==ll) {
					flag = true;
				}else {
					flag = false;
				}
				break;
			default:
				break;
			}
		}
		return flag;
	}

	private static int getIndex(int a, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==a) {
				return i;
			}
		}
		return -1;
	}

	private static void minHeap(int[] arr) {
		int n = arr.length/2 - 1;
		for(int i=n;i>=0;i--) {
			minHeapFixDown(arr,i,arr.length);
		}
	}
	private static void minHeapFixDown(int[] arr, int i, int n) {
		//1.�ҵ����Һ����±꣬������Խ�磩
		int left = i*2+1;
		int right = i*2+2;
		//2.�ҵ����Һ��ӽ�С���Ǹ�
		if(left>=n) {//˵�����Ӷ��Ѿ�Խ���ˣ��Һ���һ��ҲԽ��
			return ;
		}
		int min = left;//��¼��Сֵ��С��
		if(right>=n) {//˵���Һ���Խ�磬������û��Խ��
			min = left;
		}else {
			//˵�����Һ��Ӷ�δԽ�硣
			if(arr[right] < arr[left]) {
				min = right;
			}
		}	//�����е�����minһ��ָ�����Һ�����Сֵ���±�
		//3.����ڵ�Ƚϣ������Ļ���return�����򣬽���
		if(arr[min] > arr[i]) {
			return;
		}
		swap(arr,min,i);
		//4.�ݹ�.�������µ���
		minHeapFixDown(arr,min,n);
	}

	private static void swap(int[] arr, int min, int i) {
		int tmp = arr[min];
		arr[min] = arr[i];
		arr[i] = tmp;
	}

}
