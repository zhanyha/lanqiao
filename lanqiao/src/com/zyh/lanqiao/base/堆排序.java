package com.zyh.lanqiao.base;

import com.zyh.lanqiao.utils.Utils;

public class 堆排序 {

	public static void main(String[] args) {
		//{15, 25, 11 ,48 ,1, 6, 49 ,46 }
		int[] array = Utils.randomArray(8);
		Utils.print(array);
		minHeapSort(array,0,array.length - 1);
		Utils.print(array);
	}
	private static void minHeapSort(int[] array,int start,int end) {
		minHeap(array);//数组堆化
		Utils.print("堆化后：");
		Utils.print(array);
		for (int i = array.length-1; i>=0; i--) {
			Utils.swap(array, 0, i);//每次都和堆顶和最后一个元素交换
			minHeapFixDown(array,0,i - 1);//调整的范围要减小
		}
			
	}
	private static void minHeap(int[] array) {
		int n = array.length/2 - 1;
		for(int i=n;i>=0;i--) {
			minHeapFixDown(array,i,array.length - 1);
		}
	}

	private static void minHeapFixDown(int[] array, int root,int len) {
		//找到左右孩子节点
		int lChild = root*2 +1;
		int rChild = root*2 +2;
		//找到左右孩子比较小的那个,准备和根节点比较大小
		int min = lChild;
		if(lChild > len) {
			return ;
		}
		if(rChild > len){
			min = lChild;
		}else {
			if(array[lChild] > array[rChild]) {
				min = rChild;
			}
		}
		//和根节点比较，如果小的话，那么不用调整
		if(array[root] <= array[min]) {
			return ;
		}else {
			//将根节点和较小的节点交换
			Utils.swap(array, min, root);
		}
		//递归
		minHeapFixDown(array, min,len);
	}

}
