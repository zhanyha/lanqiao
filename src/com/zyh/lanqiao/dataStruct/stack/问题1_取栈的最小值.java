package com.zyh.lanqiao.dataStruct.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 维护一个栈，使得取得栈的最小值的时间复杂度为O(1)
 * 输入4 2 3 1 5 6
 * 输出4 2 2 1 1 1
 * @author zhanyuhao
 *思路：用空间换时间的思路，新建一个栈，每次压栈的时候，
 *和新的栈的最小值进行比较，如果大就不管，如果小的话就压栈。
 */
//6
//4 2 3 1 5 6
public class 问题1_取栈的最小值 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stk = new Stack<Integer>();
		Stack<Integer> min = new Stack<Integer>();
		int n = sc.nextInt();
		int m = 0;
		for (int i = 0; i < n; i++) {
			m = sc.nextInt();
			stk.add(m);
			System.out.print(solution(min,m)+" ");
		}
		System.out.println();
		System.out.println(solutionPop(min,stk.pop()));
		System.out.println(solutionPop(min,stk.pop()));
		System.out.println(solutionPop(min,stk.pop()));
		System.out.println(solutionPop(min,stk.pop()));
		System.out.println(solutionPop(min,stk.pop()));
		sc.close();
	}

	private static int solutionPop(Stack<Integer> min, Integer pop) {
		if(pop <= min.peek()) {
			min.pop();
		}
		return min.peek();
	}

	private static int solution(Stack<Integer> min, int m) {
		if(min == null) {
			System.err.println("栈为空");
			System.exit(0);
		}
		if(min.size()==0) {
			min.push(m);
		}else if(m < min.peek()){
			min.push(m);
		}
		return min.peek();//查看栈顶元素值
	}

}
