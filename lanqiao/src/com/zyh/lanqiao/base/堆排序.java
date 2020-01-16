package com.zyh.lanqiao.base;

import com.zyh.lanqiao.utils.Utils;

public class ������ {

	public static void main(String[] args) {
		//{15, 25, 11 ,48 ,1, 6, 49 ,46 }
		int[] array = Utils.randomArray(8);
		Utils.print(array);
		minHeapSort(array,0,array.length - 1);
		Utils.print(array);
	}
	private static void minHeapSort(int[] array,int start,int end) {
		minHeap(array);//����ѻ�
		Utils.print("�ѻ���");
		Utils.print(array);
		for (int i = array.length-1; i>=0; i--) {
			Utils.swap(array, 0, i);//ÿ�ζ��ͶѶ������һ��Ԫ�ؽ���
			minHeapFixDown(array,0,i - 1);//�����ķ�ΧҪ��С
		}
			
	}
	private static void minHeap(int[] array) {
		int n = array.length/2 - 1;
		for(int i=n;i>=0;i--) {
			minHeapFixDown(array,i,array.length - 1);
		}
	}

	private static void minHeapFixDown(int[] array, int root,int len) {
		//�ҵ����Һ��ӽڵ�
		int lChild = root*2 +1;
		int rChild = root*2 +2;
		//�ҵ����Һ��ӱȽ�С���Ǹ�,׼���͸��ڵ�Ƚϴ�С
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
		//�͸��ڵ�Ƚϣ����С�Ļ�����ô���õ���
		if(array[root] <= array[min]) {
			return ;
		}else {
			//�����ڵ�ͽ�С�Ľڵ㽻��
			Utils.swap(array, min, root);
		}
		//�ݹ�
		minHeapFixDown(array, min,len);
	}

}
