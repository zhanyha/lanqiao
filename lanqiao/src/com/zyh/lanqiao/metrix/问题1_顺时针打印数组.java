package com.zyh.lanqiao.metrix;

public class 问题1_顺时针打印数组 {
	
	public static void main(String[] args) {
		int[][] arr = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		solution(arr);
	}

	private static void solution(int[][] arr) {
		int leftUpRow=0,leftUpCol=0,rightDownRow=arr.length-1,rightDownCol=arr[0].length-1;
		int r = 0,c=0;
		while(r<=rightDownRow && c<=rightDownCol) {
			while(leftUpCol <= rightDownCol) {
				System.out.print(arr[leftUpRow][leftUpCol]+" ");
				leftUpCol++;
			}
			leftUpCol--;
			leftUpRow++;
			while(leftUpRow <=  rightDownRow) {
				System.out.print(arr[leftUpRow][leftUpCol]+" ");
				leftUpRow++;
			}
			leftUpRow--;
			leftUpCol--;
			while(leftUpCol >= c) {
				System.out.print(arr[leftUpRow][leftUpCol]+" ");
				leftUpCol--;
			}
			leftUpCol++;
			leftUpRow--;
			while(leftUpRow >  r) {
				System.out.print(arr[leftUpRow][leftUpCol]+" ");
				leftUpRow--;
			}
			leftUpRow++;
			leftUpCol++;
			r++;
			c++;
			rightDownCol--;
			rightDownRow--;
		}
		
	}
	
}
