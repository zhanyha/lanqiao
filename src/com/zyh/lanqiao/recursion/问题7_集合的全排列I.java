package com.zyh.lanqiao.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * �������ŵĲ��뷽ʽ������A ��һ���ַ���B��B���Բ��뵽A����ߺ��ұ� ��������AB �� BA �ֲ���C,C���Բ��뵽 AB������������λ�ã���������
 * 
 * @author zhanyuhao
 *
 */
public class ����7_���ϵ�ȫ����I {
	static int[] arr;
	static int n;

	public static void main(String[] args) {
		arr = new int[] { 1, 2, 3 };
		n = arr.length;
//		recursion(arr[0]+"",1);
		List<String> list = iteration();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	/**
	 * �����ķ�ʽ���
	 * @return
	 */
	private static List<String> iteration() {
		List<String> oldList = new ArrayList<String>();
		oldList.add(arr[0] + "");
		for (int i = 1; i < n; i++) {// ����ÿһ��Ԫ�ض�Ҫ���뵽���Ľ������
			List<String> newList = new ArrayList<String>();
			for (int j = 0; j < oldList.size(); j++) {//����һ������(����{AB,BA})�е�ÿ��Ԫ����˵
				for (int k = 0; k <= oldList.get(j).length(); k++) {//��Ҫ��ÿ���ַ������߲����µ��ַ�����A Ҫ����B ������AB��BA
					newList.add(oldList.get(j).substring(0, k) + arr[i] + oldList.get(j).substring(k));
				}
			}
			oldList = newList;//����oldList������һ�μ�������
		}
		return oldList;//���һ�ֵ������
	}

	/**
	 * �ݹ鷽ʽ���
	 * 
	 * @param before
	 * @param cur
	 */
	private static void recursion(String before, int cur) {
		if (cur == n) {
			System.out.println(before);
			return;
		}
		for (int i = 0; i <= before.length(); i++) {
			String newBefore = before.substring(0, i) + arr[cur] + before.substring(i);
			recursion(newBefore, cur + 1);
		}
	}

}
