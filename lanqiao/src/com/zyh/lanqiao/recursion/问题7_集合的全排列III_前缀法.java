package com.zyh.lanqiao.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * ǰ׺��: ÿ�δ�ͷɨ�輯�ϣ���֤�������򣩣�
 * ���ɨ��ĳ��Ԫ�ز��ڽ��������ͰѸ� Ԫ�ؼ��뵽�������
 * ��������ĳ��Ⱥ�ԭ���ϵĳ���һ���Ļ���˵������һ�����
 * 
 * @author zhanyuhao
 *
 */
public class ����7_���ϵ�ȫ����III_ǰ׺�� {

	public static void main(String[] args) {
		String[] arr = new String[] { "A", "B", "C" };
		int n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			List<String> suff = new ArrayList<String>();
			suff.add(arr[i]);
			recursion(arr, suff, n);
		}
	}

	private static void recursion(String[] arr, List<String> suff, int n) {
		if (suff.size() == n) {
			for (int i = 0; i < suff.size(); i++) {
				System.out.print(suff.get(i));
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {// ɨ��ÿ��Ԫ��
			if (check(arr, suff, i)) {
				suff.add(arr[i]);// ���뵽���������
				recursion(arr, suff, n);// �����ݹ���ȥ
				suff.remove(arr[i]);//����
			}
		}
	}

	private static boolean check(String[] arr, List<String> suff, int cur) {
		for (int i = 0; i < suff.size(); i++) {
			if(suff.get(i).equals(arr[cur])) {
				return false;
			}
		}
		return true;
	}

}
