package com.zyh.lanqiao.dp;

import java.util.Scanner;

/**
 * Serling公司购买长钢条，将其切割为短钢条出售。切割工序本身没有成本支出。
 * 公司管理层希望知道最佳的切割方案。假定我们知道Serling公司出售
 * 一段长为i英寸的钢条的价格为pi(i=1,2,…，单位为美元)。
 * 钢条的长度均为整英寸。图15-1给出了一个价格表的样例。
 * 1  2  3  4  5   6   7   8   9   10
 * 1  5  8  9  10  17  17  20  24  30 
 * 
 * @author zhanyuhao
 *钢条切割问题是这样的：给定一段长度为n英寸的钢条和一个价格表pi(i=1,2,…n)，
 *求切割钢条方案，使得销售收益rn最大。
 *注意，如果长度为n英寸的钢条的价格pn足够大，最优解可能就是完全不需要切割。
 */
//10
//1  2  3  4  5   6   7   8   9   10
//1  5  8  9  10  17  17  20  24  30 
public class 问题2_钢条切割问题 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] length = new int[n+1];
		int[] profit = new int[n+1];
		for (int i = 1; i <= n; i++) {
			length[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			profit[i] = sc.nextInt();
		}
		int len = sc.nextInt();
		int res = solution(length,profit,len);
		System.out.println(res);
		sc.close();
		
	}

	private static int solution(int[] length, int[] profit,int len) {
		int[] dp = new int[len+1];
		dp[1] = profit[1];
		int max = 0;
		int res = 0;
		for (int i = 2; i <= len; i++) {//从长度为2的钢条开始
			for (int j = 1; j <= i; j++) {//将钢条切割成两段，其中一段长度从1，2....，len/2;
				res = profit[j]+profit[i-j];
				if(max < res) {
					max = res;
				}
			}
			//显然dp[i]应该取tmp数组里面的最大值
			dp[i] = max;
		}
//		Utils.print(dp);
		return dp[len];
	}

}
