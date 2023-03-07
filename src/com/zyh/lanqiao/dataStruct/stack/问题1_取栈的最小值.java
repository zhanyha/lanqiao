package com.zyh.lanqiao.dataStruct.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * ά��һ��ջ��ʹ��ȡ��ջ����Сֵ��ʱ�临�Ӷ�ΪO(1)
 * ����4 2 3 1 5 6
 * ���4 2 2 1 1 1
 * @author zhanyuhao
 *˼·���ÿռ任ʱ���˼·���½�һ��ջ��ÿ��ѹջ��ʱ��
 *���µ�ջ����Сֵ���бȽϣ������Ͳ��ܣ����С�Ļ���ѹջ��
 */
//6
//4 2 3 1 5 6
public class ����1_ȡջ����Сֵ {

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
			System.err.println("ջΪ��");
			System.exit(0);
		}
		if(min.size()==0) {
			min.push(m);
		}else if(m < min.peek()){
			min.push(m);
		}
		return min.peek();//�鿴ջ��Ԫ��ֵ
	}

}
