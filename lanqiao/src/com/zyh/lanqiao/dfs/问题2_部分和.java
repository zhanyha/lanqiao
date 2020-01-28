package com.zyh.lanqiao.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class 问题2_部分和 {
	static int n;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[]{1,2,4,7};
		n = sc.nextInt();
		ArrayList<Integer> ints = new ArrayList<Integer>();
		dfs(n,0,ints);
		
		sc.close();
	}
	private static void dfs(int sum,int cur,ArrayList<Integer> ints) {
		if(sum == 0) {
			for (int i = 0; i < ints.size(); i++) {
				System.out.print(ints.get(i)+" ");
			}
			System.exit(0);
		}
		if(sum <0 || cur >= arr.length) {
			return ;
		}
		dfs(sum,cur+1,ints);
		ints.add(arr[cur]);
		int index = ints.size() - 1;
		dfs(sum - arr[cur],cur+1,ints);
		ints.remove(index);//回溯
	}
}
