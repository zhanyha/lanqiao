package com.zyh.lanqiao.dataStruct.tree.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 问题7_最低公共祖先LCA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(arr[a]==0) {
			System.out.println("ERROR: T["+a+"] is NULL");
			System.exit(0);
		}
		if(arr[b]==0) {
			System.out.println("ERROR: T["+b+"] is NULL");
			System.exit(0);
		}
		int[] res = solution(arr,a,b);
		if(res == null) {
			
		}else {
			System.out.println(res[0]+" "+res[1]);
		}
		sc.close();
	}

	private static int[] solution(int[] arr, int ai, int bi) {
		if(ai==bi) {
			return new int[] {ai,arr[ai]};
		}
		List<Integer> aa = new ArrayList<Integer>();
		while(ai>=1) {
			aa.add(arr[ai]);
			ai /=2;//找到父节点的下标
		}
		while(bi!=0) {
			bi /=2;//找到父节点的下标
			if(aa.contains(arr[bi])) {
				return new int[] {bi,arr[bi]};
			}
		}
		return null;
		
	}

}
