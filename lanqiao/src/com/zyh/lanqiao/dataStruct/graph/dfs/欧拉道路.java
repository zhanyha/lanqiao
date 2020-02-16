package com.zyh.lanqiao.dataStruct.graph.dfs;

import java.util.Stack;

public class 欧拉道路 {
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
            if (arr[start][i]>0) {//没有被访问而且有道路 或者 被访问过但是还有道路就可以试探
                arr[start][i]--;//道路数减1
                arr[i][start]--;
                vis[i]=1;//标记访问过
                getPath(i);
                stk.push(s[start]+"-->"+s[i]);//这一行不容易想到。这一行的意思是走通之后才加入栈中
            }
        }
    }
    /**
     * 第一次写用了递归加回溯的方法，需要判断是否已经走完
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
     * 如果是一个无向连通图，且最多只存在两个奇点(度数为奇数的)，则一定存在欧拉道路
     *
     * @param res
     * @return 是否存在欧拉道路
     */
    private static boolean havePath(int[] res) {
        int cnt = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] % 2 != 0) cnt++;
        }
        return cnt <= 2;
    }
}
