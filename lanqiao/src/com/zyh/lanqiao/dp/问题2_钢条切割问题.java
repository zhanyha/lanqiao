package com.zyh.lanqiao.dp;

import java.util.Scanner;

/**
 * Serling��˾���򳤸����������и�Ϊ�̸������ۡ��и����û�гɱ�֧����
 * ��˾�����ϣ��֪����ѵ��и�����ٶ�����֪��Serling��˾����
 * һ�γ�ΪiӢ��ĸ����ļ۸�Ϊpi(i=1,2,������λΪ��Ԫ)��
 * �����ĳ��Ⱦ�Ϊ��Ӣ�硣ͼ15-1������һ���۸���������
 * 1  2  3  4  5   6   7   8   9   10
 * 1  5  8  9  10  17  17  20  24  30 
 * 
 * @author zhanyuhao
 *�����и������������ģ�����һ�γ���ΪnӢ��ĸ�����һ���۸��pi(i=1,2,��n)��
 *���и����������ʹ����������rn���
 *ע�⣬�������ΪnӢ��ĸ����ļ۸�pn�㹻�����Ž���ܾ�����ȫ����Ҫ�и
 */
//10
//1  2  3  4  5   6   7   8   9   10
//1  5  8  9  10  17  17  20  24  30 
public class ����2_�����и����� {

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
		for (int i = 2; i <= len; i++) {//�ӳ���Ϊ2�ĸ�����ʼ
			for (int j = 1; j <= i; j++) {//�������и�����Σ�����һ�γ��ȴ�1��2....��len/2;
				res = profit[j]+profit[i-j];
				if(max < res) {
					max = res;
				}
			}
			//��Ȼdp[i]Ӧ��ȡtmp������������ֵ
			dp[i] = max;
		}
//		Utils.print(dp);
		return dp[len];
	}

}
