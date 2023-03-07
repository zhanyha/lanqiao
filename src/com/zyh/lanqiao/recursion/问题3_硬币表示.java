package com.zyh.lanqiao.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 假设我们有4种不同面值的硬币｛1，5，10，25｝， 用这些硬币组合构成一个给定的数值n。 例如n=100，那么一种可能的组合方式为 100 =
 * 2*25+5*5+2*10+5*1。 问总共有多少种可能的组合方式？
 * 
 * @author zhanyuhao
 *
 */
public class 问题3_硬币表示 {
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 25, 10, 5, 1 };
		int n = sc.nextInt();
		recursion(arr, n, 0);
		int res = solution(n);
		System.out.println(res);
		System.out.println(cnt);
		
		sc.close();
	}

	private static int solution(int n) {
         int[] coins = { 1, 5, 10, 25 };
         int[] dp = new int[n + 1];
         dp[0] = 1;
         for (int i = 0; i < 4; i++) {
             for (int j = coins[i]; j < n+1; j++) {
                 dp[j] = (dp[j]+dp[j-coins[i]]) % 1000000007;
             }
         }
         return dp[n];
	}

	private static void recursion(int[] arr, int n,int cur) {
		if(n == 0) {
			cnt++;
			Set<Integer> keySet = map.keySet();
			for (Integer integer : keySet) {
				System.out.println(integer+":"+map.get(integer));
			}System.out.println();
			return ;
		}
		if(n < 0 || cur > 3) 
			return ;
		for (int j = 0; j * arr[cur] <= n; j++) {
			if(j > 0)
				map.put(arr[cur], j);
			recursion(arr,n - j * arr[cur],cur+1);
		}
	}



}
