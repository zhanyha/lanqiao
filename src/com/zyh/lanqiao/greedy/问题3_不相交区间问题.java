package com.zyh.lanqiao.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**������������Ĺ���������ÿ����������ʼʱ��ͽ���ʱ�䣬��������������
 * ���룺
 * 5
 * 1 2 4 6 8 //��ʼʱ��
 * 3 5 7 9 10//����ʱ��
 * @author zhanyuhao
 *
 */
//5
//1 2 4 6 8
//3 5 7 9 10
public class ����3_���ཻ�������� {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Job[] jobs = new Job[N];
		for (int i = 0; i < N; i++) {
			jobs[i] = new Job();
			jobs[i].setStartTime(sc.nextInt());
		}
		for (int i = 0; i < N; i++) {
			jobs[i].setEndTime(sc.nextInt());
		}
		Arrays.sort(jobs);
		solution(jobs);
		System.out.println(cnt);
		sc.close();
	}

	private static void solution(Job[] jobs) {
		int p = 0;
		for (int i = 0; i < jobs.length; i++) {
			if(!jobs[i].exist(p)) {
				p = jobs[i].getEndTime();
				cnt++;
			}
		}
	}

}
class Job implements Comparable<Job>{
	private int startTime;
	private int endTime;
	
	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	@Override
	public int compareTo(Job o) {
		if(this.endTime > o.endTime) return 1;
		if(this.endTime == o.endTime) return 0;
		return -1;
	}
	public boolean exist(int p) {
		if(p<=this.endTime && p>= this.startTime) {
			return true;
		}
		return false;
	}
}
