package com.zyh.lanqiao.math;

import java.util.*;

public class 质因数分解 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 2;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		while(n!=1) {
			if(n % i == 0) {
				if(map.get(i) == null) {
					map.put(i, 1);
				}else {
					map.put(i,map.get(i)+1);
				}
				n = n/i;
			}else {
				i++;
			}
		}
		Iterator<Integer> it = map.keySet().iterator();
		StringBuilder sb = new StringBuilder();
		while(it.hasNext()) {
			Integer k = it.next();
			sb.append("*"+k+"^"+map.get(k));
		}
		System.out.println(sb.toString().substring(1));
		
		sc.close();
	}

}
