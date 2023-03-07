package com.zyh.lanqiao.dataStruct.graph.bridge;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Description FindBridgeFromGragh——寻找割点的算法
 * @Author zhanyuhao
 * @Date 2020/2/20 7:21
 **/
public class FindCutPoints {
    private TreeSet<Integer>[] treeSet;
    private boolean[] visited;
    private int[] ord;//代表顶点被访问到的次序
    private int[] low;//代表该顶点v不走回头路所能到达的被访问最小次序low[v]的那个顶点
    private int k=-1;
    private ArrayList<Integer> cutpoints = new ArrayList<Integer>();
    public FindCutPoints(Scanner sc){
        int v = sc.nextInt();
        int e = sc.nextInt();
        treeSet = new TreeSet[v];
        visited = new boolean[v];
        ord = new int[v];
        low = new int[v];
        for (int i = 0; i < v; i++)
            treeSet[i] = new TreeSet<Integer>();

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            treeSet[a].add(b);
            treeSet[b].add(a);
        }
        for (int w = 0; w < v; w++) 
        	if(!visited[w])
        		dfs(w,w);
    }

    private void dfs(int v,int parent) {
        visited[v] = true;
        ord[v] = ++k;
        low[v] = k;
        int child =0;
        for (int w : adj(v))
            if(!visited[w]) {
                dfs(w, v);
                low[v] = Math.min(low[w],low[v]);
                if(v!=parent && low[w] >= ord[v]){
                    cutpoints.add(v);
                }
                child++;
                if(v == parent && child > 1) {
                	cutpoints.add(v);
                }
            }else if(w!=parent) {
                low[v] = Math.min(low[w],low[v]);
            }
    }


    public ArrayList<Integer> getBridge(){
        return cutpoints;
    }
    public Iterable<Integer> adj(int i){
        return treeSet[i];
    }

    public static void main(String[] args) {
        FindCutPoints findPoints = new FindCutPoints(new Scanner(System.in));
        System.out.println(findPoints.getBridge());
    }
}
