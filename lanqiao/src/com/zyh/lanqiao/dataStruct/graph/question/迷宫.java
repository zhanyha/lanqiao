package com.zyh.lanqiao.dataStruct.graph.question;

import java.util.Scanner;

/**
 * https://vjudge.net/problem/POJ-3984
* @author zhanyuhao
* @version ����ʱ�䣺2020��2��17�� ����3:07:35
* ��˵��
 */
public class �Թ� {
	static String[][] graph = new String[5][5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < graph.length; i++) {
			graph[i] = sc.nextLine().split(" ");
		}
		sc.close();
	}

}
