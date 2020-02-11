package com.zyh.lanqiao.hash;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://pintia.cn/problem-sets/988034414048743424/problems/988039370067709952
* @author zhanyuhao
* @version 创建时间：2020年2月11日 下午2:16:16
* 类说明
 */
public class 问题1_树种统计 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();sc.nextLine();
		String str= null;
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			str = sc.nextLine();
			if(map.get(str)==null) {
				map.put(str,1);
			}else {
				map.put(str, map.get(str)+1);
			}
		}
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		float precent = 0.0000f;
		for (Entry<String, Integer> entry : entrySet) {
			precent = entry.getValue()*10000000/n;
			precent/=10;
			precent = Math.round(precent);
			precent/=10000;
			System.out.printf("%s %.4f",entry.getKey(),precent);
			System.out.println("%");
		}
		sc.close();
	}

}
