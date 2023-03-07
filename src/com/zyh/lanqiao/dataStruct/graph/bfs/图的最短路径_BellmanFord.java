package com.zyh.lanqiao.dataStruct.graph.bfs;
/**
 * @Description ͼ�����·��_BellmanFord�������������� �������·���㷨֮һ
 * @Author zhanyuhao
 * @Date 2020/2/16 19:25
 * �㷨����˼�룺
 * Ԥ����
 * 1.�⹹һ�������ĳһ�����㣨�������ң���ô���Ŀǰֻ�ܵ���ö��㣬�Ҿ���Ϊ 0 ��
 * 2.��ʼ��ʱ�����s����������v�ľ���dist(s->v)��ֵΪ�ޣ�dist(s->s)��ֵΪ0
 * �㷨��
 * 1.������㵽��֪�Ķ�����룬�����µ���������ľ���
 * 2.�ظ�1��ֱ����¼��������鲻�仯��
 **/
public class ͼ�����·��_BellmanFord {
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
                    if (graph[i][j] > 0) {//ǰ����Ҫ��ͨ��
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
