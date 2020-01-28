package com.zyh.lanqiao.recursion;

import java.util.HashSet;

/**
 * ����һ�����ϵ������Ӽ�
 * @author zhanyuhao
 *
 */
public class ����5_�Ӽ����� {
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
		//�ӵڶ���Ԫ�ؿ�ʼ���ǣ���Ϊ��һ������֮ǰ�Ѿ�������,����i=1;
		for (int i = 1; i < arr.length; i++) {
			HashSet<HashSet<String>> newSet = new HashSet<HashSet<String>>();
			for (HashSet<String> everySet : oldSet) {
				newSet.add(everySet);//����ԭ��
				HashSet<String> clone = (HashSet<String>) everySet.clone();
				clone.add(arr[i]+"");//���뵱ǰԪ��
				//��Ҫ���뵽newSet����
				newSet.add(clone);
			}
			//ÿ�ε�����Ҫ����oldSetΪ��ε�newSet��������һ�ε���
			oldSet = newSet;
		}
		return oldSet;
	}

	/**
	 * �ݹ�ķ�ʽ���
	 * @param cur
	 * @return �����Ӽ�
	 */
	private static HashSet<HashSet<String>> recursion(int cur) {
		HashSet<HashSet<String>> newSet = new HashSet<HashSet<String>>();
		if(cur == 0) {//�����һ��Ԫ��
			HashSet<String> nil = new HashSet<String>();
			HashSet<String> first = new HashSet<String>();
			first.add(arr[0]+"");
			newSet.add(nil);
			newSet.add(first);
			return newSet;
		}
		HashSet<HashSet<String>> oldSet = recursion(cur-1);//ȡ����һ�εļ���
		//��ÿ�������е�Ԫ�ض����ǼӺͲ��ӵ�ǰ��Ԫ�ء�
		for (HashSet<String> set : oldSet) {
			//����
			newSet.add(set); //����ԭ��
			//��
			HashSet<String> clone = (HashSet<String>) set.clone();
			clone.add(arr[cur]+"");
			newSet.add(clone);
		}
		return newSet;
	}
	/**
	 * ������������ķ�ʽ��
	 * @param set ��Ž��
	 * @param cur ��ǰ��ָ�򼯺��еĵڼ���Ԫ��
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
