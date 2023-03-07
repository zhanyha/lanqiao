package com.zyh.lanqiao.base;

import java.util.Arrays;
import java.util.Scanner;

import com.zyh.lanqiao.utils.Utils;

public class πÈ≤¢≈≈–Ú {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Utils.randomArray(8);
		Utils.print(arr);
		mergeSort(arr,0,arr.length-1);
		Utils.print(arr);
		sc.close();
	}

	static void mergeSort(int[] arr, int start, int end) {
		if(start<end) {
			int mid = (start + end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr,start,mid,end);
		}
	}
	static void merge(int[] arr, int start, int mid, int end) {
		int left = start;
		int right = mid + 1;
		int current = start;
		int[] copyArr = Arrays.copyOf(arr, arr.length);
		while(left <= mid && right <= end ) {
			if(copyArr[left] < copyArr[right]) {
				arr[current] = copyArr[left];
				left++;
				current++;
			}else{
				arr[current] = copyArr[right];
				right++;
				current++;
			}
		}
		while(left <= mid) {
			arr[current] = copyArr[left];
			left++;
			current++;
		}
	}

}
