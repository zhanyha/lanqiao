package com.zyh.lanqiao.dataStruct.tree.PTA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q4_ĞŞÀíÄÁ³¡ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());	
		}
		Collections.sort(list);
		int res=0;
		int add=0;
		int p=0;
		int i=0;
		while(i <= n-2) {
			add+=list.get(p)+list.get(p+1);
			res+=add;
			p+=2;
			for (int j = p; j < list.size(); j++) {
				if(list.get(j)>=add) {
					list.add(j, add);
					break;
				}
				if(j==list.size()-1) {
					list.add(res);
				}
			}
			add=0;
			i++;
		}
		System.out.println(res);
		sc.close();
	}

//	private static void insert(List<Integer> list, int res) {
//		for (int i = 0; i < list.size(); i++) {
//			if(list.get(i)>=res) {
//				list.add(i, res);
//				return;
//			}
//		}
//		list.add(res);
//	}

}
