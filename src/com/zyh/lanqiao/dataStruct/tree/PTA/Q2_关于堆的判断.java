package com.zyh.lanqiao.dataStruct.tree.PTA;

import java.util.Scanner;
/**
 * https://pintia.cn/problem-sets/988034414048743424/problems/988040315455172608
* @author zhanyuhao
* @version 创建时间：2020年2月11日 下午8:13:57
* 类说明
 */
public class Q2_关于堆的判断 {

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
		//1.找到左右孩子下标，（考虑越界）
		int left = i*2+1;
		int right = i*2+2;
		//2.找到左右孩子较小的那个
		if(left>=n) {//说明左孩子都已经越界了，右孩子一定也越界
			return ;
		}
		int min = left;//记录最小值的小标
		if(right>=n) {//说明右孩子越界，但左孩子没有越界
			min = left;
		}else {
			//说明左右孩子都未越界。
			if(arr[right] < arr[left]) {
				min = right;
			}
		}	//能运行到这里min一定指向左右孩子最小值的下标
		//3.与根节点比较，如果大的话就return。否则，交换
		if(arr[min] > arr[i]) {
			return;
		}
		swap(arr,min,i);
		//4.递归.继续向下调整
		minHeapFixDown(arr,min,n);
	}

	private static void swap(int[] arr, int min, int i) {
		int tmp = arr[min];
		arr[min] = arr[i];
		arr[i] = tmp;
	}

}
