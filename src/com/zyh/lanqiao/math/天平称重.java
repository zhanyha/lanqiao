package com.zyh.lanqiao.math;

import java.util.*;

import com.zyh.lanqiao.utils.Utils;

/**
 * 进制的巧用
 * 说明：左盘放物体
 * @author zhanyuhao
 *
 */
public class 天平称重 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = toBinary(N);
		int num=1;
		Utils.print(arr);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 1) {
				System.out.printf("右盘放一个%d克的砝码",num);
			}else if(arr[i] == -1) {
				System.out.printf("左盘放一个%d克的砝码",num);
			}
			num=num * 3;
		}
		sc.close();
	}

	private static int[] toBinary(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append("0"+Integer.toString(n, 3)).reverse();
		char[] chs = sb.toString().toCharArray();
		int[] arr =  new int[sb.length()];
		for (int i = 0; i < chs.length; i++) {
			if(chs[i] == '1') {
				arr[i]=1;
			}
			else if(chs[i]=='2') {
				chs[i+1]++;
				arr[i] = -1;
			}else if(chs[i] == '3'){
				chs[i+1]++;
				arr[i] = 0;
			}
		}
		return arr;
	}

}
