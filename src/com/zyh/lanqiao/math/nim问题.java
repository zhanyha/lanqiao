package com.zyh.lanqiao.math;
/**
 * �м���ʯ�ӣ��������ã������˶����������㷨�����������Ǹ���Ӯ
 * ���ڸ���һ�����棬�����ж��ܷ�һ��Ӯ
 * @author zhanyuhao
 *
 */
public class nim���� {

	public static void main(String[] args) {
		int[] arr = new int[] {2,5,7};
		int res = nim(arr);
		if(res == 0) {
			System.out.println("һ����");
		}else {
			System.out.println("һ��Ӯ");
		}
	}

	private static int nim(int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res  = res ^ arr[i];
		}
		return res;
	}

}
