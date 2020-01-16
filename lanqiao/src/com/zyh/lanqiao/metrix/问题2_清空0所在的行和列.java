package com.zyh.lanqiao.metrix;

import java.util.ArrayList;
import java.util.List;

class Answer{
	List<Integer> col;
	List<Integer> row;
}
public class 问题2_清空0所在的行和列 {
	
	public static void main(String[] args) {
		int[][] arr = new int[][] {
			{1,1,1,1},
			{1,0,1,1},
			{1,1,0,1},
			{1,1,1,1},
		};
		Answer answer = solution(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(answer.col.contains(j)||answer.row.contains(i)) {
					System.out.print(0+" ");
				}
				else {
					System.out.print(arr[i][j]+" ");
				}
			}
			System.out.println();
		}
	}

	private static Answer solution(int[][] arr) {
		Answer ans = new Answer();
		ans.col = new ArrayList<Integer>();
		ans.row = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j] == 0) {
					ans.col.add(j);
					ans.row.add(i);
				}
			}
		}
		return ans;
	}
}
