package com.zyh.lanqiao.dataStruct.graph.dfs;

import java.util.Stack;

public class �������� {
    static String[] v = {"1", "2", "3", "4", "5", "6"};
    static int[][] graph = {
            {0, 1, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0},
    };
    static int[] visited = new int[v.length];
    static Stack<String> stk = new Stack<>();

    public static void main(String[] args) {
        for (int i = 0; i < v.length; i++) {
            if (visited[i] <= 0) {//�ڵ�û�б�����
				boolean bool = dfs(i);
				if(!bool){
					System.out.println("�л�ͼ�����ܽ����������򣡣���");
					System.exit(0);
				}
			}
        }
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
    }

    private static boolean dfs(int i) {
        visited[i] = -1;//���ڱ��ݹ�
        for (int j = 0; j < v.length; j++) {
            if (graph[i][j] == 1) {//����ýڵ㻹�г���
                if (visited[j] == -1) return false;//�ַ��ʵ���ǰ��Ľڵ㣬˵���γ��˻�
                if (visited[j] == 1) continue;
                if(!dfs(j)) return false;
            }
        }
        visited[i] = 1;//��Ǳ�ѹջ��
        stk.push(v[i]);
        return true;
    }

}
