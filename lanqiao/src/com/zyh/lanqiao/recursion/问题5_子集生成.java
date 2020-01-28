package com.zyh.lanqiao.recursion;

import java.util.HashSet;

/**
 * 返回一个集合的所有子集
 * @author zhanyuhao
 *
 */
public class 问题5_子集生成 {
	static int[] arr;
	static int n;
	public static void main(String[] args) {
		arr = new int[] {1,2,3};
		n = arr.length;
//		HashSet<Integer> set = new HashSet<Integer>();
//		dfs(set,0);
		
//		HashSet<HashSet<String>> res = recursion(n-1);
//		for (HashSet<String> hashSet : res) {
//			System.out.print(hashSet.toString()+" ");
//		}
		HashSet<HashSet<String>> res = iteration();
		for (HashSet<String> hashSet : res) {
			System.out.print(hashSet.toString()+" ");
		}
	}
	
	private static HashSet<HashSet<String>> iteration() {
		HashSet<HashSet<String>> oldSet = new HashSet<HashSet<String>>();
		HashSet<String> nil = new HashSet<String>();
		HashSet<String> first = new HashSet<String>();
		first.add(arr[0]+"");
		oldSet.add(nil);
		oldSet.add(first);
		//从第二个元素开始考虑，因为第一个在这之前已经考虑了,所以i=1;
		for (int i = 1; i < arr.length; i++) {
			HashSet<HashSet<String>> newSet = new HashSet<HashSet<String>>();
			for (HashSet<String> everySet : oldSet) {
				newSet.add(everySet);//保留原样
				HashSet<String> clone = (HashSet<String>) everySet.clone();
				clone.add(arr[i]+"");//加入当前元素
				//都要加入到newSet当中
				newSet.add(clone);
			}
			//每次迭代都要更新oldSet为这次的newSet，用于下一次迭代
			oldSet = newSet;
		}
		return oldSet;
	}

	/**
	 * 递归的方式求解
	 * @param cur
	 * @return 所有子集
	 */
	private static HashSet<HashSet<String>> recursion(int cur) {
		HashSet<HashSet<String>> newSet = new HashSet<HashSet<String>>();
		if(cur == 0) {//处理第一个元素
			HashSet<String> nil = new HashSet<String>();
			HashSet<String> first = new HashSet<String>();
			first.add(arr[0]+"");
			newSet.add(nil);
			newSet.add(first);
			return newSet;
		}
		HashSet<HashSet<String>> oldSet = recursion(cur-1);//取到上一次的集合
		//对每个集合中的元素都考虑加和不加当前的元素。
		for (HashSet<String> set : oldSet) {
			//不加
			newSet.add(set); //保留原样
			//加
			HashSet<String> clone = (HashSet<String>) set.clone();
			clone.add(arr[cur]+"");
			newSet.add(clone);
		}
		return newSet;
	}
	/**
	 * 深度优先搜索的方式解
	 * @param set 存放结果
	 * @param cur 当前是指向集合中的第几个元素
	 */
	private static void dfs(HashSet<Integer> set,int cur) {
		if(cur == n) {
			for (Integer integer : set) {
				System.out.print(integer);
			}
			System.out.print(" ");
			return;
		}
		dfs(set,cur+1);
		set.add(arr[cur]);
		dfs(set,cur+1);
		set.remove(arr[cur]);
	}

}
