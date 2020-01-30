package com.zyh.lanqiao.utils;

public class Utils {
	/**
	 * 打印功能
	 * 
	 * @param number
	 */
	public static void print(int number) {
		System.out.println(number);
	}

	public static void print(float number) {
		System.out.println(number);
	}

	public static void print(double number) {
		System.out.println(number);
	}

	public static void print(char ch) {
		System.out.println(ch);
	}

	public static void print(String str) {
		System.out.println(str);
	}

	public static <T> void print(T object) {
		System.out.println(object.toString());
	}

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void print(char[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void print(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 生成一个长度为len的随机数组
	 * 
	 * @param len
	 * @return
	 */
	public static int[] randomArray(int len) {
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 50);
		}
		return arr;
	}

	/**
	 * 生成一个从start开始到end的长度为len随机数组
	 * 
	 * @param start
	 * @param end
	 * @param len
	 * @return
	 */
	public static int[] randomArray(int start, int end, int len) {
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (end - start)) + start;
		}
		return arr;
	}

	/**
	 * 交换数组中下标为a的和小标为b的数
	 * 
	 * @param array
	 * @param a
	 * @param b
	 */
	public static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void swap(String[] array, int a, int b) {
		String tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void copyArray(int[] target, int[] source) {
		int len = source.length;
		while (--len >= 0) {
			target[len] = source[len];
		}
	}

	public static void main(String[] args) {
		int[] array = randomArray(1, 100, 10);
		print(array);
	}

}
