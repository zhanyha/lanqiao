package com.zyh.lanqiao.greedy;

import java.util.Arrays;
import java.util.Scanner;

import com.zyh.lanqiao.utils.Utils;


public class 问题4_区间打点问题 {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Section[] sections = new Section[N];
		for (int i = 0; i < N; i++) {
			sections[i] = new Section();
			sections[i].setStart(sc.nextInt());
			sections[i].setEnd(sc.nextInt());
			sections[i].setCount(sc.nextInt());
		}
		Arrays.sort(sections);
		int[] solution = solution(sections);
		Utils.print(solution);
		System.out.println(cnt);
		sc.close();
	}

	private static int[] solution(Section[] sections) {
		int max = sections[sections.length -1].getEnd();
		int[] arr = new int[max+1];
		int count = 1;
		for (int i = 0; i < sections.length; i++) {
			count = sections[i].getCount();
			count = update(count,arr,sections[i].getStart(),sections[i].getEnd());
			for (int j = sections[i].getEnd(); j >= sections[i].getStart(); j--) {
				if(count>0) {
					arr[j] = 1;//标记
					cnt++;
					count--;
				}else {
					break;
				}
			}
		}
		return arr;
	}

	private static int update(int count,int[] arr, int start, int end) {
		for (int i = start; i < end; i++) {
			if(arr[i] == 1) {
				count--;
			}
			if(count <=0) {
				break;
			}
		}
		return count;
	}

}
class Section implements Comparable<Section>{
	private int start;
	private int end;
	private int count;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int compareTo(Section o) {
		if(this.getEnd() - o.getEnd() > 0) {
			return 1;
		}
		if(this.getEnd() - o.getEnd() == 0) {
			return 0;
		}
		return -1;
	}
}
