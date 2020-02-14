package com.zyh.lanqiao.dataStruct.graph.dfs;

import java.util.Stack;

public class 拓扑排序 {
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
            if (visited[i] <= 0) {//节点没有被弹出
				boolean bool = dfs(i);
				if(!bool){
					System.out.println("有环图，不能进行拓扑排序！！！");
					System.exit(0);
				}
			}
        }
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
    }

    private static boolean dfs(int i) {
        visited[i] = -1;//正在被递归
        for (int j = 0; j < v.length; j++) {
            if (graph[i][j] == 1) {//如果该节点还有出度
                if (visited[j] == -1) return false;//又访问到了前面的节点，说明形成了环
                if (visited[j] == 1) continue;
                if(!dfs(j)) return false;
            }
        }
        visited[i] = 1;//标记被压栈过
        stk.push(v[i]);
        return true;
    }

}
