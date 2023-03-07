package com.zyh.lanqiao.string;
import java.util.*;

public class ÎÊÌâ5_Ñ¹Ëõ×Ö·û´® {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String upperCase = line.toUpperCase();
		char[] a = upperCase.toCharArray();
		int[] res = new int[24];
		for (int i = 0; i < a.length; i++) {
			if(i+1<a.length&&a[i] == a[i+1]){
				res[a[i]-65]++;
			}else{
				res[a[i]-65]++;
				System.out.print("("+a[i]+","+res[a[i]-65]+")");
				res[a[i]-65] = 0;
			}
		}
		
		
		sc.close();
	}
	

}