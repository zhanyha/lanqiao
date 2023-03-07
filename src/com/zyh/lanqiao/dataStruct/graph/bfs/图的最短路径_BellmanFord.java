package com.zyh.lanqiao.dataStruct.graph.bfs;
/**
 * @Description 图的最短路径_BellmanFord——贝尔曼福特 三大最短路径算法之一
 * @Author zhanyuhao
 * @Date 2020/2/16 19:25
 * 算法核心思想：
 * 预处理：
 * 1.拟构一个点等于某一个顶点（起点随便找，那么起点目前只能到达该顶点，且距离为 0 ）
 * 2.初始化时将起点s到各个顶点v的距离dist(s->v)赋值为∞，dist(s->s)赋值为0
 * 算法：
 * 1.利用起点到已知的顶点距离，来更新到其他顶点的距离
 * 2.重复1，直到记录距离的数组不变化了
 **/
public class 图的最短路径_BellmanFord {
    static int[][] graph = {
            {0, 2, 5, 0, 0, 0, 0},
            {2, 0, 4, 6, 10, 0, 0},
            {5, 4, 0, 2, 0, 0, 0},
            {0, 6, 2, 0, 0, 1, 0},
            {0, 10, 0, 0, 0, 3, 5},
            {0, 0, 0, 1, 3, 0, 9},
            {0, 0, 0, 0, 5, 9, 0}
    };
    static int[] d = new int[7];
    static int n = graph.length;
    public static void main(String[] args) {
        init(1);
        bellmanFord();
    }
    private static void bellmanFord() {
        boolean flag = true;
        while(flag) {
            flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > 0) {//前提是要连通的
                        if (d[i] + graph[i][j] < d[j]) {
                            flag = true;
                            d[j] = d[i] + graph[i][j];
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(d[i]+" ");
            }
            System.out.println();
        }
    }

    private static void init(int s) {
        d[s]=0;
        for (int i = 0; i < d.length; i++) {
            if(i!=s) {
                if (graph[s][i] > 0) {
                    d[i] = graph[s][i];
                } else
                    d[i] = Integer.MAX_VALUE;
            }
        }
    }
}
