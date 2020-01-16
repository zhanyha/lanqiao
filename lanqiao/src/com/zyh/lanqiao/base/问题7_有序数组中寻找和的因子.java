package com.zyh.lanqiao.base;

public class ����7_����������Ѱ�Һ͵����� {

	public static void main(String[] args) {
		int[] arr = new int[]{-4,-2,0,0,1,2,3,4,8,10};
		int sum = 10;
		StringBuilder sb = solution(arr,sum);
		System.out.println(sb);
		
	}

	private static StringBuilder solution(int[] arr,int sum) {
		int len =  arr.length;
		int left = 0;
		int right = len - 1;
		StringBuilder sb = new StringBuilder();
		while(left < right) {
			if(arr[left] + arr[right] == sum) {
				sb.append("("+arr[left]+","+arr[right]+")");
				left++;
				right--;
			}else if(arr[left] + arr[right] < sum) {
				left++;
			}else {
				right--;
			}
		}
		return sb;
	}

}
