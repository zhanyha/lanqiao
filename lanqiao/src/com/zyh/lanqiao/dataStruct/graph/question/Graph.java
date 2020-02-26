package com.zyh.lanqiao.dataStruct.graph.question;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Description Graph——用于解决图的存储问题
 * @Author zhanyuhao
 * @Date 2020/2/25 23:12
 **/
public class Graph {
    private int V;
    private int E;
    private TreeSet<Integer>[] treeSet;
    private int[] degree;
    public Graph(Scanner sc) {
        this.V = sc.nextInt();
        this.E = sc.nextInt();
        treeSet = new TreeSet[V];
        degree = new int[V];
        for (int i = 0; i < V; i++)
            treeSet[i] = new TreeSet<Integer>();
        int a, b;
        for (int i = 0; i < E; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            treeSet[a].add(b);
            treeSet[b].add(a);
            degree[a]++;
            degree[b]++;
        }
    }
    public Iterable<Integer> adj(int v) {
        return treeSet[v];
    }
    public int degree(int v){
        return degree[v];
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
}
