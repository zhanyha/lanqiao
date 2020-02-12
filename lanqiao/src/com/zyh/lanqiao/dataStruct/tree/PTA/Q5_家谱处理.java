package com.zyh.lanqiao.dataStruct.tree.PTA;

import java.util.*;

public class Q5_���״��� {
	private static List<String> parent = new ArrayList<String>();//��Ÿ��ڵ�
	private static Map<String, String> cp = new HashMap<String, String>();//��Ÿ��ӽڵ�
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();sc.nextLine();
		String line=null;
		int start=0;
		int end=0;
		int cnt=0;//�ո���ֵĴ���
		String name = null;
		for (int i = 0; i < n; i++) {
			line = sc.nextLine();
			start = line.indexOf(" ");
			end = line.lastIndexOf(" ");
			cnt = end - start+1;
			if(end==-1)
				cnt=0;
//			System.out.println(cnt);
			//1.�õ�����s
			name = line.substring(cnt);
			//2.��ŵ�cp����
			if(cnt/2-1>=0) {
				cp.put(name, parent.get(cnt/2-1));
				parent.add(cnt/2, name);//���Լ����븸�ڵ㡣�������ĺ���Ѱ��
			}
			else {
				cp.put(name, null);//���ڵ�
				parent.add(0, name);
			}
		}
		String[] strs=null;
		boolean entry = false;
		boolean flag=false;
		for (int i = 0; i < m; i++) {
			String s = sc.nextLine();
			strs = s.split(" ");
			for (String str : strs) {
				if (!entry) {
					switch (str) {
						case "child":
							flag = cp.get(strs[0]).equals(strs[5]);
							entry = true;
							break;
						case "the":
							flag = cp.get(strs[5]).equals(strs[0]);
							entry = true;
							break;
						case "sibling":
							flag = cp.get(strs[5]).equals(cp.get(strs[0]));
							entry = true;
							break;
						case "an":
							entry = true;
							String ancestor = cp.get(strs[5]);
							while (ancestor != null) {
								if (ancestor.equals(strs[0])) {
									flag = true;
									break;
								}
								ancestor = cp.get(ancestor);
							}
							break;
						case "descendant":
							entry = true;
							String descendant = cp.get(strs[0]);
							while (descendant != null) {
								if (descendant.equals(strs[5])) {
									flag = true;
									break;
								}
								descendant = cp.get(descendant);
							}
							break;
						default:
							break;
					}
				} else
					break;
			}
			entry = false;
			if(flag) {
				System.out.println("True");
			}else
			System.out.println("False");
			flag = false;
		}
		sc.close();
	}
}
//6 5
//ff
//  ee
//    dd
//      cc
//        bb
//          aa
//aa is a child of bb
//dd is an ancestor of aa
//cc is a sibling of ee
//ee is the parent of dd
//ee is a descendant of aa
