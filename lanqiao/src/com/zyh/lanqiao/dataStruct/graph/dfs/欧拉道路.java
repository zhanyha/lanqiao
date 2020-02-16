package com.zyh.lanqiao.dataStruct.graph.dfs;

import java.util.Stack;

public class ŷ����· {
    static String[] s = {"a", "b", "c", "d"};
    static int[][] arr = {
            {0, 1, 2, 1},
            {1, 0, 0, 0},
            {2, 0, 0, 1},
            {1, 0, 1, 0}
    };
    static int start = 0;
    static int[] vis = new int[s.length];
    static Stack<String> stk = new Stack<>();
    public static void main(String[] args) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                res[i] += arr[i][j];
            }
            if (res[i] % 2 != 0) start = i;
        }
        vis[start]=1;
        //System.out.println(havePath(res));
        if (havePath(res))
            getPath(start);
        while (!stk.isEmpty()){
            System.out.println(stk.pop());
        }
    }

    private static void getPath(int start) {
        for (int i = 0; i < arr[start].length; i++) {
            if (arr[start][i]>0) {//û�б����ʶ����е�· ���� �����ʹ����ǻ��е�·�Ϳ�����̽
                arr[start][i]--;//��·����1
                arr[i][start]--;
                vis[i]=1;//��Ƿ��ʹ�
                getPath(i);
                stk.push(s[start]+"-->"+s[i]);//��һ�в������뵽����һ�е���˼����֮ͨ��ż���ջ��
            }
        }
    }
    /**
     * ��һ��д���˵ݹ�ӻ��ݵķ�������Ҫ�ж��Ƿ��Ѿ�����
     */
    /*private static boolean isOk() {
        int cnt=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j]==0){
                    cnt++;
                }else{
                    return false;
                }
            }
        }
        if(cnt==arr.length*arr.length){
            return true;
        }
        return false;
    }*/

    /**
     * �����һ��������ͨͼ�������ֻ�����������(����Ϊ������)����һ������ŷ����·
     *
     * @param res
     * @return �Ƿ����ŷ����·
     */
    private static boolean havePath(int[] res) {
        int cnt = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] % 2 != 0) cnt++;
        }
        return cnt <= 2;
    }
}
