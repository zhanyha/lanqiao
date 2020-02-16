package com.zyh.lanqiao.dataStruct.graph.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 图的最短路径_Dijkstra——
 * @Author zhanyuhao
 * @Date 2020/2/16 22:24
 **/
public class 图的最短路径_Dijkstra {
    static int[][] graph = {
            {0, 2, 5, 0, 0, 0, 0},
            {2, 0, 4, 6, 10, 0, 0},
            {5, 4, 0, 2, 0, 0, 0},
            {0, 6, 2, 0, 0, 1, 0},
            {0, 10, 0, 0, 0, 3, 5},
            {0, 0, 0, 1, 3, 0, 9},
            {0, 0, 0, 0, 5, 9, 0}
    };
    static int n = graph.length;
    static int[] distance = new int[n];
    static List<Integer> vertex = new ArrayList<>();
    static int[] vis = new int[n];
    public static void main(String[] args) {
        dijkstra(1);
    }

    private static void dijkstra(int start) {
        init(start);
        while (vertex.size()!=n) {
            int min = getMin(distance);
            vis[min] = 1;//标记
            vertex.add(min);
            for (int i = 0; i < graph[min].length; i++) {
                if (vis[i]==0 && graph[min][i] > 0) {
                    if (graph[min][i] + distance[min] < distance[i]) {
                        distance[i] = graph[min][i] + distance[min];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(distance[i]+" ");
            }
            System.out.println();
        }
    }

    private static void init(int start) {
        for (int i = 0; i < n; i++) {
            if (graph[start][i] > 0) {
                distance[i] = graph[start][i];
            } else
                distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        vertex.add(start);
        vis[start]=1;//标记
    }

    private static int getMin(int[] distance) {
        int min=0;
        for (int i = 0; i < distance.length; i++) {
            if(vis[i]==0)
                min = i;
        }
        for (int i = 0; i < distance.length; i++) {
            if (vis[i]==0 && distance[i] < distance[min])
                min = i;
        }
        return min;
    }

}

