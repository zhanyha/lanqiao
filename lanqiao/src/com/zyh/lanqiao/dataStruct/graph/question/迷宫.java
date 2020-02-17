package com.zyh.lanqiao.dataStruct.graph.question;

import java.util.Scanner;

/**
 * https://vjudge.net/problem/POJ-3984
* @author zhanyuhao
* @version 创建时间：2020年2月17日 下午3:07:35
* 类说明
 */
public class 迷宫 {
	static String[][] graph = new String[5][5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < graph.length; i++) {
			graph[i] = sc.nextLine().split(" ");
		}
		sc.close();
	}

}
