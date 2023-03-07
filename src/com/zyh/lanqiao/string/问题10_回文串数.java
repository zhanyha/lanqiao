package com.zyh.lanqiao.string;
/**
 * 输出所有的四位数的回文数比如1221
 * @author zhanyuhao
 *
 */
public class 问题10_回文串数 {
	static int N =10;
	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.println(i+""+j+""+j+""+i);
			}
		}
	}

}
